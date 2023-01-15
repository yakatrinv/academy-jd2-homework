package lesson2.task71;

import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloWorld newHelloWorld = new HelloWorld();

        Class o = newHelloWorld.getClass();
        o.getMethod("print").invoke(newHelloWorld);
    }
}
