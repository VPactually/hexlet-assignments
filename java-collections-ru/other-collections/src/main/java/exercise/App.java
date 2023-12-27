package exercise;

import java.util.*;

// BEGIN
public class App {
    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}
        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }

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
