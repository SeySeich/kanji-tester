package ru.seyseich.jp.kanjiTester.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.seyseich.jp.kanjiTester.controllers.model.JsKanjiForCheck;
import ru.seyseich.jp.kanjiTester.controllers.responses.KanjiForCheckResponse;
import ru.seyseich.jp.kanjiTester.data.entities.Kanji;
import ru.seyseich.jp.kanjiTester.data.entities.KunYomi;
import ru.seyseich.jp.kanjiTester.data.services.IKanjiService;
import ru.seyseich.jp.kanjiTester.supplementary.Log;

@Controller
public class MainController
{
	public MainController( )
	{
		Log.log( "Hello!" );
	}
	
	@Autowired
	@Qualifier( "dummyKanjiService" )
	private IKanjiService _kanjiService;
	
	@RequestMapping( value = "/test", method = RequestMethod.GET )
	public @ResponseBody String test( )
	{
		return "{ \"status\" : \"ok\" }";
	}
	
	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public String hello( )
	{
		return "hello";
	}
	
	@RequestMapping( value = "/kanji", method = RequestMethod.GET )
	public String kanji( )
	{
		return "kanji";
	}
	
	@RequestMapping( value = "/test/kanji", method = RequestMethod.GET )
	public @ResponseBody KanjiForCheckResponse getKanji( HttpSession session )
	{
		Kanji kanji = _kanjiService.fetchAllKanjis( null ).get( 0 );
		JsKanjiForCheck jsKanji = new JsKanjiForCheck( );
		jsKanji.setId( kanji.getId( ) );
		jsKanji.setValue( kanji.getValue( ) );
		
//		Map< String, List< String > > kuns = new HashMap< String, List< String > >( );
//		for ( KunYomi kun : kanji.getKunYomis( ) )
//		{
//			kuns.put( kun.getValue( ), Arrays.asList( kun.getMeanings( ).split( ";" ) ) );
//		}
//		jsKanji.setKuns( kuns );
		
		for ( KunYomi kun : kanji.getKunYomis( ) )
		{
			jsKanji.getKunMeanings( ).add( kun.getMeanings( ).replace( ";", "; " ) );
			jsKanji.getKunReadings( ).add( kun.getValue( ) );
		}
		
		jsKanji.setOns( Arrays.asList( kanji.getOnYomi( ).getValue( ).split( ";" ) ) );
		jsKanji.setMeanings( Arrays.asList( kanji.getMeanings( ).split( ";" ) ) );
		
		KanjiForCheckResponse response = new KanjiForCheckResponse( );
		response.setKanji( jsKanji );
		
		return response;
	}
}
