package com.microservices.currencyexchangeservice.Controller;

import com.microservices.currencyexchangeservice.Entity.CurrencyExchange;
import com.microservices.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {
    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        String port= environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange=new CurrencyExchange(1L,from,to,BigDecimal.valueOf(65L),port);
//        if(currencyExchange==null)throw new RuntimeException("Unable to find data for "+from+"to "+to);
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
