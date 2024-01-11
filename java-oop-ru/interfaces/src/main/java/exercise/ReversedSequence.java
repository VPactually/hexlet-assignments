package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String string;
    public ReversedSequence(String string){
        var sb = new StringBuilder();
        var res = string.split("");
        for (int i = res.length - 1 ; i >= 0; i--) {
            sb.append(res[i]);
        }
        this.string = sb.toString();
    }
    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return this.string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.subSequence(start, end);
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
