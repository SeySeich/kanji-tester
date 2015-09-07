package ru.seyseich.jp.kanjiTester.controllers.responses;

import ru.seyseich.jp.kanjiTester.controllers.model.JsKanjiForCheck;

public class KanjiForCheckResponse extends Response
{
	private JsKanjiForCheck _kanji;
	
	// @formatter:off
	public void setKanji( JsKanjiForCheck kanji ) { _kanji = kanji; }
	public JsKanjiForCheck getKanji( ) { return _kanji; }
	// @formatter:on
}
