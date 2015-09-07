package ru.seyseich.jp.kanjiTester.data.daos;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class AbstractDao< T, K > implements IDao< T, K >
{
	@PersistenceContext
	private EntityManager _em;
	
	public void save( T entity )
	{
		_em.persist( entity );
		_em.flush( );
	}
	
	public void update( T entity )
	{
		_em.merge( entity );
		_em.flush( );
	}
	
	public T getById( K key )
	{
		return _em.find( getType( ), key );
	}
	
	@SuppressWarnings( "unchecked" )
	public List< T > select( String query, Object... params )
	{
		Query q = _em.createQuery( query );
		for ( int i = 0; i < params.length; i += 2 )
			q.setParameter( ( String ) params[ i ], params[ i + 1 ] );
		
		return q.getResultList( );
	}
	
	public void delete( T entity )
	{
		_em.remove( entity );
		_em.flush( );
	}
	
	public void deleteById( K key )
	{
		_em.remove( getById( key ) );
	}
	
	public void save( List< T > entities )
	{
		for ( T entity : entities )
			_em.persist( entity );
		_em.flush( );
	}
	
	public void update( List< T > entities )
	{
		for ( T entity : entities )
			_em.merge( entity );
		_em.flush( );
	}
	
	public void getRandomEntities( )
	{
		Query q = _em.createQuery( String.format( "select count(c) from %s c", getType( ).getSimpleName( ) ) );
		long count = ( Long ) q.getSingleResult( );
		
		int number = new Random( ).nextInt( ( int ) count );
		Query select = _em.createQuery( "" );
	}
	
	abstract protected Class< ? extends T > getType( ); 
}
