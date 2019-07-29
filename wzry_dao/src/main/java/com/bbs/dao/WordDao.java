package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDao {

    @Select("SELECT * FROM bbs_word_table")
    public List<Word> findByPage();

    @Update("update bbs_word_table set status=#{status} where wordId=#{wordId}")
    public void updateStatus(@Param("wordId") Integer wordId, @Param("status") Integer status);

//    @Select("select * from bbs_word_table where wordId=#{wordId}")
//    public Word findById(Integer wordId);

    @Update("insert into bbs_word_table (word) values (#{word})")
    public void addWord(String word);

}
