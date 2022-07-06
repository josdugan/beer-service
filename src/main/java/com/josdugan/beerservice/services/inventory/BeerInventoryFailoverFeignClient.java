package com.josdugan.beerservice.services.inventory;

import com.josdugan.beerworkscommon.dtos.BeerInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "beer-inventory-failover")
public interface BeerInventoryFailoverFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/inventory-failover")
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
