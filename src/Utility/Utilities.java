package Utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilities {

    static NumberFormat formattingValues = new DecimalFormat("$ #,##0.00");
    
    public static String doubleToString(Double value) {
        return Utilities.formattingValues.format(value);
    }
}
