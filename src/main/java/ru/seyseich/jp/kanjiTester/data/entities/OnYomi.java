package ru.seyseich.jp.kanjiTester.data.entities;

public class OnYomi
{
	private Integer id;
	// Чтения, записанные в катакане, разделенные ";"
	private String value;
	private Kanji kanji;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setValue( String value ) { this.value = value; }
	public String getValue( ) { return value; }
	
	public void setKanji( Kanji kanji ) { this.kanji = kanji; }
	public Kanji getKanji( ) { return kanji; }
	// @formatter:on
}
