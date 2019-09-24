import java.util.InputMismatchException;
import java.util.Scanner;
public class CinemaApp{
    public static void main(String[] args){
        // ����� ������������ ������� � ��������
        // -1 -> ����� ������
        // 0  -> ����� ��������
        // 1  -> ����� ���������������
        int[][] room = {
                {-1, 0, 0, 0, 0, 0, 0,-1 },
                { 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        // ���� ��� ������� ���� � ����
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
            System.out.println("|�� �������-----------------------------|");
            PrintBiArr(room);

            System.out.print("������ ���:");
            try {
                col = in.nextInt();
                if (col<0 || col>room.length-1){
                    System.out.println("������:�������� ������ ��� ���������� �����");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("������: �� ���������� ��������");
                in.next();
                continue;
            }
            System.out.print("������ �����:");
            try {
                row = in.nextInt();
                if (row<0 || row >room[col].length-1){
                    System.out.println("������:�������� ������ ��� ���������� ����");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("������: �� ���������� ��������");
                in.next();
                continue;
            }

            if (room[col][row]==0) {
                System.out.println("���� �� �����: "+price[col]);
                System.out.println("����� �����?(Y)");
                bExit =in.next().toUpperCase();
                if(!bExit.equals("Y"))break;

                 room[col][row] =1;
                System.out.println("|����� �������-------------------------|");
                 PrintBiArr(room);
            }

            System.out.print("���������?(Y) ");
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

        System.out.println("��������� ����:"+counter);

    }
}