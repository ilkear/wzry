package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDao {

    @Select("SELECT * FROM bbs_word_table")
    public List<Word> findByPage();

}
