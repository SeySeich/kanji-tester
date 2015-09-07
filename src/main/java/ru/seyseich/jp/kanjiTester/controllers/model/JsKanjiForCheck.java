package ru.seyseich.jp.kanjiTester.controllers.model;

import java.util.ArrayList;
import java.util.List;

public class JsKanjiForCheck
{
	private Integer _id;
	private String _value;
	private List< String > _meanings = new ArrayList< String >( );
	private List< String > _kunReadings = new ArrayList< String >( );
	private List< String > _kunMeanings = new ArrayList< String >( );
	private List< String > _ons = new ArrayList< String >( );
//	private Map< String, List< String > > _kuns = new HashMap< String, List< String > >( );
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setValue( String value ) { _value = value; }
	public String getValue( ) { return _value; }
	
	public void setMeanings( List< String > meanings ) { _meanings = meanings; }
	public List< String > getMeanings( ) { return _meanings; }
	
	public void setKunReadings( List< String > kunReadings ) { _kunReadings = kunReadings; }
	public List< String > getKunReadings( ) { return _kunReadings; }
	
	public void setKunMeanings( List< String > kunMeanings ) { _kunMeanings = kunMeanings; }
	public List< String > getKunMeanings( ) { return _kunMeanings; }
	
	public void setOns( List< String > ons ) { _ons = ons; }
	public List< String > getOns( ) { return _ons; }
	
//	public void setKuns( Map< String, List< String > > kuns ) { _kuns = kuns; }
//	public Map< String, List< String > > getKuns( ) { return _kuns; }
	// @formatter:on
}
