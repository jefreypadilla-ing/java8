package com.jpadilla.java8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * @author ing_jefreypadilla@hotmail.com
 * https://www.baeldung.com/java-8-date-time-intro
 */
public class WorkingDateTimeAPI {

    // Working with LocalDate
    public static void localDate(){
        LocalDate localDate = LocalDate.now(); // Without time format: yyyy-MM-dd
        System.out.println("Short date: " + localDate);

        LocalDate fecha = LocalDate.of(2018, 10, 19);
        System.out.println("Convert Date: " + fecha);

        LocalDate parse = LocalDate.parse("2018-10-19");
        System.out.println("Parse Date: " + parse);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Add days date: " + tomorrow);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("Previous Month: " + previousMonthSameDay);

        DayOfWeek dayOfWeek = LocalDate.parse("2018-10-19").getDayOfWeek();
        System.out.println("Day of week: " + dayOfWeek);

        int dayOfMonth = LocalDate.parse("2018-10-19").getDayOfMonth();
        System.out.println("Day of month: "+ dayOfMonth);

        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("Leap Year: "+ leapYear);

        boolean notBefore = LocalDate.parse("2018-10-19")
                .isBefore(LocalDate.parse("2018-10-18"));

        System.out.println("Not before (2018-10-19 -> 2018-10-18): " + notBefore);

        boolean isAfter = LocalDate.parse("2018-10-19")
                .isAfter(LocalDate.parse("2018-10-18"));

        System.out.println("is After (2018-10-19 -> 2018-10-18): " + isAfter);

    }

    // Working with LocalTime
    public static void localTime(){
        LocalTime now = LocalTime.now();
        System.out.println("Hora Actual: " + now);

        LocalTime sixThirty = LocalTime.parse("06:30");
        System.out.println("Time parse: " + sixThirty);

        LocalTime sixThirtyOf = LocalTime.of(6, 30);
        System.out.println("Time Of: " + sixThirtyOf);

        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        System.out.println("Add hours: "+ sevenThirty);

        int six = LocalTime.parse("06:30").getHour();
        System.out.println("Get Hour: " + six);

        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        System.out.println("Is Before (06:30 -> 07:30): " + isbefore);

        LocalTime maxTime = LocalTime.MAX;
        System.out.println("Max Time: " + maxTime);
    }

    // Working with LocalDateTime
    public static void localDateTime(){

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current: "+localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        System.out.println("LocalDateTime Of: "+ localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.parse("2015-02-20T06:30:00");
        System.out.println("Local Date Time Parse: " + localDateTime2);

        LocalDateTime plusDay = localDateTime.plusDays(1);
        System.out.println("Plus Day: " + plusDay);

    }

    // Working with ZonedDateTime
    public static void zonedDateTime(){
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        System.out.println("Zone: " + zoneId);

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("Zones");
        allZoneIds.stream().limit(5).forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println("Zoned Date Time convert: "+ zonedDateTime);
    }

    // Working with ZonedDateTime
    public static void workWithPeriods(){

        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        int five = Period.between(initialDate, finalDate).getDays();
        System.out.println("Initial Day (2007-05-10 -> +(5)): " + five);

        long fiveChron = ChronoUnit.DAYS.between(initialDate , initialDate);
        System.out.println("ChronoUnit Initial Day (2007-05-10 -> +(5)): " + five);

    }

}
