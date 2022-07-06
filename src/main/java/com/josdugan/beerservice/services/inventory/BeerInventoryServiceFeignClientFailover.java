package com.josdugan.beerservice.services.inventory;

import com.josdugan.beerworkscommon.dtos.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BeerInventoryServiceFeignClientFailover implements BeerInventoryServiceFeignClient {

    private final BeerInventoryFailoverFeignClient beerInventoryFailoverFeignClient;

    @Override
    public ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(UUID beerId) {
        return beerInventoryFailoverFeignClient.getOnHandInventory(beerId);
    }
}
