package ru.seyseich.jp.kanjiTester.data.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.seyseich.jp.kanjiTester.data.entities.Kanji;
import ru.seyseich.jp.kanjiTester.data.entities.KunYomi;
import ru.seyseich.jp.kanjiTester.data.entities.OnYomi;
import ru.seyseich.jp.kanjiTester.data.entities.User;

@Service( "dummyKanjiService" )
public class DummyKanjiService implements IKanjiService
{
	private List< Kanji > _kanjis;
	
	public DummyKanjiService( )
	{
		_kanjis = new ArrayList< Kanji >( );
		
		Kanji kanji = new Kanji( );
		kanji.setId( 1 );
		OnYomi on = new OnYomi( );
		on.setId( 1 );
		on.setKanji( kanji );
		on.setValue( "イチ;イツ" );
		kanji.setOnYomi( on );
		
		KunYomi kun = new KunYomi( );
		kun.setId( 1 );
		kun.setKanji( kanji );
		kun.setMeanings( "один" );
		kun.setValue( "ひと" );
		KunYomi kun2 = new KunYomi( );
		kun2.setId( 2 );
		kun2.setKanji( kanji );
		kun2.setMeanings( "во-первых" );
		kun2.setValue( "（ひと）つ" );
		kanji.setKunYomis( Arrays.asList( kun, kun2 ) );
		
		kanji.setMeanings( "один" );
		kanji.setUser( null );
		kanji.setValue( "一" );
		
		_kanjis.add( kanji );
	}
	
	public List< Kanji > fetchAllKanjis( User user )
	{
		return _kanjis;
	}

	public List< Kanji > fetchAllKanjisByUser( Integer userId )
	{
		return _kanjis;
	}
}
