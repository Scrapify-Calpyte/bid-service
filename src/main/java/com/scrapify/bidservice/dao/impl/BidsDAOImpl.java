package com.scrapify.bidservice.dao.impl;

import com.scrapify.bidservice.dao.IBidsDAO;
import com.scrapify.bidservice.domain.Bids;
import com.scrapify.bidservice.repository.BidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BidsDAOImpl implements IBidsDAO {

    @Autowired
    private BidsRepository bidsRepository;

    @Override
    public Bids save(Bids bids) {
        return bidsRepository.save(bids);
    }

    @Override
    public List<Bids> getAllBids() {
        return bidsRepository.findAll();
    }
}
