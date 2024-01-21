package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static void main(String[] args) {
        Address address = new Address("Russia", "Uf", null, null, "63");
        System.out.println(advancedValidate(address));
    }

    public static List<String> validate(Object obj) {
        var result = new ArrayList<String>();
        var objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        var result = new HashMap<String, List<String>>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            var list = new ArrayList<String>();
            field.setAccessible(true);
            try {
                var annotationMinLength = field.getAnnotation(MinLength.class);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    list.add("can not be null");
                    result.put(field.getName(), list);
                }
                if (field.isAnnotationPresent(MinLength.class) && annotationMinLength != null) {
                    int minLength = annotationMinLength.minLength();
                    if (field.get(address).toString().length() < minLength) {
                        list.add(String.format("length less than %d", minLength));
                        result.put(field.getName(), list);
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
// END
