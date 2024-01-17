package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface){
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", tag, tagInterface.render());
    }
}
// END
