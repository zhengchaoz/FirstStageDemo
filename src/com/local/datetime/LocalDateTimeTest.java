package com.local.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author
 * @date 2021-03-19-8:28
 */
public class LocalDateTimeTest {

    @Test
    public void now() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void of() {
        System.out.println(LocalDate.of(2014, 11, 5));
        System.out.println(LocalTime.of(13, 45, 2));
        System.out.println(LocalDateTime.of(2011, 4, 13, 22, 5));
    }

    @Test
    public void get() {
        System.out.println(LocalDateTime.now().getYear());
        System.out.println(LocalDateTime.now().getMonth());
        System.out.println(LocalDateTime.now().getMonthValue());
        System.out.println(LocalDateTime.now().getDayOfWeek());
        System.out.println(LocalDateTime.now().getDayOfYear());
        System.out.println(LocalDateTime.now().getDayOfMonth());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.now().getMinute());
        System.out.println(LocalDateTime.now().getSecond());
        System.out.println(LocalDateTime.now().getNano());
    }

    @Test
    public void with() {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().withYear(2020));
        System.out.println(LocalDateTime.now().withMonth(12));
        System.out.println(LocalDateTime.now().withDayOfMonth(5));
        System.out.println(LocalDateTime.now().withHour(12));
        System.out.println(LocalDateTime.now().withMinute(49));
        System.out.println(LocalDateTime.now().withSecond(1));
    }

    @Test
    public void plus() {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().plusYears(4));
        System.out.println(LocalDateTime.now().plusMonths(6));
        System.out.println(LocalDateTime.now().plusDays(10));
        System.out.println(LocalDateTime.now().plusHours(8));
        System.out.println(LocalDateTime.now().plusMinutes(10));
    }

    @Test
    public void minus() {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().minusYears(2));
        System.out.println(LocalDateTime.now().minusMonths(5));
        System.out.println(LocalDateTime.now().minusDays(5));
        System.out.println(LocalDateTime.now().minusHours(12));
    }

}
