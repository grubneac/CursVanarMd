import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStreamToArrayApp{
    public static Car[] cars;
    public static void main(String[] args){
        // 1) Создайте редактором файл который называется так "cars.txt"
        //    в текущую папку.
        // 2) Запишите в файл след. структуру:
        //    > BMW 1999 1000000 1000
        //    > BMW 2011 10000 20000
        //    > Mercedes 2002 20000 10000

        //   это: модель год пробег стоимость

        // 3) Ниже приведен метод для чтения из данного файла
        loadFileToArray(args[0]);
        printArrayData();
    }

    /**
     метод который читает из файла
     он получает @param filename - путь до файла что нужно открыть
     суть метода:
     1) открыть файл через Scanner() + File()
     2) путем цикла while() + Scanner.hasNext() сделайте так
     чтобы метод загрузил в массив "cars" все данные
     * что это коммент тут с раскраской ;) ? javadoc?
     */
    public static void loadFileToArray( String filename ) {
        File file = new File(filename);
        String line ;
        String[] obj;
        ArrayList<Car> carArrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                line = sc.nextLine();
                obj =line.split(" ");
                carArrayList.add(new Car(obj[0],
                                        Integer.parseInt(obj[1]),
                                        Integer.parseInt(obj[2]),
                                        Integer.parseInt(obj[3])));
            }
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //загоняем в массив
        cars =carArrayList.toArray(new Car[carArrayList.size()]);
    }
    /**
     метод который выведит список данных из массива "cars"
     суть метода:
     1) цикл for (each) по массиву "cars"
     2) используя Car.toString() преобразует результат
     на экране в такой
     > 1. CAR: BMW 1999 1000000km  1000USD
     > 2. CAR: BMW 2011 10000km   20000USD
     > 3. ....
     */
    public static void printArrayData() {
        int counter =0;
        for (Car curCar : cars){
            System.out.println(++counter +". "+ curCar);
        }
    }
}

class Car{
    String model;
    Integer year;
    Integer km;
    Integer price;

    // добавить конструктор и toString()
    // БОНУС - валидировать данные (вдруг отрицательный год или прайс)

    public Car(String model, Integer year, Integer km, Integer price) {
        this.model = model;
        this.year = year;
        this.km = km;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CAR: " +
                String.format("%8s", model) + " " +
                String.format("%4s", year) +" " +
                String.format("%8s", km) +"km "+
                String.format("%6s",price) + "USD"
                ;
    }
}