package ru.seyseich.jp.kanjiTester.data.services;

import java.util.List;

import ru.seyseich.jp.kanjiTester.data.entities.Kanji;
import ru.seyseich.jp.kanjiTester.data.entities.User;


public interface IKanjiService
{
	List< Kanji > fetchAllKanjis( User user );
	List< Kanji > fetchAllKanjisByUser( Integer userId );
}
