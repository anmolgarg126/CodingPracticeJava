package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Question: 3606. Coupon Code Validator
Link: https://leetcode.com/problems/coupon-code-validator
 */
public class CouponCodeValidator_3606 {
    public static void main(String[] args) {
        var obj = new CouponCodeValidator_3606();
        System.out.println(obj.validateCoupons(new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"}, new String[]{"restaurant", "grocery", "pharmacy", "restaurant"}, new boolean[]{true, true, true, true}));
        System.out.println(obj.validateCoupons(new String[]{"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"}, new String[]{"grocery", "electronics", "invalid"}, new boolean[]{false, true, true}));
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Res> res = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValidCode(code[i]) && isValidBusinessCode(businessLine[i])) {
                res.add(new Res(code[i], businessLine[i]));
            }
        }

        return res.stream().sorted().map(Res::getCode).collect(Collectors.toList());
    }

    private boolean isValidBusinessCode(String businessLine) {
        if (businessLine == null || businessLine.isEmpty()) {
            return false;
        }
        return businessLine.equals("electronics") || businessLine.equals("grocery") || businessLine.equals("pharmacy") || businessLine.equals("restaurant");
    }

    private boolean isValidCode(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        for (char c : code.toCharArray()) {
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    static class Res implements Comparable<Res> {
        public String getCode() {
            return code;
        }

        String code;
        String businessLine;

        Res(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }

        private static int rank(String bl) {
            if (bl == null) return Integer.MAX_VALUE;
            return switch (bl) {
                case "electronics" -> 0;
                case "grocery" -> 1;
                case "pharmacy" -> 2;
                case "restaurant" -> 3;
                default -> Integer.MAX_VALUE; // unknowns go last
            };
        }

        @Override
        public int compareTo(Res res) {
            int r1 = rank(this.businessLine);
            int r2 = rank(res.businessLine);
            if (r1 != r2) {
                return Integer.compare(r1, r2);
            }
            return this.code.compareTo(res.code);
        }
    }
}
