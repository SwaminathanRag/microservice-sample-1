package com.microservicetraining.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange retrieveExchangeRate(@PathVariable String fromCurrency,
			@PathVariable String toCurrency) {
		logger.info("retrieveExchangeRate called with {}, {}", fromCurrency, toCurrency);
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(fromCurrency, toCurrency);
		
		if(currencyExchange == null) {
			throw new RuntimeException("No exchange data found for " + fromCurrency + " to " + toCurrency);
		}
		
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}
