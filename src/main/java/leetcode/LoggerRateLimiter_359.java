package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Question: 359. Logger Rate Limiter
Link: https://leetcode.com/problems/logger-rate-limiter/
 */
public class LoggerRateLimiter_359 {
    public static void main(String[] args) {
        var obj = new LoggerRateLimiter_359().new Logger();
        System.out.println(obj.shouldPrintMessage(1, "foo"));
        System.out.println(obj.shouldPrintMessage(2, "bar"));
        System.out.println(obj.shouldPrintMessage(3, "foo"));
        System.out.println(obj.shouldPrintMessage(8, "bar"));
        System.out.println(obj.shouldPrintMessage(11, "foo"));
        System.out.println(obj.shouldPrintMessage(12, "bar"));
    }

    class Logger {
        private final Map<String, Integer> messageTimestampMap;

        public Logger() {
            messageTimestampMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer prevTimeStamp = messageTimestampMap.getOrDefault(message, -1);
            if (prevTimeStamp == -1 || timestamp - prevTimeStamp >= 10) {
                messageTimestampMap.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
