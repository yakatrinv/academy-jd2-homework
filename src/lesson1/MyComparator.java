package lesson1;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] string1 = o1.split("\t");
        String[] string2 = o2.split("\t");

        for (int i = 0; i < string1.length; i++) {

            boolean isNumber1 = isNumber(string1[i]);
            boolean isNumber2 = isNumber(string2[i]);

            if (isNumber1 && isNumber2) {
                if (Integer.parseInt(string1[i]) != Integer.parseInt(string2[i])) {
                    return Integer.parseInt(string1[i]) - Integer.parseInt(string2[i]);
                }
            } else if (!isNumber1 && !isNumber2) {
                if (!string1[i].equals(string2[i])) {
                    return string1[i].compareTo(string2[i]);
                }
            } else {
                return (!isNumber1) ? (-1) : 1;
            }
        }
        return 1;
    }

    public static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

}



