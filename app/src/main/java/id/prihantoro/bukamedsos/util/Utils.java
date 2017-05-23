package id.prihantoro.bukamedsos.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by wahyu on 23 Mei 2017.
 */

public class Utils {
    public static String toRupiahFormat(String nominal) {
        Locale locale = new Locale("id", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(locale);

        return rupiahFormat.format(Double.parseDouble(nominal));
    }
}
