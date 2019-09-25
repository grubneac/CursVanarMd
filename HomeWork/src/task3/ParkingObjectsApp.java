package task3;

public class ParkingObjectsApp{
    public static void main(String[] args){
        // для начала - доделайте код классов Parking, Car
        // а потом код этого метода так чтобы
        Parking lux_parking = new Parking(); // создан был новый обьект парковки
        // припарковать 2 авто
        Car my_car = new Car("BMW 7");
        Car friend_car = new Car("BMW 5");
        lux_parking.parkCar(my_car,"1A");
        lux_parking.parkCar(friend_car,"1C");

        // попытка припарковать на занятое место - сообщение об ошибке
        Car wrong_car = new Car("FIAT");
        lux_parking.parkCar(wrong_car,"1A"); // "Place "1A" Taken!" - так должо выводится

        // печатаем карту
        lux_parking.printMap();
        // так выглядит результат
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

//  Представим себе что класс "Parking" это обькь ктоторый соответствует
//  какой-то парковке с 6-ю местами расположеными таким образом
// -----------
// | 1A | 2A |
// -----------
// | 1B | 2B |
// -----------
// | 1C | 2C |
// -----------

class Parking{
    private byte free_places; // кол-во свободных мест на парковке
    private Car place_1A;
    private Car place_1B;
    private Car place_1C;
    private Car place_2A;
    private Car place_2B;
    private Car place_2C;
    // добавьте конструктор класс
    // так чтобы он изначально устанавливал кол-во свободных мест в - 6

    public Parking() {
        free_places =6;
    }

    // добавьте метод "parkCar(Car c,String place)" который припаркует авто
    // на указанное место - как? просто переданный обьект типа "Car" должен быть назначен
    // тому свойству "place_XX" имя которого переданно через аргумент "place"
    // например "parking.parkCar(c1,"1B")" должен сначало проверить если это место свободно
    // (будем считать что если свойство равно - null тогда место свободно)
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

    // добавьте метод который выводит кол-во свободных мест на парковке

    public byte getFree_places() {
        return free_places;
    }

    // добавить метод printMap() который выводит в консоль
    // карту мест таким макаром, где Марка - занято, 0 - свободно (null)
    // -------------------
    // | BMW    | 0      |
    // -------------------
    // -------------------
    // | 0      | 0      |
    // -------------------
    // -------------------
    // | 0      |  Fiat  |
    // -------------------

    // * ВНИМАНИЕ для вывода марки в нужном месте использовать car.print()
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

// класс одного автомобиля
class Car{
    private String model;
    // добавить конструктор

    public Car(String model) {
        this.model = model;
    }

    // сеттер / геттер

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
// и print() который выводит модель авто в консоль
    void print(){
        System.out.printf("%6s",this.getModel());
    }
}
