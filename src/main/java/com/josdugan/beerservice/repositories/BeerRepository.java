package com.josdugan.beerservice.repositories;

import com.josdugan.beerservice.domain.Beer;
import com.josdugan.beerservice.web.model.BeerStyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerStyle(BeerStyle beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyle beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Optional<Beer> findByUpc(String upc);
}
