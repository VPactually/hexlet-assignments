package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        var newMap = new HashMap<String, String>();
        var result = data.toMap();
        System.out.println(data);
        result.forEach((k, v) -> {
            newMap.put(v, k);
            data.unset(k);
        });
        newMap.forEach(data::set);
    }
}
// END
