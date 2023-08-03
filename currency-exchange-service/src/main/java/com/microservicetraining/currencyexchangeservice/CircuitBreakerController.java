package com.microservicetraining.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	//@Retry(name="sample-api", fallbackMethod = "hardCodedMethod")
	//@CircuitBreaker(name="default", fallbackMethod = "hardCodedMethod")
	@RateLimiter(name="default")
	public String sampleApi() {
		logger.info("Entered sampleAPI method");
		//ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:/80/dummy", String.class);
		return "SAMPLE API";
	}
	
	public String hardCodedMethod(java.lang.Throwable ex) {
		return "hardcoded-response";
	}
}
