package com.tymuro.amazontestapplication.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sales {

    private Amount orderedProductSales;
    private Amount orderedProductSalesB2B;

    private BigInteger unitsOrdered;
    private BigInteger unitsOrderedB2B;

    private BigInteger totalOrderItems;
    private BigInteger totalOrderItemsB2B;

    private Amount averageSalesPerOrderItem;
    private Amount averageSalesPerOrderItemB2B;

    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;

    private Amount averageSellingPrice;
    private Amount averageSellingPriceB2B;

    private BigInteger unitsRefunded;

    private Double refundRate;

    private BigInteger claimsGranted;

    private Amount claimsAmount;

    private Amount shippedProductSales;

    private BigInteger unitsShipped;

    private BigInteger ordersShipped;
}
