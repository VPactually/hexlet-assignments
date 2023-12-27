package exercise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String string) {
        var prefix = "X_FORWARDED_";
        Stream<String> stream = string.lines();
        var result = Arrays.stream(stream.filter(el -> el.contains(prefix) && el.contains("environment"))
                        .flatMap(el -> Stream.of(el.substring(el.indexOf(prefix))))
                        .collect(Collectors.joining(","))
                        .split(","))
                .filter(el -> el.contains(prefix))
                .map(el -> el.replaceAll(prefix, "").replaceAll("\"", ""))
                .collect(Collectors.joining(","));

        System.out.println(result);
        return result;
    }
}
//END
