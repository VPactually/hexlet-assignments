package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    private static final List<Map<String, String>> BOOKS = List.of(
            Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611"),
            Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111"),
            Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611"),
            Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222"),
            Map.of("title", "Still foooing", "author", "FooBar", "year", "3333"),
            Map.of("title", "Happy Foo", "author", "FooBar", "year", "4444")
    );

    public static void main(String[] args) {
        System.out.println(findWhere(BOOKS, Map.of("author", "Shakespeare", "year", "1611")));

    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> lists, Map<String, String> map) {
        var res = new ArrayList<Map<String, String>>();
        var list = new ArrayList<>(lists);

        for (var book : list) {
            if (book.values().containsAll(map.values())) {
                res.add(book);
            }
        }
        return res;
    }
}
//END
