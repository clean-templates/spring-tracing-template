package org.rolandsall.tracingjaegerzipkin.infra;

import org.rolandsall.tracingjaegerzipkin.core.FactService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service

public class CatCatService implements FactService {

    private final RestTemplate restTemplate;

    public CatCatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetchRandomFacts() {
        return this.restTemplate.getForEntity("https://cat-fact.herokuapp.com/facts", String.class).getBody();
    }
}
