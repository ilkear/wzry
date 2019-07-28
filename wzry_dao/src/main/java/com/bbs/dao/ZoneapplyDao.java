package com.bbs.dao;


import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface ZoneapplyDao {


    /**
     * @author : ruan
     * @date : 2019/7/26
     */

    @Insert("insert into `bbs_zoneapply_table`(zoneName,userName,reason)VALUES(#{zoneName},#{userName},#{reason})")
    void save(Zoneapply zoneapply);


    @Select("select * from bbs_zoneapply_table")
    public List<Zoneapply> findByPage() throws Exception;

    @Update("update bbs_zoneapply_table set status=#{status} where  applyZoneId=#{applyZoneId}")
    void upStatus(@Param("status") int status, @Param("applyZoneId") int applyZoneId);


    @Select("select * from bbs_zone_table")
    public List<Zone> findAll() throws Exception;
    @Insert("insert into `bbs_zone_table`(zoneName,isDef)ValUES(#{zoneName},2)")
    void  saveZone(Zone zone);


    @Select("select * from bbs_article_table where title like #{title} && zoneId=#{zoneId}")
    List<Article> finByName(@Param("title") String title,@Param("zoneId") int zoneid) throws Exception;
}
