package ru.seyseich.jp.kanjiTester.data.daos;

import org.springframework.stereotype.Component;

import ru.seyseich.jp.kanjiTester.data.entities.Word;

@Component
public class WordDao extends AbstractDao< Word, Integer >
{
	@Override
	protected Class< ? extends Word > getType( )
	{
		return Word.class;
	}
}
