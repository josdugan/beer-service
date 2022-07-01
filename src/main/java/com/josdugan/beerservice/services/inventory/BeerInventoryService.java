package com.josdugan.beerservice.services.inventory;

import java.util.UUID;

public interface BeerInventoryService {

    public String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";

    Integer getOnhandInventory(UUID beerId);
}
