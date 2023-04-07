package com.scrapify.bidservice.repository;

import com.scrapify.bidservice.domain.Bids;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidsRepository extends MongoRepository<Bids,String> {
}
