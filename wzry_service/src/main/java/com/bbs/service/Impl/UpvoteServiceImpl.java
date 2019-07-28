package com.bbs.service.Impl;

import com.bbs.dao.UpvoteDao;
import com.bbs.domain.Upvote;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpvoteServiceImpl implements UpvoteService {
    @Autowired
    private UpvoteDao upvoteDao;

    @Override
    public void addUpvote(Upvote upvote) {
        upvoteDao.insert(upvote);
    }

    @Override
    public List<Upvote> findByNameAndarticleId(Upvote upvote) {

        return null;
    }
}
