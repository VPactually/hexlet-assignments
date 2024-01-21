package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String msg;

    public NegativeRadiusException(String msg) {
        this.msg = msg;
    }
}
// END
