package com.josdugan.beerservice.events;

import com.josdugan.beerworkscommon.dtos.BeerDto;
import com.josdugan.beerworkscommon.events.BeerEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
