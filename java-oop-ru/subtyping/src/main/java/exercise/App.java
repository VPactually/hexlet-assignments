package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void main(String[] args) {
        KeyValueStorage data = new InMemoryKV(Map.of("key", "10"));
        swapKeyValue(data);
    }

    public static void swapKeyValue(KeyValueStorage data) {
        var newMap = new HashMap<String, String>();
        var result = data.toMap();
        System.out.println(data);
        result.forEach((k, v) -> newMap.put(v, k));
        data.toMap().clear();
        newMap.forEach(data::set);
        System.out.println(data);
    }
}
// END
