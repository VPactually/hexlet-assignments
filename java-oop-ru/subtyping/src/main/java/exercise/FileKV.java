package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> data;
    private String filepath;

    public FileKV() {

    }
    public FileKV(String filepath, Map<String, String> data) {
        this.filepath = filepath;
        this.data = data;
        String strings = Utils.serialize(data);
        Utils.writeFile(filepath, strings);
    }

    @Override
    public void set(String key, String value) {
        this.data.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

}
// END
