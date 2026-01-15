package main.java.other1.SubscriptionCostEstimator.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostExplorer {
    private static final int NO_OF_DAYS_IN_MONTH = 30;
    private static final int NO_OF_MONTH_IN_YEAR = 12;
    private static final int DAYS_IN_YEAR = NO_OF_DAYS_IN_MONTH * NO_OF_MONTH_IN_YEAR;

    private final Map<String, Double> planMonthlyRates = new HashMap<>();

    public void upsertPlan(String planId, double monthlyRate) {
        planMonthlyRates.put(planId, monthlyRate);
    }

    public CostResult calculate(int year, List<SubscriptionSegment> segments) {
        double[] monthly = new double[NO_OF_MONTH_IN_YEAR];
        for (SubscriptionSegment segment : segments) {
            Double rate = planMonthlyRates.get(segment.planId);
            if (rate == null) {
                throw new IllegalArgumentException("no data found");
            }

            int segStart = clampToYearDayIndex(segment.startDate, year, true);
            int segEnd = clampToYearDayIndex(segment.endDate, year, false);

            if (segStart > segEnd) {
                continue;
            }

            for (int m = 1; m <= NO_OF_MONTH_IN_YEAR; m++) {
                int monthStart = (m - 1) * NO_OF_DAYS_IN_MONTH + 1;
                int monthEnd = m * NO_OF_DAYS_IN_MONTH;

                int overlap = overlapDays(segStart, segEnd, monthStart, monthEnd);

                if (overlap > 0) {
                    monthly[m - 1] += rate * (overlap / (double) NO_OF_DAYS_IN_MONTH);
                }
            }
        }
        List<Double> monthyList = new ArrayList<>(NO_OF_MONTH_IN_YEAR);
        double annual = 0.0;
        for (double v : monthly) {
            double rounded = round2(v);
            monthyList.add(rounded);
            annual += rounded;
        }

        return new CostResult(monthyList, annual);
    }

    private static double round2(double x) {
        return Math.round(x * 100.0) / 100.0;
    }

    private static int overlapDays(int aStart, int aEnd, int bStart, int bEnd) {
        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);
        return Math.max(0, end - start + 1);
    }

    private int clampToYearDayIndex(LocalDate date, int year, boolean isStart) {
        if (date == null) {
            return isStart ? 1 : DAYS_IN_YEAR;
        }

        if (date.getYear() < year) {
            return isStart ? 1 : 0;
        }
        if (date.getYear() > year) {
            return isStart ? DAYS_IN_YEAR + 1 : DAYS_IN_YEAR;
        }
        int month = date.getMonthValue();
        int day = Math.min(date.getDayOfMonth(), NO_OF_DAYS_IN_MONTH);
        int idx = (month - 1) * NO_OF_DAYS_IN_MONTH + day;

        return Math.max(1, Math.min(idx, DAYS_IN_YEAR));
    }
}
