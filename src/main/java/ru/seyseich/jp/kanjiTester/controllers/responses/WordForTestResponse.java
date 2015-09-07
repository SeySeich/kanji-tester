package ru.seyseich.jp.kanjiTester.controllers.responses;

import ru.seyseich.jp.kanjiTester.controllers.model.JsWord;

public class WordForTestResponse extends Response
{
	private JsWord _word;
	
	// @formatter:off
	public void setJsWord( JsWord word ) { _word = word; }
	public JsWord getWord( ) { return _word; }
	// @formatter:on
}
