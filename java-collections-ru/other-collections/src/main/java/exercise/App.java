package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> mapFirst, Map<String, Object> mapSecond) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        var map1 = mapFirst;
        var map2 = mapSecond;

        map1.forEach((k1, v1) -> {
            if (map2.containsKey(k1) && map2.get(k1).equals(map1.get(k1))) {
                result.put(k1, "unchanged");
                map2.remove(k1);
            } else if (!map2.containsKey(k1)) {
                result.put(k1, "deleted");
                map2.remove(k1);
            } else if (map2.containsKey(k1) && !map2.get(k1).equals(map1.get(k1))) {
                result.put(k1, "changed");
                map2.remove(k1);
            }
        });
        if (!map2.isEmpty()) {
            map2.forEach((k1, v1) -> {
                result.put(k1, "added");
            });
        }
        return result;
    }
}
//END
