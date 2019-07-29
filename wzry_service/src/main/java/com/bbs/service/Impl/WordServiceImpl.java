package com.bbs.service.Impl;


import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordDao wordDao;

    @Override
    public List<Word> findByPage() {
        return wordDao.findByPage();
    }

    @Override
    public void updateStatus(Integer wordId,Integer status) {
//        Word word = wordDao.findById(wordId);
        if (status==0){
            status=1;
        }else{
            status=0;
        }
        wordDao.updateStatus(wordId,status);
    }

    @Override
    public void addWord(String word) {
        wordDao.addWord(word);
    }

}
