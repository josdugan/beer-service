package com.josdugan.beerservice.services;

import com.josdugan.beerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);


    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
