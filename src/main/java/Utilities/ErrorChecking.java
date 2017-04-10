package Utilities;

import java.time.format.DateTimeParseException;

public class ErrorChecking {

    public static void main(String[] args) {
        printStackTrace();
    }

    private static void printStackTrace(){
        try {
            System.err.println("No error, e will not print");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        }
    }

    public static void differentExceptions() {
        try {
        //} catch ( IOException e) {
        } catch (DateTimeParseException ex) {
        } catch (Exception e) {
        }

    }

}
