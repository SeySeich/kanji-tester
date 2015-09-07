package ru.seyseich.jp.kanjiTester.data.entities;

import java.util.List;

public class Kanji
{
	private Integer id;
	private User user;
	private String value;
	private OnYomi onYomi;
	private List< KunYomi > kunYomis;
	// Значения кандзи, разделенные ";"
	private String meanings;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setUser( User user ) { this.user = user; }
	public User getUser( ) { return user; }
	
	public void setValue( String value ) { this.value = value; }
	public String getValue( ) { return value; }
	
	public void setOnYomi( OnYomi onYomi ) { this.onYomi = onYomi; }
	public OnYomi getOnYomi( ) { return onYomi; }
	
	public void setKunYomis( List< KunYomi > kunYomis ) { this.kunYomis = kunYomis; }
	public List< KunYomi > getKunYomis( ) { return kunYomis; }
	
	public void setMeanings( String meanings ) { this.meanings = meanings; }
	public String getMeanings( ) { return meanings; }
	// @formatter:on
}
