package com.tymuro.amazontestapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Amount {

    private BigDecimal amount;
    private String currencyCode;
}
