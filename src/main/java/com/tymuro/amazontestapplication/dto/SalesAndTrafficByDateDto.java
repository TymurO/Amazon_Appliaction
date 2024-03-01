package com.tymuro.amazontestapplication.dto;

import com.tymuro.amazontestapplication.models.Amount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesAndTrafficByDateDto {

    private BigDecimal orderedProductSales;
    private BigDecimal orderedProductSalesB2B;

    private BigInteger unitsOrdered;
    private BigInteger unitsOrderedB2B;

    private BigInteger totalOrderItems;
    private BigInteger totalOrderItemsB2B;

    private BigDecimal averageSalesPerOrderItem;
    private BigDecimal averageSalesPerOrderItemB2B;

    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;

    private BigDecimal averageSellingPrice;
    private BigDecimal averageSellingPriceB2B;

    private BigInteger unitsRefunded;

    private Double refundRate;

    private BigInteger claimsGranted;

    private BigDecimal claimsAmount;

    private BigDecimal shippedProductSales;

    private BigInteger unitsShipped;

    private BigInteger ordersShipped;

    private BigInteger browserPageViews;
    private BigInteger browserPageViewsB2B;

    private BigInteger mobileAppPageViews;
    private BigInteger mobileAppPageViewsB2B;

    private BigInteger pageViews;
    private BigInteger pageViewsB2B;

    private BigInteger browserSessions;
    private BigInteger browserSessionsB2B;

    private BigInteger mobileAppSessions;
    private BigInteger mobileAppSessionsB2B;

    private BigInteger sessions;
    private BigInteger sessionsB2B;

    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;

    private Double orderItemSessionPercentage;
    private Double orderItemSessionPercentageB2B;

    private Double unitSessionPercentage;
    private Double unitSessionPercentageB2B;

    private BigInteger averageOfferCount;

    private BigInteger averageParentItems;

    private BigInteger feedbackReceived;

    private BigInteger negativeFeedbackReceived ;

    private Double receivedNegativeFeedbackRate;
}
