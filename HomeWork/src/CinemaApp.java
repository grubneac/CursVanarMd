import java.util.InputMismatchException;
import java.util.Scanner;
public class CinemaApp{
    public static void main(String[] args){
        // карта расположения сидений в кинозале
        // -1 -> место занято
        // 0  -> место свободно
        // 1  -> место зарезервировано
        int[][] room = {
                {-1, 0, 0, 0, 0, 0, 0,-1 },
                { 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        // цены для каждого ряда в зале
        int[]   price = {
                100,
                100,
                75,
                75,
                50
        };

        String bExit;
        Scanner in = new Scanner(System.in);
        int row,col;

        do{
            System.out.println("|ДО Покупки-----------------------------|");
            PrintBiArr(room);

            System.out.print("Ведите ряд:");
            try {
                col = in.nextInt();
                if (col<0 || col>room.length-1){
                    System.out.println("ОШИБКА:Значение больше чем количество рядов");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("ОШИБКА: Не корректное значение");
                in.next();
                continue;
            }
            System.out.print("Ведите место:");
            try {
                row = in.nextInt();
                if (row<0 || row >room[col].length-1){
                    System.out.println("ОШИБКА:Значение больше чем количество мест");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("ОШИБКА: Не корректное значение");
                in.next();
                continue;
            }

            if (room[col][row]==0) {
                System.out.println("Цена за билет: "+price[col]);
                System.out.println("Будем брать?(Y)");
                bExit =in.next().toUpperCase();
                if(!bExit.equals("Y"))break;

                 room[col][row] =1;
                System.out.println("|ПОСЛЕ Покупки-------------------------|");
                 PrintBiArr(room);
            }

            System.out.print("Продолжим?(Y) ");
            bExit = in.next().toUpperCase();
            if(!bExit.equals("Y"))break;
        }while (true);
    }

    static void PrintBiArr(int[][] biArr ){
        int counter =0;
        for (int[] colls : biArr ){
            for (int plase : colls){
                System.out.print("| "+ String.format( "%2d",plase)+" ");
                if(plase ==0)counter++;
            }
            System.out.println("|");
        }

        System.out.println("Свободных мест:"+counter);

    }
}