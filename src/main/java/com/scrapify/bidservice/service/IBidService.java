package com.scrapify.bidservice.service;

import com.scrapify.bidservice.domain.Bid;
import com.scrapify.bidservice.domain.Bids;

public interface IBidService {

     Bid placeBid(Bid bid);

     Bids getBidsBySellerId(String sellerId);

     Bid acceptBid(String id);

     Bid cancelBid(String id);
}
