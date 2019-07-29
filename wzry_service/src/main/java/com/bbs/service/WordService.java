package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface WordService {

    public List<Word> findByPage();

    public void updateStatus(Integer wordId,Integer status);

    public void addWord(String word);
}
