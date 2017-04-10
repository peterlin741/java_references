package Utilities;

import java.util.*;


public class DataStructures {
    public static void main(String[] args) {
        List_Demo();
        Map_Demo();
        Set_Demo();
    }

    private static void List_Demo() {
        List myList = new ArrayList();
        List<Integer> myList2 = new ArrayList<Integer>();
        List<String> myList3 = Arrays.asList("string 1", "string 2");

        myList2.add(3);
        myList2.add(4);
        myList2.remove(1);

        System.out.println("myList2 = " + myList2);
        System.out.println("myList3 = " + myList3);
        System.out.println("myList3[0] = " + myList3.get(0));
    }


    // HashSet allows only one null key, but HashMap can allow one null key + multiple null values

    private static void Map_Demo() {
        Map map1 = new HashMap <String, String>();

        HashMap<String, String> map3 = new HashMap<String, String>(){
        {
            put("date", "today");
            put("hello", "world");
        }};

        map3.put("Kyle", "Simpson");
        String sol = "map3[Kyle] = " + map3.get("Kyle");

        System.out.println("sol = " + sol);
        System.out.println("map3 = " + map3);

    }

    private static void Set_Demo() {
        Set set = new HashSet <String>();
        System.out.println("set = " + set);
    }

}
