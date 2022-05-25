package com.josdugan.beerservice.services;

import com.josdugan.beerservice.web.model.BeerDto;
import com.josdugan.beerservice.web.model.BeerPagedList;
import com.josdugan.beerservice.web.model.BeerStyle;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto getBeerByUpc(String upc);

    BeerDto saveNewBeer(BeerDto beerDto);


    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyle beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

}
