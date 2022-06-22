package com.josdugan.beerservice.services.brewing;

import com.josdugan.beerservice.domain.Beer;
import com.josdugan.beerservice.events.BrewBeerEvent;
import com.josdugan.beerservice.mappers.BeerMapper;
import com.josdugan.beerservice.repositories.BeerRepository;
import com.josdugan.beerservice.services.inventory.BeerInventoryService;
import com.josdugan.beerworkscommon.constants.MessageQueues;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQoh = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQoh);

            if (beer.getMinOnHand() >= invQoh) {
                jmsTemplate.convertAndSend(MessageQueues.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
