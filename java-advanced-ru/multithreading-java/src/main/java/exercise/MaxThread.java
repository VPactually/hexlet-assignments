package exercise;


// BEGIN
public class MaxThread extends Thread {
    private int[] array;
    private int max = 0;

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
    }

    public MaxThread(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }
}
// END
