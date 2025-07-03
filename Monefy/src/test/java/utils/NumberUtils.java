package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {

    private static String currencySymbol = "$"; // default fallback

    public static void setCurrencySymbol(String symbol) {
        currencySymbol = symbol;
    }

    public static String getCurrencySymbol() {
        return currencySymbol;
    }

    public static String formatAsCurrency(double amount) {
        return String.format("%s%,.2f", currencySymbol, amount);
    }
}