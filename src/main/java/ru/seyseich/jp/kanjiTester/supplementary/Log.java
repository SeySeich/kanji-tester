package ru.seyseich.jp.kanjiTester.supplementary;

public class Log
{
	// @formatter:off
	private Log( ) { }
	// @formatter:on
	
	public static String log( Object message, Object... params )
	{
		String msg = String.format( String.valueOf( message ), params );
		System.out.println( msg );
		
		return msg;
	}
}
