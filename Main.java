package Lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str = "1 3 2 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        try {
            System.out.println("Результат вычисления равен " + reform(str));
        } catch (MyNewException e) {
            System.out.println("Размер массива превышает 4х4");
        } catch (NumberFormatException e) {
            System.out.println("Строка содержит символ или слово");
        }

    }


    public static int reform(String string) throws MyNewException, NumberFormatException {
        int sum = 0;
        String[] strings = string.split("\n");
        int size = strings.length;
        String[][] strings1 = new String[size][size];
        for (int i = 0; i < strings.length; i++) {
            if (i >=4){
                throw new MyNewException();
            }
            strings1[i] =(strings[i].split(" "));

        }



        int[][] numberArr = new int[size][size];
        for (int i = 0; i < strings1.length; i++) {
            for (int j = 0; j < strings1[i].length; j++) {
                numberArr[i][j] = Integer.parseInt(strings1[i][j]);

                System.out.print(numberArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < numberArr.length; i++) {
            for (int j = 0; j < numberArr[i].length; j++) {
                sum += numberArr[i][j];
            }
        }
        return sum / 2;
    }

}
