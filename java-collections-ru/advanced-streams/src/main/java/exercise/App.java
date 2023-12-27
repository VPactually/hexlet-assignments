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

    private static String data1;
    private static String data2;

    private static int counter = 0;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }


    public static void main(String[] args) throws Exception {
        data1 = readFixture("s1.conf");
        data2 = readFixture("s2.conf");
        System.out.println("\n\n" + getForwardedVariables(data2));
    }

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
