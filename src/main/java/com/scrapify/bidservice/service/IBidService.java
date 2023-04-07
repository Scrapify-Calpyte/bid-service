package com.scrapify.bidservice.service;

import com.scrapify.bidservice.domain.Bid;
import com.scrapify.bidservice.domain.Bids;

import java.util.List;

public interface IBidService {

     Bid placeBid(Bid bid);

     Bids getBidsBySellerId(String sellerId);
}
