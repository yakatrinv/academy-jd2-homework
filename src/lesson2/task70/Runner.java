package lesson2.task70;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Man newMan = new Man("Name man",20,70);

        print(newMan);
    }

    private static void print(Man newMan) {
        Class myClass = newMan.getClass();
        Field[] fields = myClass.getDeclaredFields();
        System.out.println("Переменные");
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("Методы");
        Method[] methods = myClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }


}
