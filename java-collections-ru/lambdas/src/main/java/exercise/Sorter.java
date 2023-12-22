package exercise;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "female"),
                Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "female"),
                Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female")
        );

        System.out.println(takeOldestMans(users));
    }

    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(user -> user.containsValue("male"))
                .sorted(Comparator.comparing(user -> {
                    var dateString = user.get("birthday");
                    return LocalDate.parse(dateString);
                }))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
