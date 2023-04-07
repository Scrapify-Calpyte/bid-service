package com.scrapify.bidservice.domain;

import lombok.Data;

@Data
public class Bid {
    private Buyer buyer;
    private Double qty;
    private Double proposedAmt;
    private String bidStatus;
}
