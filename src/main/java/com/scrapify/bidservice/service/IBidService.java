package com.scrapify.bidservice.service;

import com.scrapify.bidservice.domain.Bids;

import java.util.List;

public interface IBidService {
     Bids save(Bids bids);

     List<Bids> getAll();
}
