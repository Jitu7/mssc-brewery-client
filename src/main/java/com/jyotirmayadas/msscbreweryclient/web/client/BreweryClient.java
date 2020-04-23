package com.jyotirmayadas.msscbreweryclient.web.client;

import com.jyotirmayadas.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "brewery")
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        ResponseEntity<BeerDto> beerDtoResponseEntity =
                restTemplate.getForEntity(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
        BeerDto beerDto = beerDtoResponseEntity.getBody();

        return beerDto;
    }

    public URI saveBeer(BeerDto beerDto) {
        URI uri = restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
        return uri;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
