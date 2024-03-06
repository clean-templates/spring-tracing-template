package com.murex.microservice.api;


import com.murex.microservice.core.FactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("facts")
@Slf4j
public class DummyController {

    private final FactService factService;
    private final RestTemplate restTemplate;


    public DummyController(FactService factService, RestTemplate restTemplate) {
        this.factService = factService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cat")
    public ResponseEntity<String> fact() throws InterruptedException {
        log.info("receive a request on fact endpoint");
        Thread.sleep(5000);
        return ResponseEntity.ok(factService.fetchRandomFacts());
    }

    @GetMapping("/test")
    public ResponseEntity<String> test()     {
        log.info("receive a request on test endpoint");
        return restTemplate.getForEntity("http://localhost:8080/facts/cat", String.class);
    }


}
