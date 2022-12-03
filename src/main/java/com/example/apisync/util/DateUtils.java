package com.example.apisync.util;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtils {
    public static Date formatToDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX")
                    .parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }
}
