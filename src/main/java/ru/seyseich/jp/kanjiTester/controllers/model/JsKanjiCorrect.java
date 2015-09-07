package ru.seyseich.jp.kanjiTester.controllers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsKanjiCorrect
{
	private Integer _id;
	private String _value;
	private List< String > _meanings = new ArrayList< String >( );
	private List< String > _ons = new ArrayList< String >( );
	private Map< String, String > _kuns = new HashMap< String, String >( );
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setValue( String value ) { _value = value; }
	public String getValue( ) { return _value; }
	
	public void setMeanings( List< String > meanings ) { _meanings = meanings; }
	public List< String > getMeanings( ) { return _meanings; }
	
	public void setOns( List< String > ons ) { _ons = ons; }
	public List< String > getOns( ) { return _ons; }
	
	public void setKuns( Map< String, String > kuns ) { _kuns = kuns; }
	public Map< String, String > getKuns( ) {return _kuns; }
	// @formatter:on
}
