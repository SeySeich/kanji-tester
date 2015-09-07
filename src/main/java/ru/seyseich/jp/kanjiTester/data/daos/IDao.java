package ru.seyseich.jp.kanjiTester.data.daos;

import java.util.List;

public interface IDao< T, K >
{
	public void save( T entity );
	public void update( T entity );
	public T getById( K key );
	public List< T > select( String query, Object... params );
	public void delete( T entity );
	public void deleteById( K key );
	public void save( List< T > entities );
	public void update( List< T > entities );
	public void getRandomEntities( );
	public void getRandomEntities( int amount );
}
