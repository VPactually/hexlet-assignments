package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println(toString(getWordCount("word text cat apple word map apple word")));
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Map.Entry<String, Integer> word : map.entrySet()) {
            sb.append("  ").append(word.getKey()).append(": ").append(word.getValue()).append("\n");
        }
        sb.append("}");
        return sb.toString();

    }

    public static Map<String, Integer> getWordCount(String string) {
        if (string.isEmpty()) {
            return new HashMap<>();
        }
        var text = string.split(" ");
        var res = new HashMap<String, Integer>();
        for (var word : text) {
            if (!res.containsKey(word)) {
                res.put(word, 1);
            } else {
                res.put(word, res.get(word) + 1);
            }
        }
        return res;
    }
}
//END
