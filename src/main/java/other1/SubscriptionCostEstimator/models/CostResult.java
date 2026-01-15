package main.java.other1.SubscriptionCostEstimator.models;

import java.util.List;

public class CostResult {
    public List<Double> monthlyCosts;
    public double annualCost;

    public CostResult(List<Double> monthlyCosts, double annualCost) {
        this.monthlyCosts = monthlyCosts;
        this.annualCost = annualCost;
    }
}
