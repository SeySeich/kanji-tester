package ru.seyseich.jp.kanjiTester.data.entities;

public class Word
{
	private Integer id;
	private String kanji;
	private String hiragana;
	private String meanings;
	private User user;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setKanji( String kanji ) { this.kanji = kanji; }
	public String getKanji( ) { return kanji; }
	
	public void setHiragana( String hiragana ) { this.hiragana = hiragana; }
	public String getHiragana( ) { return hiragana; }
	
	public void setMeanings( String meanings ) { this.meanings = meanings; }
	public String getMeanings( ) { return meanings; }
	
	public void setUser( User user ) { this.user = user; }
	public User getUser( ) { return user; }
	// @formatter:on
}
