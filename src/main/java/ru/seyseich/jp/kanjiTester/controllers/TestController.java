package ru.seyseich.jp.kanjiTester.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.seyseich.jp.kanjiTester.controllers.model.JsCheckedWord;
import ru.seyseich.jp.kanjiTester.controllers.model.JsWord;
import ru.seyseich.jp.kanjiTester.controllers.requests.CheckWordRequest;
import ru.seyseich.jp.kanjiTester.controllers.responses.CheckWordResponse;
import ru.seyseich.jp.kanjiTester.controllers.responses.WordForTestResponse;
import ru.seyseich.jp.kanjiTester.controllers.responses.WordResultResponse;
import ru.seyseich.jp.kanjiTester.data.entities.Word;
import ru.seyseich.jp.kanjiTester.data.services.IWordService;
import ru.seyseich.jp.kanjiTester.supplementary.Log;

@Controller
@RequestMapping( "/test" )
public class TestController
{
	private static final String TOTAL_WORDS_AMOUNT = "total-words-amount";
	private static final String CORRECT_WORDS_AMOUNT = "correct-words-amount";
	private static final String ERROR_WORD_IDS = "error-words-id";
	private static final String LAST_WORD_ID = "last-word-id";
	
	@Autowired
	@Qualifier( "dummyWordService" )
	private IWordService _wordService;
	
	@RequestMapping( value = "/pages/word", method = RequestMethod.GET )
	public String getWordTest( HttpSession session )
	{
		List< Word > words = _wordService.fetchRandomWords( null, -1 );
		StringBuilder seq = new StringBuilder( );
		boolean isFirst = true;
		for ( Word word : words )
		{
			if ( isFirst )
				isFirst = false;
			else
				seq.append( ";" );
			
			seq.append( word.getId( ) );
		}
		
		session.setAttribute( "sequence", seq.toString( ) );
		session.setAttribute( TOTAL_WORDS_AMOUNT, words.size( ) );
		session.setAttribute( CORRECT_WORDS_AMOUNT, 0 );
		session.setAttribute( ERROR_WORD_IDS, "" );
		session.setAttribute( LAST_WORD_ID, null );
		
		return "word";
	}
	
	@RequestMapping( value = "/word", method = RequestMethod.GET )
	public @ResponseBody WordForTestResponse getWordForTest( HttpSession session ) 
		throws Exception
	{
		WordForTestResponse response = new WordForTestResponse( );
		JsWord jsWord = new JsWord( );
		response.setJsWord( jsWord );
		
		String sequence;
		Object obj = session.getAttribute( "sequence" );
		if ( obj instanceof StringBuilder )
			sequence = ( ( StringBuilder ) obj ).toString( );
		else if ( obj instanceof String )
			sequence = ( String ) obj;
		else
		{
			throw new Exception( Log.log( "Неожиданный класс: %s", obj.getClass( ) ) );
		}
		
		int index = sequence.indexOf( ';' );
		String id = null;
		if ( index >= 0 )
		{
			id = sequence.substring( 0, index );
			sequence = sequence.substring( index + 1 );
			session.setAttribute( "sequence", sequence );
		}
		else
		{
			id = sequence;
			session.setAttribute( "sequence", "" );
		}
		
		Word w = _wordService.fetchWord( Integer.parseInt( id ) );
		List< Word > words = _wordService.fetchRandomWordsByUserIdExcluding( w.getId( ), null, -1 );
		
		jsWord.setId( w.getId( ) );
		jsWord.setHiragana( w.getHiragana( ) );
		jsWord.setKanji( w.getKanji( ) );
		words.add( w ); // XXX
		for ( Word word : words )
		{
			for ( String meaning : word.getMeanings( ).split( ";" ) )
			{
				jsWord.getMeanings( ).add( meaning.trim( ) );
			}
		}
		
		return response;
	}
	
