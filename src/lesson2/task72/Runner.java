package lesson2.task72;

import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) {
        Method[] methods = Runner.class.getDeclaredMethods();
        for (Method tmp:methods) {
            if (tmp.isAnnotationPresent(academyinfo.class)) {
                System.out.println(tmp);
            }
        }
    }

    @academyinfo(year = 2022)
    public void methodWithAnnotation(){
    }
    public static void methodWithoutAnnotation(){

    }
}
