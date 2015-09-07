package ru.seyseich.jp.kanjiTester.controllers.model;

import java.util.ArrayList;
import java.util.List;

public class JsKanji
{
	private Integer _id;
	private String _value;
	private List< String > _ons = new ArrayList< String >( );
	private List< JsKunYomi > _kuns = new ArrayList< JsKunYomi >( );
	private List< String > _meanings = new ArrayList< String >( );
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setValue( String value ) { _value = value; }
	public String getValue( ) { return _value; }
	
	public void setOns( List< String > ons ) { _ons = ons; }
	public List< String > getOns( ) { return _ons; }
	
	public void setKuns( List< JsKunYomi > kuns ) { _kuns = kuns; }
	public List< JsKunYomi > getKuns( ) { return _kuns; }
	
	public void setMeanings( List< String > meanings ) { _meanings = meanings; }
	public List< String > getMeanings( ) { return _meanings; }
	// @formatter:on
}
