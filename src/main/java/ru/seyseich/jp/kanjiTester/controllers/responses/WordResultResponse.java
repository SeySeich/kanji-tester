package ru.seyseich.jp.kanjiTester.controllers.responses;

import java.util.ArrayList;
import java.util.List;

import ru.seyseich.jp.kanjiTester.controllers.model.JsWord;

public class WordResultResponse extends Response
{
	private List< JsWord > _words = new ArrayList< JsWord >( );
	private Boolean _result = true;
	private Integer _totalWordsAmount;
	private Integer _correctWordsAmount;
	
	// @formatter:off
	public void setWords( List< JsWord > words ) { _words = words; }
	public List< JsWord > getWords( ) { return _words; }
	
	public void setResult( Boolean result ) { _result = result; }
	public Boolean getResult( ) { return _result; }
	
	public void setTotalWordsAmount( Integer totalWordsAmount ) { _totalWordsAmount = totalWordsAmount; }
	public Integer getTotalWordsAmount( ) { return _totalWordsAmount; }
	
	public void setCorrectWordsAmount( Integer correctWordsAmount ) { _correctWordsAmount = correctWordsAmount; }
	public Integer getCorrectWordsAmount( ) { return _correctWordsAmount; }
	// @formatter:on
}
