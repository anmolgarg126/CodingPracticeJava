package main.java.other1.SubscriptionCostEstimator.models;

import java.time.LocalDate;

public class SubscriptionSegment {
    public final String productId;
    public final String planId;
    public final LocalDate startDate;
    public final LocalDate endDate;

    public SubscriptionSegment(String productId, String planId, LocalDate startDate, LocalDate endDate) {
        this.productId = productId;
        this.planId = planId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