	@RequestMapping( value = "/word/check", method = RequestMethod.POST )
	public @ResponseBody CheckWordResponse checkWord( @RequestBody CheckWordRequest request, HttpSession session )
	{
		JsWord jsWord = request.getWord( );
		CheckWordResponse response = new CheckWordResponse( );
		JsCheckedWord checkedWord = new JsCheckedWord( );
		response.setWord( checkedWord );
		checkedWord.setId( jsWord.getId( ) );
		Word word = _wordService.fetchWord( jsWord.getId( ) );
		List< String > meanings = Arrays.asList( word.getMeanings( ).replaceAll( ";\\s+", ";" ).replace( "\\s+;", ";").split( ";" ) );
		for ( String meaning : jsWord.getMeanings( ) )
		{
			if ( meanings.contains( meaning ) )
				checkedWord.getCorrectMeanings( ).add( meaning );
			else
				checkedWord.getIncorrectMeanings( ).add( meaning );
		}
		
		if ( ! checkedWord.getIncorrectMeanings( ).isEmpty( ) || 
				checkedWord.getCorrectMeanings( ).size( ) < meanings.size( ) )
		{
			response.setResult( false );
			Integer lastWordId = ( Integer ) session.getAttribute( LAST_WORD_ID );
			if ( null == lastWordId || ! lastWordId.equals( word.getId( ) ) )
			{
				StringBuilder wrongIds = new StringBuilder ( ( String ) session.getAttribute( ERROR_WORD_IDS ) );
				if ( null != wrongIds && wrongIds.length( ) > 0 )
					wrongIds.append( ";" );
				wrongIds.append( jsWord.getId( ) );
				session.setAttribute( ERROR_WORD_IDS, wrongIds.toString( ) );
			}
		}
		else
		{
			Integer lastWordId = ( Integer ) session.getAttribute( LAST_WORD_ID );
			if ( null == lastWordId || ! lastWordId.equals( word.getId( ) ) )
			{
				Integer correctWordsAmount = ( Integer ) session.getAttribute( CORRECT_WORDS_AMOUNT );
				session.setAttribute( CORRECT_WORDS_AMOUNT, correctWordsAmount + 1 );
			}
		}
		
		String sequence = ( String ) session.getAttribute( "sequence" );
		if ( response.getResult( ) && ( null == sequence || sequence.isEmpty( ) ) )
		{
			response.setEnd( true );
		}
		session.setAttribute( LAST_WORD_ID, word.getId( ) );
		
		return response;
	}
	
	@RequestMapping( value = "/pages/word/result", method = RequestMethod.GET )
	public String getWordTestResult( HttpSession session )
	{
		return "result_word";
	}
	
	@RequestMapping( value = "/word/errors", method = RequestMethod.GET )
	public @ResponseBody WordResultResponse getErrorWords( HttpSession session )
	{
		WordResultResponse response = new WordResultResponse( );
		String wordIdsString = ( String ) session.getAttribute( ERROR_WORD_IDS );
		if ( null != wordIdsString && ! wordIdsString.isEmpty( ) )
		{
			List< JsWord > words = new ArrayList< JsWord >( );
			for ( String wordId : wordIdsString.split( ";" ) )
			{
				Word word = _wordService.fetchWord( Integer.parseInt( wordId ) );
				JsWord jsWord = new JsWord( );
				jsWord.setHiragana( word.getHiragana( ) );
				jsWord.setKanji( word.getKanji( ) );
				for ( String meaning : word.getMeanings( ).split( ";" ) )
					jsWord.getMeanings( ).add( meaning.trim( ) );
				
				words.add( jsWord );
			}
			
			response.setWords( words );
			response.setResult( false );
		}
		
		response.setTotalWordsAmount( ( Integer ) session.getAttribute( TOTAL_WORDS_AMOUNT ) );
		response.setCorrectWordsAmount( ( Integer ) session.getAttribute( CORRECT_WORDS_AMOUNT ) );
		
		return response;
	}
}
