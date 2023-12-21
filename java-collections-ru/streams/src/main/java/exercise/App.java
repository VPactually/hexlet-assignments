package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    static String[] emails = {
            "info@gmail.com",
            "info@yandex.ru",
            "mk@host.com",
            "support@hexlet.io",
            "info@hotmail.com",
            "support.yandex.ru@host.com"
    };

    public static void main(String[] args) {
        System.out.println(getCountOfFreeEmails(Arrays.stream(emails).toList()));
    }

    public static int getCountOfFreeEmails(List<String> emails) {
        var listOfFreeEmail = List.of("gmail.com", "yandex.ru", "hotmail.com");
        var res1 = emails.stream().filter(email -> listOfFreeEmail.contains(email.split("@")[1])).count();
        return (int) res1;
    }
}
// END
