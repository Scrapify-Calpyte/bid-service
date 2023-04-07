package com.scrapify.bidservice.dao;

import com.scrapify.bidservice.domain.Bid;

import java.util.List;

public interface IBidDAO {
    Bid placeBid(Bid bid);

    List<Bid> getBidsBySeller(String sellerId);
}
