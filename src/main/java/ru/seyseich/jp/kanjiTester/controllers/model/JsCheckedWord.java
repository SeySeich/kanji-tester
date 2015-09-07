package ru.seyseich.jp.kanjiTester.controllers.model;

import java.util.ArrayList;
import java.util.List;

public class JsCheckedWord
{
	private Integer _id;
	private List< String > _correctMeanings = new ArrayList< String >( );
	private List< String > _incorrectMeanings = new ArrayList< String >( );
	
	// @formatter:off
	public void setId( Integer id ) { _id = id; }
	public Integer getId( ) { return _id; }
	
	public void setCorrectMeanings( List< String > correctMeanings ) { _correctMeanings = correctMeanings; }
	public List< String > getCorrectMeanings( ) { return _correctMeanings; }
	
	public void setIncorrectMeanings( List< String > incorrectMeanings ) { _incorrectMeanings = incorrectMeanings; }
	public List< String > getIncorrectMeanings( ) { return _incorrectMeanings; }
	// @formatter:on
}
