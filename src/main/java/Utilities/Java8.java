package Utilities;

import java.util.Arrays;
import java.util.List;

public class Java8 {

    public static void main(String[] args) {
        streams();
    }

    private static void streams(){
        System.out.println("Running loop as stream, Does not run in order...");
        List<String> fruitList = Arrays.asList("avocado", "lemon", "coconut");
        fruitList.parallelStream().forEach((fruit) -> {
            System.out.println("fruit = " + fruit);
        });
    }
}
