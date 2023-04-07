package com.scrapify.bidservice.service.impl;

import com.scrapify.bidservice.dao.IBidsDAO;
import com.scrapify.bidservice.domain.Bids;
import com.scrapify.bidservice.service.IBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements IBidService {

    @Autowired
    private IBidsDAO bidsDAO;

    @Override
    public Bids save(Bids bids) {
        return bidsDAO.save(bids);
    }

    @Override
    public List<Bids> getAll() {
        return bidsDAO.getAllBids();
    }
}
