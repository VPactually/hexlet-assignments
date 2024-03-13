package exercise;

// BEGIN
public class MinThread extends Thread{
    private int[] array;
    private int min = 0;

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i], min);
        }
    }

    public MinThread(int[] array) {
        this.array = array;
    }

    public int getMin() {
        return min;
    }
}
// END
