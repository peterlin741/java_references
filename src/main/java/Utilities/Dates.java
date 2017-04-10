package Utilities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dates {
    public static void main(String[] args) {
        Date_Demo();
        LocalDate_Demo();
        LocalTime_Demo();
        LocalDateTime_Demo();
    }

    public static void Date_Demo() {
        System.out.println("---Dates Demo---");
        Date d = new Date();
        long t1 = d.getTime();

        Date d2 = new Date(95, 10, 10, 12, 01, 01);

        System.out.println("d = " + d);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(d);

        System.out.println("Calendar - Current Time");
        System.out.println("Hour: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + calendar.get(Calendar.MINUTE));

        Calendar cal = Calendar.getInstance();
        cal.setTime(d); // your date (java.util.Date)
        cal.add(Calendar.DATE, -1);
        d=cal.getTime();
        System.out.println("Yesterday: " + cal.getTime());

        System.out.println("\n");
    }

    public static void LocalDate_Demo() {
        System.out.println("---LocalDate Demo---");
        String localDateString = "2000.01.01";
        LocalDate localDate = LocalDate.parse(localDateString, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        System.out.println("localDate = " + localDate);

        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("hh:mm");
        DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("hh:mm:ss.SSS");

        System.out.println("\n");
    }


    public static void LocalTime_Demo() {
        System.out.println("---LocalTime Demo---");
        LocalTime time = LocalTime.of(8, 19, 59, 11001);
        time = time.plusMinutes(10);
        System.out.println("time = " + time);

        System.out.println(LocalTime.parse("10:15:30"));
        System.out.println(LocalTime.parse("10:15:30."));
        System.out.println(LocalTime.parse("10:15:30.1"));
        System.out.println(LocalTime.parse("10:15:30.12345789"));

        LocalDateTime localDateTime = convertFromTimeToDateTime(time);
        System.out.println(localDateTime);

        System.out.println("\n");
    }

    public static void LocalDateTime_Demo() {
        System.out.println("---LocalDateTime Demo---");
        LocalDateTime toDateTime = LocalDateTime.of(2014, 9, 10, 6, 40, 45);

        LocalDateTime startTime = LocalDateTime.of(2014, Month.JANUARY, 1, 9, 1, 0);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formattedStartTime = startTime.format(formatter);
        System.out.println("formattedStartTime = " + formattedStartTime);

        LocalDateTime endTime = startTime.plusMinutes(1);
        String formattedEndTime = endTime.format(formatter);
        System.out.println("formattedEndTime = " + formattedEndTime);
        
        System.out.println("toDateTime = " + toDateTime);
        LocalDateTime_Difference_In_Time();

        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDateTime = specificDate.format(formatter2); // "1986-04-08 12:30"
        System.out.println(formattedDateTime);

        System.out.println("\n");
    }

    public static void LocalDateTime_Difference_In_Time() {
        System.out.println("LocalDateTime_Difference_In_Time()");

        LocalDateTime fromDateTime = LocalDateTime.of(1984, 12, 16, 7, 45, 55);
        LocalDateTime toDateTime = LocalDateTime.of(2014, 9, 10, 6, 40, 45);

        LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );

        long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears( years );

        long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths( months );

        long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( days );

        long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( hours );

        long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes( minutes );

        long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);

        System.out.println( years + " years " +
                months + " months " +
                days + " days " +
                hours + " hours " +
                minutes + " minutes " +
                seconds + " seconds");

        long diffInSec = seconds + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60;
        System.out.println("diffInSec = " + diffInSec);
    }

    private static LocalDateTime convertFromTimeToDateTime(LocalTime time) {

        System.out.println("convertFromTimeToDateTime()");

        LocalDate now = LocalDate.now();

        int year =  now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();

        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        int nano = time.getNano();

        LocalDateTime when = LocalDateTime.of(year, monthValue, dayOfMonth, hour, minute, second, nano);
        return when;
    }
}
