package com.scrapify.bidservice.domain;

import lombok.Data;

@Data
public class Bid {
    private Buyer buyer;
    private Seller seller;
    private Double qty;
    private Double proposedAmt;
    private Integer bidStatus;
    private Product product;
}
