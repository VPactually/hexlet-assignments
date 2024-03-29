package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String body;

    private List<Tag> children;


    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(super.toString());
        children.forEach(child -> sb.append(child.toString()));
        return sb.append(String.format("%s</%s>", body, name)).toString();
    }
}
// END
