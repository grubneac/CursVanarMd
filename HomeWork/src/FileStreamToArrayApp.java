import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStreamToArrayApp{
    public static Car[] cars;
    public static void main(String[] args){
        // 1) �������� ���������� ���� ������� ���������� ��� "cars.txt"
        //    � ������� �����.
        // 2) �������� � ���� ����. ���������:
        //    > BMW 1999 1000000 1000
        //    > BMW 2011 10000 20000
        //    > Mercedes 2002 20000 10000

        //   ���: ������ ��� ������ ���������

        // 3) ���� �������� ����� ��� ������ �� ������� �����
        loadFileToArray(args[0]);
        printArrayData();
    }

    /**
     ����� ������� ������ �� �����
     �� �������� @param filename - ���� �� ����� ��� ����� �������
     ���� ������:
     1) ������� ���� ����� Scanner() + File()
     2) ����� ����� while() + Scanner.hasNext() �������� ���
     ����� ����� �������� � ������ "cars" ��� ������
     * ��� ��� ������� ��� � ���������� ;) ? javadoc?
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
        //�������� � ������
        cars =carArrayList.toArray(new Car[carArrayList.size()]);
    }
    /**
     ����� ������� ������� ������ ������ �� ������� "cars"
     ���� ������:
     1) ���� for (each) �� ������� "cars"
     2) ��������� Car.toString() ����������� ���������
     �� ������ � �����
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

    // �������� ����������� � toString()
    // ����� - ������������ ������ (����� ������������� ��� ��� �����)

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