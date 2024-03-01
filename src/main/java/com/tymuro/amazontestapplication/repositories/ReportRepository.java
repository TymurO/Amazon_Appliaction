package com.tymuro.amazontestapplication.repositories;

import com.tymuro.amazontestapplication.dto.SalesAndTrafficByAsinDto;
import com.tymuro.amazontestapplication.dto.SalesAndTrafficByDateDto;
import com.tymuro.amazontestapplication.models.Report;
import com.tymuro.amazontestapplication.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {

    @Query("{ 'salesAndTrafficByAsin.parentAsin': { $in: ?0 } }")
    List<Report> getReportsByAsins(List<String> asins);

    @Aggregation(pipeline = {
            "{ '$unwind': '$salesAndTrafficByDate' }",
            "{ '$group': { '_id': null, " +
                    "'orderedProductSales': { $sum: '$salesAndTrafficByDate.salesByDate.orderedProductSales.amount' }," +
                    "'orderedProductSalesB2B': { $sum: '$salesAndTrafficByDate.salesByDate.orderedProductSalesB2B.amount' }," +
                    "'unitsOrdered': { $sum: '$salesAndTrafficByDate.salesByDate.unitsOrdered' }," +
                    "'unitsOrderedB2B': { $sum: '$salesAndTrafficByDate.salesByDate.unitsOrderedB2B' }," +
                    "'totalOrderItems': { $sum: '$salesAndTrafficByDate.salesByDate.totalOrderItems' }," +
                    "'totalOrderItemsB2B': { $sum: '$salesAndTrafficByDate.salesByDate.totalOrderItemsB2B' }," +
                    "'averageSalesPerOrderItem': { $sum: '$salesAndTrafficByDate.salesByDate.averageSalesPerOrderItem.amount' }," +
                    "'averageSalesPerOrderItemB2B': { $sum: '$salesAndTrafficByDate.salesByDate.averageSalesPerOrderItemB2B.amount' }," +
                    "'averageUnitsPerOrderItem': { $sum: '$salesAndTrafficByDate.salesByDate.averageUnitsPerOrderItem' }," +
                    "'averageUnitsPerOrderItemB2B': { $sum: '$salesAndTrafficByDate.salesByDate.averageUnitsPerOrderItemB2B' }," +
                    "'averageSellingPrice': { $sum: '$salesAndTrafficByDate.salesByDate.averageSellingPrice.amount' }," +
                    "'averageSellingPriceB2B': { $sum: '$salesAndTrafficByDate.salesByDate.averageSellingPriceB2B.amount' }," +
                    "'unitsRefunded': { $sum: '$salesAndTrafficByDate.salesByDate.unitsRefunded' }," +
                    "'refundRate': { $sum: '$salesAndTrafficByDate.salesByDate.refundRate' }," +
                    "'claimsGranted': { $sum: '$salesAndTrafficByDate.salesByDate.claimsGranted' }," +
                    "'claimsAmount': { $sum: '$salesAndTrafficByDate.salesByDate.claimsAmount.amount' }," +
                    "'shippedProductSales': { $sum: '$salesAndTrafficByDate.salesByDate.shippedProductSales.amount' }," +
                    "'unitsShipped': { $sum: '$salesAndTrafficByDate.salesByDate.unitsShipped' }," +
                    "'ordersShipped': { $sum: '$salesAndTrafficByDate.salesByDate.ordersShipped' }," +
                    "'browserPageViews': { $sum: '$salesAndTrafficByDate.trafficByDate.browserPageViews' }," +
                    "'browserPageViewsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.browserPageViewsB2B' }," +
                    "'mobileAppPageViews': { $sum: '$salesAndTrafficByDate.trafficByDate.mobileAppPageViews' }," +
                    "'mobileAppPageViewsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.mobileAppPageViewsB2B' }," +
                    "'pageViews': { $sum: '$salesAndTrafficByDate.trafficByDate.pageViews' }," +
                    "'pageViewsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.pageViewsB2B' }," +
                    "'browserSessions': { $sum: '$salesAndTrafficByDate.trafficByDate.browserSessions' }," +
                    "'browserSessionsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.browserSessionsB2B' }," +
                    "'mobileAppSessions': { $sum: '$salesAndTrafficByDate.trafficByDate.mobileAppSessions' }," +
                    "'mobileAppSessionsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.mobileAppSessionsB2B' }," +
                    "'sessions': { $sum: '$salesAndTrafficByDate.trafficByDate.sessions' }," +
                    "'sessionsB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.sessionsB2B' }," +
                    "'buyBoxPercentage': { $sum: '$salesAndTrafficByDate.trafficByDate.buyBoxPercentage' }," +
                    "'buyBoxPercentageB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.buyBoxPercentageB2B' }," +
                    "'orderItemSessionPercentage': { $sum: '$salesAndTrafficByDate.trafficByDate.orderItemSessionPercentage' }," +
                    "'orderItemSessionPercentageB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.orderItemSessionPercentageB2B' }," +
                    "'unitSessionPercentage': { $sum: '$salesAndTrafficByDate.trafficByDate.unitSessionPercentage' }," +
                    "'unitSessionPercentageB2B': { $sum: '$salesAndTrafficByDate.trafficByDate.unitSessionPercentageB2B' }," +
                    "'averageOfferCount': { $sum: '$salesAndTrafficByDate.trafficByDate.averageOfferCount' }," +
                    "'averageParentItems': { $sum: '$salesAndTrafficByDate.trafficByDate.averageParentItems' }," +
                    "'feedbackReceived': { $sum: '$salesAndTrafficByDate.trafficByDate.feedbackReceived' }," +
                    "'negativeFeedbackReceived': { $sum: '$salesAndTrafficByDate.trafficByDate.negativeFeedbackReceived' }," +
                    "'receivedNegativeFeedbackRate': { $sum: '$salesAndTrafficByDate.trafficByDate.receivedNegativeFeedbackRate' }," +
                    " } }"
    })
    SalesAndTrafficByDateDto getStatisticForAllTime();

    @Aggregation(pipeline = {
            "{ '$unwind': '$salesAndTrafficByAsin' }",
            "{ '$group': { '_id': null, " +
                    "'unitsOrdered': { $sum: '$salesAndTrafficByAsin.salesByAsin.unitsOrdered' }," +
                    "'unitsOrderedB2B': { $sum: '$salesAndTrafficByAsin.salesByAsin.unitsOrderedB2B' }," +
                    "'orderedProductSales': { $sum: '$salesAndTrafficByAsin.salesByAsin.orderedProductSales.amount' }," +
                    "'orderedProductSalesB2B': { $sum: '$salesAndTrafficByAsin.salesByAsin.orderedProductSalesB2B.amount' }," +
                    "'totalOrderItems': { $sum: '$salesAndTrafficByAsin.salesByAsin.totalOrderItems' }," +
                    "'totalOrderItemsB2B': { $sum: '$salesAndTrafficByAsin.salesByAsin.totalOrderItemsB2B' }," +
                    "'browserSessions': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserSessions' }," +
                    "'browserSessionsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserSessionsB2B' }," +
                    "'mobileAppSessions': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppSessions' }," +
                    "'mobileAppSessionsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppSessionsB2B' }," +
                    "'sessions': { $sum: '$salesAndTrafficByAsin.trafficByAsin.sessions' }," +
                    "'sessionsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.sessionsB2B' }," +
                    "'browserSessionsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserSessionsPercentage' }," +
                    "'browserSessionsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserSessionsPercentageB2B' }," +
                    "'mobileAppSessionsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppSessionsPercentage' }," +
                    "'mobileAppSessionsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppSessionsPercentageB2B' }," +
                    "'sessionsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.sessionsPercentage' }," +
                    "'sessionsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.sessionsPercentageB2B' }," +
                    "'browserPageViews': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserPageViews' }," +
                    "'browserPageViewsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserPageViewsB2B' }," +
                    "'mobileAppPageViews': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppPageViews' }," +
                    "'mobileAppPageViewsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppPageViewsB2B' }," +
                    "'pageViews': { $sum: '$salesAndTrafficByAsin.trafficByAsin.pageViews' }," +
                    "'pageViewsB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.pageViewsB2B' }," +
                    "'browserPageViewsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserPageViewsPercentage' }," +
                    "'browserPageViewsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.browserPageViewsPercentageB2B' }," +
                    "'mobileAppPageViewsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppPageViewsPercentage' }," +
                    "'mobileAppPageViewsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.mobileAppPageViewsPercentageB2B' }," +
                    "'pageViewsPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.pageViewsPercentage' }," +
                    "'pageViewsPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.pageViewsPercentageB2B' }," +
                    "'buyBoxPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.buyBoxPercentage' }," +
                    "'buyBoxPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.buyBoxPercentageB2B' }," +
                    "'unitSessionPercentage': { $sum: '$salesAndTrafficByAsin.trafficByAsin.unitSessionPercentage' }," +
                    "'unitSessionPercentageB2B': { $sum: '$salesAndTrafficByAsin.trafficByAsin.unitSessionPercentageB2B' }," +
                    " } }"
    })
    SalesAndTrafficByAsinDto getStatisticForEveryAsin();
}
