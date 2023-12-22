package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) {
        String[][] arr = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        enlargeArrayImage(arr);
    }

    public static String[][] enlargeArrayImage(String[][] oldArray) {
        String[][] enlargedImage = new String[oldArray.length * 2][oldArray[0].length * 2];

        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].length; j++) {
                String pixel = oldArray[i][j];
                enlargedImage[2 * i][2 * j] = pixel;
                enlargedImage[2 * i][2 * j + 1] = pixel;
                enlargedImage[2 * i + 1][2 * j] = pixel;
                enlargedImage[2 * i + 1][2 * j + 1] = pixel;
            }
        }

        return enlargedImage;
    }
}
// END
