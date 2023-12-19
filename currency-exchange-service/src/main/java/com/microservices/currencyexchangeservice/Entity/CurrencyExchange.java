package com.microservices.currencyexchangeservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;


@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CurrencyExchange {
    @Id
    private  Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

}
