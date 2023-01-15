package lesson1;
/*
Создайте java-приложение, которое будет считывать данные из источника (файл in.txt) и выполнять их сортировку. Данные имеют табличную структуру. Строки разделены переносом строки. Столбцы – знаком табуляции.
Данные необходимо отсортировать и вывести в файл out.txt.
Сортировка производится сначала по первой колонке строк, потом по второй (если строки или числа в первой колонке совпадают) и т.д.. Данные относящиеся к одной строке в гриде должны быть также в одной строке.
При этом: любое число в колонке выше любого не числа, числа отсортированы по возрастанию, строки в лексикографическом порядке
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static final String PATH_IN = ".\\resources\\in.txt";
    public static final String PATH_OUT = ".\\resources\\out.txt";

    public static void main(String[] args) throws IOException {
        //заполнение пустого файла для тестирования
        addDataInFile();

        List<String> list = readFile();
        System.out.println("---------------------------------");
        sortList(list);
        printList(list);
        writeToFile(list);
    }

    public static void addDataInFile() {
        File file = new File(PATH_IN);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File not read");
                return;
            }
        }

        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write("Ivanov P" + "\t" + 15 + "\t" + 155 + "\n");
            fileWriter.write("Ivanov P" + "\t" + 15 + "\t" + 135 + "\n");
            fileWriter.write("Ivanov P" + "\t" + 12 + "\t" + 121 + "\n");
            fileWriter.write("Ivanov Ivan" + "\t" + 15 + "\t" + 131 + "\n");
            fileWriter.write("Ivanov S" + "\t" + 15 + "\t" + 140 + "\n");
            fileWriter.write("Ivanov Petr" + "\t" + 16 + "\t" + 141 + "\n");
            fileWriter.write("Sidorov" + "\t" + 13 + "\t" + 128 + "\n");
            fileWriter.write("Petrov" + "\t" + 14 + "\t" + 125);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(List<String> list) throws IOException {
        File fileOut = new File(PATH_OUT);

        if (!fileOut.exists()) {
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                System.out.println("File not read");
                return;
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileOut)) {
            for (String tmp : list) {
                fileWriter.write(tmp + "\n");
            }
        }
    }

    private static void sortList(List<String> list) {
        list.sort(new MyComparator());
    }

    private static void printList(List<String> list) {
        list.forEach(System.out::println);
    }

    private static List<String> readFile() throws IOException {
        List<String> list = new ArrayList<>();

        File fileIn = new File(PATH_IN);

        if (!fileIn.exists()) {
            try {
                fileIn.createNewFile();
            } catch (IOException e) {
                System.out.println("File not read");
                return list;
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn))) {
            while (bufferedReader.ready()) {
                String tmp = bufferedReader.readLine();
                System.out.println(tmp);
                list.add(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return list;
    }
}
