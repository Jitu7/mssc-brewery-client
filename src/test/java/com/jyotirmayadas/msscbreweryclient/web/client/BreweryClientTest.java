package com.jyotirmayadas.msscbreweryclient.web.client;

import com.jyotirmayadas.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerById);
    }

    @Test
    void saveBeer() {
        URI uri = breweryClient.saveBeer(BeerDto.builder().beerName("New Beer").build());

        assertNotNull(uri);
    }
}