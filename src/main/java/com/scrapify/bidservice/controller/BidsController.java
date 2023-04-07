package com.scrapify.bidservice.controller;

import com.scrapify.bidservice.domain.Bids;
import com.scrapify.bidservice.repository.BidsRepository;
import com.scrapify.bidservice.service.IBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidsController {

    @Autowired
    private IBidService bidService;

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody Bids bids){
        return new ResponseEntity<>(bidService.save(bids), HttpStatus.CREATED);
    }

    @GetMapping("/get-bids")
    ResponseEntity<List<Bids>> getBids(){
        return new ResponseEntity<>(bidService.getAll(),HttpStatus.OK);
    }
}
