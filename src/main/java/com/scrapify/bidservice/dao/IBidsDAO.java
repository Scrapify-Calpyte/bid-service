package com.scrapify.bidservice.dao;

import com.scrapify.bidservice.domain.Bids;

import java.util.List;

public interface IBidsDAO {
    Bids save(Bids bids);

    List<Bids> getAllBids();
}
