package ru.seyseich.jp.kanjiTester.controllers.model;

import java.util.ArrayList;
import java.util.List;

public class JsKunYomi
{
	private String _reading;
	private List< String > _meanings = new ArrayList< String >( );
	
	// @formatter:off
	public void setReading( String reading ) { _reading = reading; }
	public String getReading( ) { return _reading; }
	
	public void setMeanings( List< String > meanings ) { _meanings = meanings; }
	public List< String > getMeanings( ) { return _meanings; }
	// @formatter:on
}
