package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var result = new HashMap<String, Integer>();
        var thread1 = new MaxThread(numbers);
        var thread2 = new MinThread(numbers);

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var min = thread2.getMin();
        var max = thread1.getMax();

        result.put("min", min );
        result.put("max", max);
        return result;
    }
    // END
}
