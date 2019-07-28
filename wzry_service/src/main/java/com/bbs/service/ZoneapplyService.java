package com.bbs.service;


import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;

import java.util.List;

/**
 *
 * @author ruan
 * @date   2019年07月27日00:00:02
 *
 */

public interface ZoneapplyService {

    /**
     *
     * @return
     */


    public void save(Zoneapply zoneapply) throws Exception;

    public List<Zoneapply> findByPage() throws Exception;

    void upStatus(int status,int applyZoneId ) throws Exception;
    List<Zone> findAll() throws Exception;


    void saveZone(Zone zone) throws Exception;
}
