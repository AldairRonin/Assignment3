package utils;

public class ReflectionUtils {

    public static void printClassInfo(Object obj) {

        Class<?> clazz = obj.getClass();

        System.out.println("Class name: " + clazz.getName());

        System.out.println("Fields:");
        for (var field : clazz.getDeclaredFields()) {
            System.out.println(" - " + field.getName());
        }

        System.out.println("Methods:");
        for (var method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method.getName());
        }
    }
}
