package ru.seyseich.jp.kanjiTester.controllers.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsWord implements Serializable
{
	private static final long serialVersionUID = - 2854642419191737537L;
	
	private Integer _id;
	private String _kanji;
	private String _hiragana;
	private List< String > _meanings = new ArrayList< String >( );
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setKanji( String kanji ) { _kanji = kanji; }
	public String getKanji( ) { return _kanji; }
	
	public void setHiragana( String hiragana ) { _hiragana = hiragana; }
	public String getHiragana( ) { return _hiragana; }
	
	public void setMeanings( List< String > meanings ) { _meanings = meanings; }
	public List< String > getMeanings( ) { return _meanings; }
	// @formatter:on
}
