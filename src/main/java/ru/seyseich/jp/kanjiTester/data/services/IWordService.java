package ru.seyseich.jp.kanjiTester.data.services;

import java.util.List;

import ru.seyseich.jp.kanjiTester.data.entities.User;
import ru.seyseich.jp.kanjiTester.data.entities.Word;

public interface IWordService
{
	List< Word > fetchRandomWords( User user, int amount );
	List< Word > fetchRandomWordsByUserId( Integer userId, int amount );
	List< Word > fetchRandomWordsByUserIdExcluding( Integer excludedWordId, Integer userId, int amount );
	Word fetchWord( Integer id );
}
