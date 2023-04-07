package com.scrapify.bidservice.service.impl;

import com.scrapify.bidservice.dao.IBidDAO;
import com.scrapify.bidservice.domain.Bid;
import com.scrapify.bidservice.domain.Bids;
import com.scrapify.bidservice.service.IBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidServiceImpl implements IBidService {

    @Autowired
    private IBidDAO bidDAO;

    @Override
    public Bid placeBid(Bid bid) {
        return bidDAO.placeBid(bid);
    }

    @Override
    public Bids getBidsBySellerId(String sellerId) {
        List<Bid> bids = bidDAO.getBidsBySeller(sellerId);
        Bids bids1 = new Bids();
        bids1.setBids(bids);
        bids1.setInventoryId("010");
        bids1.setId("9348");
        return bids1;
    }
}
