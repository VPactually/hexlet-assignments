package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        var flat = new Flat(54.5, 4, 3);
        System.out.println(flat);

        var cottage = new Cottage(120.5, 2);
        System.out.println(cottage);

        System.out.println(buildApartmentsList(List.of(cottage, flat), 2));
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
