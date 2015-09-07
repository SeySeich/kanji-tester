package ru.seyseich.jp.kanjiTester.controllers.requests;

import ru.seyseich.jp.kanjiTester.controllers.model.JsWord;


public class CheckWordRequest
{
	private JsWord _word;
	
	// @formatter:off
	public void setWord( JsWord word ) { _word = word; }
	public JsWord getWord( ) { return _word; }
	// @formatter:on
}
