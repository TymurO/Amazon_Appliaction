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
public class Traffic {

    private BigInteger browserSessions;
    private BigInteger browserSessionsB2B;

    private BigInteger mobileAppSessions;
    private BigInteger mobileAppSessionsB2B;

    private BigInteger sessions;
    private BigInteger sessionsB2B;

    private Double browserSessionPercentage;
    private Double browserSessionPercentageB2B;

    private Double mobileAppSessionPercentage;
    private Double mobileAppSessionPercentageB2B;

    private Double sessionPercentage;
    private Double sessionPercentageB2B;

    private BigInteger browserPageViews;
    private BigInteger browserPageViewsB2B;

    private BigInteger mobileAppPageViews;
    private BigInteger mobileAppPageViewsB2B;

    private BigInteger pageViews;
    private BigInteger pageViewsB2B;

    private Double browserPageViewsPercentage;
    private Double browserPageViewsPercentageB2B;

    private Double mobileAppPageViewsPercentage;
    private Double mobileAppPageViewsPercentageB2B;

    private Double pageViewsPercentage;
    private Double pageViewsPercentageB2B;

    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;

    private Double unitSessionPercentage;
    private Double unitSessionPercentageB2B;

    private Double orderItemSessionPercentage;
    private Double orderItemSessionPercentageB2B;

    private BigInteger averageOfferCount;

    private BigInteger averageParentItems;

    private BigInteger feedbackReceived;

    private BigInteger negativeFeedbackReceived ;

    private Double receivedNegativeFeedbackRate;
}
