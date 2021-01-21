import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private static Map<String, List<String>> map = new HashMap<>();

    public static void add(String name, String phoneNumber) {
        List<String> put = map.getOrDefault(name, new ArrayList());
        put.add(phoneNumber);
        map.put(name, put);
    }

    public static List<String> get(String name) {
        return map.get(name);
    }

    public static void info() {
        System.out.println(map);
    }
}
