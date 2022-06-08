package com.josdugan.beerservice.bootstrap;

import com.josdugan.beerservice.domain.Beer;
import com.josdugan.beerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "012345678911";
    public static final String BEER_2_UPC = "012345678922";
    public static final String BEER_3_UPC = "012345678933";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }

    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mongo Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Dogfish Head")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
