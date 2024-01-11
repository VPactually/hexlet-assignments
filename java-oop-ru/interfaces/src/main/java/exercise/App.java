package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        var reversedSequence = new ReversedSequence("String");
        System.out.println(reversedSequence);
        System.out.println(reversedSequence.charAt(2));
        System.out.println(reversedSequence.subSequence(1, 4));
        System.out.println(reversedSequence.length());
    }

    public static List<String> buildApartmentsList(List<Home> list, int count) {

        var result = new ArrayList<>(list);
        var stringResult = new ArrayList<String>(count);
        result.sort(Home::compareTo);
        result.forEach(el -> stringResult.add(el.toString()));
        count = Math.min(count, stringResult.size());
        return stringResult.subList(0, count);
    }
}
// END
