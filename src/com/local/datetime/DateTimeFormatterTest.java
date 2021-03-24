package com.local.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author
 * @date 2021-03-19-9:35
 */
public class DateTimeFormatterTest {

    @Test
    public void format() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String str = dtf.format(LocalDateTime.now());
        System.out.println(str);

        TemporalAccessor ta = dtf.parse(str);
        System.out.println(ta);
    }

    @Test
    public void ofLocalizedDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDateTime.now()));
    }

    @Test
    public void ofLocalizedDate(){
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now()));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(LocalDate.now()));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(LocalDate.now()));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.now()));
    }

    @Test
    public void ofPattern() {
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
    }

}
