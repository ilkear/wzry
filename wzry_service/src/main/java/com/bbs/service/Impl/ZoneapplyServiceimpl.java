package com.bbs.service.Impl;

import com.bbs.dao.ZoneapplyDao;
import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author ruan
 * @date:2019年07月27日00:07:45
 */
@Service
@Transactional
public class ZoneapplyServiceimpl implements ZoneapplyService  {


    @Autowired
    private ZoneapplyDao zoneapplyDao;




    @Override
    public void save(Zoneapply zoneapply) {
        zoneapplyDao.save(zoneapply);
    }

    @Override
    public List<Zoneapply> findByPage() throws Exception {
        return zoneapplyDao.findByPage();
    }

    @Override
    public void upStatus(int status, int applyZoneId) throws Exception {
         zoneapplyDao.upStatus(status,applyZoneId);
    }


    @Override
    public List<Zone> findAll() throws Exception {
        return zoneapplyDao.findAll();
    }

    @Override
    public void saveZone(Zone zone) throws Exception {
        zoneapplyDao.saveZone(zone);
    }


}
