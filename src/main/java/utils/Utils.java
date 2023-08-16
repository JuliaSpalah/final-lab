package utils;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static void waitSeconds(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Can`t wait for " + seconds + " seconds");
        }
    }

    public static double sanitizePrice(double price) {
        return Math.round(price * 100.0d) / 100.0d;
    }

    public static double sumPrice(double a, double b) {
        return sanitizePrice(a + b);
    }
}
