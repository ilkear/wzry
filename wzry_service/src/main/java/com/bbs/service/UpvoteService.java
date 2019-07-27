package com.bbs.service;

import com.bbs.domain.Upvote;

import java.util.List;

public interface UpvoteService {

    void addUpvote(Upvote upvote);

    List<Upvote> findByNameAndarticleId(Upvote upvote);
}
