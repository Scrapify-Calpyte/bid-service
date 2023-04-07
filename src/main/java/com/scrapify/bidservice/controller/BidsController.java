package com.scrapify.bidservice.controller;

import com.scrapify.bidservice.domain.Bid;
import com.scrapify.bidservice.domain.Bids;
import com.scrapify.bidservice.service.IBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidsController {

    @Autowired
    private IBidService bidService;


    @PostMapping("/place-bid")
    ResponseEntity<Bid> placeBid(@RequestBody Bid bid){
        return  new ResponseEntity<>(bidService.placeBid(bid) ,HttpStatus.OK);
    }

    @GetMapping("/by-seller")
    ResponseEntity<Bids> getBids(@RequestParam("id") String id){
        return new ResponseEntity(bidService.getBidsBySellerId(id),HttpStatus.OK);
    }
}
