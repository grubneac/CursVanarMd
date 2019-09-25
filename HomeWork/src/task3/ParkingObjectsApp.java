package task3;

public class ParkingObjectsApp{
    public static void main(String[] args){
        // ��� ������ - ��������� ��� ������� Parking, Car
        // � ����� ��� ����� ������ ��� �����
        Parking lux_parking = new Parking(); // ������ ��� ����� ������ ��������
        // ������������ 2 ����
        Car my_car = new Car("BMW 7");
        Car friend_car = new Car("BMW 5");
        lux_parking.parkCar(my_car,"1A");
        lux_parking.parkCar(friend_car,"1C");

        // ������� ������������ �� ������� ����� - ��������� �� ������
        Car wrong_car = new Car("FIAT");
        lux_parking.parkCar(wrong_car,"1A"); // "Place "1A" Taken!" - ��� ����� ���������

        // �������� �����
        lux_parking.printMap();
        // ��� �������� ���������
        // -------------------
        // | BMW 7  | 0      |
        // -------------------
        // -------------------
        // | 0      | 0      |
        // -------------------
        // -------------------
        // | BMW 5  | 0      |
        // -------------------
    }
}

//  ���������� ���� ��� ����� "Parking" ��� ����� �������� �������������
//  �����-�� �������� � 6-� ������� ������������� ����� �������
// -----------
// | 1A | 2A |
// -----------
// | 1B | 2B |
// -----------
// | 1C | 2C |
// -----------

class Parking{
    private byte free_places; // ���-�� ��������� ���� �� ��������
    private Car place_1A;
    private Car place_1B;
    private Car place_1C;
    private Car place_2A;
    private Car place_2B;
    private Car place_2C;
    // �������� ����������� �����
    // ��� ����� �� ���������� ������������ ���-�� ��������� ���� � - 6

    public Parking() {
        free_places =6;
    }

    // �������� ����� "parkCar(Car c,String place)" ������� ���������� ����
    // �� ��������� ����� - ���? ������ ���������� ������ ���� "Car" ������ ���� ��������
    // ���� �������� "place_XX" ��� �������� ��������� ����� �������� "place"
    // �������� "parking.parkCar(c1,"1B")" ������ ������� ��������� ���� ��� ����� ��������
    // (����� ������� ��� ���� �������� ����� - null ����� ����� ��������)
    void parkCar(Car c,String place){
        switch (place){
            case "1A":
                if (this.place_1A == null)
                    this.place_1A = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
            case "1B":
                if (this.place_1B == null)
                    this.place_1B = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
            case "1C":
                if (this.place_1C == null)
                    this.place_1C = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
            case "2A":
                if (this.place_2A == null)
                    this.place_2A = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
            case "2B":
                if (this.place_2B == null)
                    this.place_2B = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
            case "2C":
                if (this.place_2C == null)
                    this.place_2C = c;
                else System.out.println("Place \""+place+"\" Taken!");
                break;
        }
    }

    // �������� ����� ������� ������� ���-�� ��������� ���� �� ��������

    public byte getFree_places() {
        return free_places;
    }

    // �������� ����� printMap() ������� ������� � �������
    // ����� ���� ����� �������, ��� ����� - ������, 0 - �������� (null)
    // -------------------
    // | BMW    | 0      |
    // -------------------
    // -------------------
    // | 0      | 0      |
    // -------------------
    // -------------------
    // | 0      |  Fiat  |
    // -------------------

    // * �������� ��� ������ ����� � ������ ����� ������������ car.print()
        void printMap(){
            System.out.println("-------------------");
            System.out.print("| ");
            if (this.place_1A !=null)this.place_1A.print();
            else System.out.print("   0  ");
            System.out.print(" | ");
            if (this.place_2A !=null)this.place_2A.print();
            else System.out.print("   0  ");
            System.out.println(" |");
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.print("| ");
            if (this.place_1B !=null)this.place_1B.print();
            else System.out.print("   0  ");
            System.out.print(" | ");
            if (this.place_2B !=null)this.place_2B.print();
            else System.out.print("   0  ");
            System.out.println(" |");
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.print("| ");
            if (this.place_1C !=null)this.place_1C.print();
            else System.out.print("   0  ");
            System.out.print(" | ");
            if (this.place_2C !=null)this.place_2C.print();
            else System.out.print("   0  ");
            System.out.println(" |");
            System.out.println("-------------------");
        }
}

// ����� ������ ����������
class Car{
    private String model;
    // �������� �����������

    public Car(String model) {
        this.model = model;
    }

    // ������ / ������

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
// � print() ������� ������� ������ ���� � �������
    void print(){
        System.out.printf("%6s",this.getModel());
    }
}
