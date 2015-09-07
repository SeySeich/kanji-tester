package ru.seyseich.jp.kanjiTester.data.entities;

public class KunYomi
{
	private Integer id;
	private String value;
	private String meanings;
	private Kanji kanji;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setValue( String value ) { this.value = value; }
	public String getValue( ) { return value; }
	
	public void setMeanings( String meanings ) { this.meanings = meanings; }
	public String getMeanings( ) { return meanings; }
	
	public void setKanji( Kanji kanji ) { this.kanji = kanji; }
	public Kanji getKanji( ) { return kanji; }
	// @formatter:on
}
