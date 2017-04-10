package Utilities;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Redis {
    public static void main(String[] args) {

        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("EqOptQaRedis01.nam.nsroot.net");

        // Select DB Number
        selectDB(jedis, 5);

        System.out.println("Connection to server sucessfully");
        System.out.println("Server is running: "+jedis.ping());

        stringRedis (jedis);
        listRedis(jedis);
        hashRedis(jedis);
        setRedis(jedis);

    }

    private static void flushRedis (Jedis jedis) {
        // jedis.flushAll();
        // System.out.println("Redis flushed...");
    }

    private static void selectDB(Jedis jedis, int dbNumber) {
        jedis.select(dbNumber);
    }

    private static void stringRedis (Jedis jedis) {
        System.out.println("--- String ---");

        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }

    private static void listRedis(Jedis jedis){
        // List
        System.out.println("--- List ---");
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");

        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("Stored string: " + list.get(i));
        }
    }

    private static void hashRedis(Jedis jedis) {
        // Hash
        System.out.println("--- Hash ---");
        String key = "java pointers";
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Java Pointers");
        map.put("domain", "www.javapointers.com");
        map.put("description", "Learn how to program in Java");
        jedis.hmset(key, map);

        Map<String, String> retrieveMap = jedis.hgetAll(key);
        for (String keyMap : retrieveMap.keySet()) {
            System.out.println(keyMap + " " + retrieveMap.get(keyMap));
        }

        String domainValue = jedis.hget(key, "domain");
        System.out.println("domainValue = " + domainValue);
    }

    private static void setRedis(Jedis jedis) {
        // Set
        Set<String> set = jedis.smembers("");

    }

    private static void sortedSetRedis(Jedis jedis) {
        // Sorted Set
        Set<String> resultFromRedis = jedis.zrangeByScore("some key", 0, -1);
        Set<Tuple> set1 = jedis.zrangeWithScores("some key", 0, 0);
        Set<Tuple> set2 = jedis.zrevrangeWithScores("some key", 0, 0);
        long lengthOfObjectSet = jedis.zcard("some key");
    }
}
