package ru.seyseich.jp.kanjiTester.controllers.responses;

import ru.seyseich.jp.kanjiTester.controllers.model.JsCheckedWord;

public class CheckWordResponse extends Response
{
	private Boolean _result = true;
	private Boolean _end = false;
	private JsCheckedWord _word;
	
	// @formatter:off
	public void setResult( boolean result ) { _result = result; }
	public Boolean getResult( ) { return _result; }
	
	public void setWord( JsCheckedWord word ) { _word = word; }
	public JsCheckedWord getWord( ) { return _word; }
	
	public void setEnd( Boolean end ) { _end = end; }
	public Boolean getEnd( ) { return _end; }
	// @formatter:on
}
