package ru.seyseich.jp.kanjiTester.data.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.seyseich.jp.kanjiTester.data.entities.User;
import ru.seyseich.jp.kanjiTester.data.entities.Word;

@Service( "dummyWordService" )
public class DummyWordService implements IWordService
{
	private List< Word > _words = new ArrayList< Word >( );
	
	public DummyWordService( )
	{
		Word word = new Word( );
		word.setId( 1 );
		word.setHiragana( "もんだい" );
		word.setKanji( "-" );
		word.setMeanings( "вопрос" );
		_words.add( word );
		
		word = new Word( );
		word.setId( 2 );
		word.setHiragana( "こたえ" );
		word.setKanji( "-" );
		word.setMeanings( "ответ" );
		_words.add( word );
		
		word = new Word( );
		word.setId( 3 );
		word.setHiragana( "えんぴつ" );
		word.setKanji( "-" );
		word.setMeanings( "карандаш" );
		_words.add( word );
		
		word = new Word( );
		word.setId( 4 );
		word.setHiragana( "かのじょ" );
		word.setKanji( "-" );
		word.setMeanings( "она" );
		_words.add( word );
	}

	public List< Word > fetchRandomWords( User user, int amount )
	{
		return _words;
	}
	
	public Word fetchWord( Integer id )
	{
		Word result = null;
		for ( Word word : _words )
		{
			if ( word.getId( ) == id )
			{
				result = word;
				break;
			}
		}
		
		return result;
	}

	public List< Word > fetchRandomWordsByUserId( Integer userId, int amount )
	{
		return _words;
	}

	public List< Word > fetchRandomWordsByUserIdExcluding(
			Integer excludedWordId, Integer userId, int amount )
	{
		List< Word > res = new ArrayList< Word >( );
		for ( Word word : _words )
		{
			if ( word.getId( ) != excludedWordId )
				res.add( word );
		}
		
		return res;
	}
}
