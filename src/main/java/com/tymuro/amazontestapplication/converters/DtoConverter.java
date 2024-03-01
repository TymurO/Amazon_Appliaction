package com.tymuro.amazontestapplication.converters;

import com.tymuro.amazontestapplication.dto.SalesAndTrafficByAsinDto;
import com.tymuro.amazontestapplication.dto.SalesAndTrafficByDateDto;
import com.tymuro.amazontestapplication.models.*;

public class DtoConverter {

    public static SalesAndTrafficByDate convertStatsByDate(SalesAndTrafficByDateDto dto) {
        Sales sales = new Sales();
        sales.setOrderedProductSales(new Amount(dto.getOrderedProductSales(), "USD"));
        sales.setOrderedProductSalesB2B(new Amount(dto.getOrderedProductSalesB2B(), "USD"));
        sales.setUnitsOrdered(dto.getUnitsOrdered());
        sales.setUnitsOrderedB2B(dto.getUnitsOrderedB2B());
        sales.setTotalOrderItems(dto.getTotalOrderItems());
        sales.setTotalOrderItemsB2B(dto.getTotalOrderItemsB2B());
        sales.setAverageSalesPerOrderItem(new Amount(dto.getAverageSalesPerOrderItem(), "USD"));
        sales.setAverageSalesPerOrderItemB2B(new Amount(dto.getAverageSalesPerOrderItemB2B(), "USD"));
        sales.setAverageUnitsPerOrderItem(dto.getAverageUnitsPerOrderItem());
        sales.setAverageUnitsPerOrderItemB2B(dto.getAverageUnitsPerOrderItemB2B());
        sales.setAverageSellingPrice(new Amount(dto.getAverageSellingPrice(), "USD"));
        sales.setUnitsRefunded(dto.getUnitsRefunded());
        sales.setRefundRate(dto.getRefundRate());
        sales.setClaimsGranted(dto.getClaimsGranted());
        sales.setClaimsAmount(new Amount(dto.getClaimsAmount(), "USD"));
        sales.setShippedProductSales(new Amount(dto.getShippedProductSales(), "USD"));
        sales.setUnitsShipped(dto.getUnitsShipped());
        sales.setOrdersShipped(dto.getOrdersShipped());

        Traffic traffic = new Traffic();
        traffic.setBrowserSessions(dto.getBrowserSessions());
        traffic.setBrowserSessionsB2B(dto.getBrowserSessionsB2B());
        traffic.setMobileAppSessions(dto.getMobileAppSessions());
        traffic.setMobileAppSessionsB2B(dto.getMobileAppSessionsB2B());
        traffic.setSessions(dto.getMobileAppSessions());
        traffic.setSessionsB2B(dto.getMobileAppSessionsB2B());
        traffic.setBuyBoxPercentage(dto.getBuyBoxPercentage());
        traffic.setBuyBoxPercentageB2B(dto.getBuyBoxPercentageB2B());
        traffic.setOrderItemSessionPercentage(dto.getOrderItemSessionPercentage());
        traffic.setOrderItemSessionPercentageB2B(dto.getOrderItemSessionPercentageB2B());
        traffic.setUnitSessionPercentage(dto.getUnitSessionPercentage());
        traffic.setUnitSessionPercentageB2B(dto.getUnitSessionPercentageB2B());
        traffic.setAverageOfferCount(dto.getAverageOfferCount());
        traffic.setAverageParentItems(dto.getAverageParentItems());
        traffic.setFeedbackReceived(dto.getFeedbackReceived());
        traffic.setNegativeFeedbackReceived(dto.getNegativeFeedbackReceived());
        traffic.setReceivedNegativeFeedbackRate(dto.getReceivedNegativeFeedbackRate());

        return new SalesAndTrafficByDate(null, sales, traffic);
    }

    public static SalesAndTrafficByAsin convertStatsByAsin(SalesAndTrafficByAsinDto dto) {
        Sales sales = new Sales();
        sales.setUnitsOrdered(dto.getUnitsOrdered());
        sales.setUnitsOrderedB2B(dto.getUnitsOrderedB2B());
        sales.setOrderedProductSales(new Amount(dto.getOrderedProductSales(), "USD"));
        sales.setOrderedProductSalesB2B(new Amount(dto.getOrderedProductSalesB2B(), "USD"));
        sales.setTotalOrderItems(dto.getTotalOrderItems());
        sales.setTotalOrderItemsB2B(dto.getTotalOrderItemsB2B());

        Traffic traffic = new Traffic();
        traffic.setBrowserSessions(dto.getBrowserSessions());
        traffic.setBrowserSessionsB2B(dto.getBrowserSessionsB2B());
        traffic.setMobileAppSessions(dto.getBrowserSessions());
        traffic.setMobileAppSessionsB2B(dto.getBrowserSessionsB2B());
        traffic.setSessions(dto.getSessions());
        traffic.setSessionsB2B(dto.getSessionsB2B());
        traffic.setBrowserSessionPercentage(dto.getBrowserSessionPercentage());
        traffic.setBrowserSessionPercentageB2B(dto.getBrowserSessionPercentageB2B());
        traffic.setMobileAppSessionPercentage(dto.getMobileAppSessionPercentage());
        traffic.setMobileAppSessionPercentageB2B(dto.getMobileAppSessionPercentageB2B());
        traffic.setSessionPercentage(dto.getSessionPercentage());
        traffic.setSessionPercentageB2B(dto.getSessionPercentageB2B());
        traffic.setBrowserPageViews(dto.getBrowserPageViews());
        traffic.setBrowserPageViewsB2B(dto.getBrowserPageViewsB2B());
        traffic.setMobileAppPageViews(dto.getMobileAppPageViews());
        traffic.setMobileAppPageViewsB2B(dto.getMobileAppPageViewsB2B());
        traffic.setPageViews(dto.getPageViews());
        traffic.setPageViewsB2B(dto.getPageViewsB2B());
        traffic.setBrowserPageViewsPercentage(dto.getBrowserPageViewsPercentage());
        traffic.setBrowserPageViewsPercentageB2B(dto.getBrowserPageViewsPercentageB2B());
        traffic.setMobileAppPageViewsPercentage(dto.getMobileAppPageViewsPercentage());
        traffic.setMobileAppPageViewsPercentageB2B(dto.getMobileAppPageViewsPercentageB2B());
        traffic.setPageViewsPercentage(dto.getPageViewsPercentage());
        traffic.setPageViewsPercentageB2B(dto.getPageViewsPercentageB2B());
        traffic.setBuyBoxPercentage(dto.getBuyBoxPercentage());
        traffic.setBuyBoxPercentageB2B(dto.getBuyBoxPercentageB2B());
        traffic.setUnitSessionPercentage(dto.getUnitSessionPercentage());
        traffic.setUnitSessionPercentageB2B(dto.getUnitSessionPercentageB2B());

        return new SalesAndTrafficByAsin(null, sales, traffic);
    }
}
