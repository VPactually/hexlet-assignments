package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String toString() {
        var sb = new StringBuilder(String.format("<%s", name));
        attributes.forEach((k, v) -> {
            sb.append(String.format(" %s=\"%s\"", k, v));
        });
        return sb.append(">").toString();
    }
}
// END
