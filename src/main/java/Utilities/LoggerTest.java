package Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LoggerTest {
    static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        System.out.println("Using slf4j...");
        logger.info("Logger - Info");
        logger.error("Logger - Error");

        String slf4j = "slf4j";
        logger.info(MessageFormatter.format("Testing input for {} ", slf4j).getMessage());

        Double num = Double.NaN;

        testTime();
    }

    public static void testTime() {

        System.out.println("Running time test...");

        LocalDateTime now = LocalDateTime.now();

        System.err.println("Starting Time:"+ LocalDateTime.now().until( now, ChronoUnit.MILLIS));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println("Total Time: " + LocalDateTime.now().until(now, ChronoUnit.MICROS));
    }
}
