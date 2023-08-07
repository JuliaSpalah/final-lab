package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static final Pattern PRICE_PATTERN = Pattern.compile("(?![$€£])[0-9]+([.,][0-9]+)?");

    public static double extractPriceValue(String str) {
        Matcher matcher = PRICE_PATTERN.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(0).replace(',', '.'));
        }
        return 0;
    }
}
