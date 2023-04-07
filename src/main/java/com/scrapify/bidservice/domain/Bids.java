package com.scrapify.bidservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Bids {

    @Id
    private String id;
    private String inventoryId;
    private List<Bid> bids;

}
