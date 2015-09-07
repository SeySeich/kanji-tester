package ru.seyseich.jp.kanjiTester.data.entities;

public class User
{
	private Integer id;
	private String name;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	
	public void setName( String name ) { this.name = name; }
	public String getName( ) { return name; }
	// @formatter:on
}
