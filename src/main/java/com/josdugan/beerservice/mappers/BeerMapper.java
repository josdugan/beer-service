package com.josdugan.beerservice.mappers;

import com.josdugan.beerservice.domain.Beer;
import com.josdugan.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
