package com.scrapify.bidservice.dao.impl;

import com.scrapify.bidservice.dao.IBidDAO;
import com.scrapify.bidservice.domain.Bid;
import com.scrapify.bidservice.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BidDAOImpl implements IBidDAO {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public Bid placeBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public List<Bid> getBidsBySeller(String sellerId) {
        return bidRepository.findBySellerId(sellerId);
    }

    @Override
    public Bid acceptBid(String id) {
        Optional<Bid> bid = bidRepository.findById(id);
        return bid.orElse(null);
    }
}
