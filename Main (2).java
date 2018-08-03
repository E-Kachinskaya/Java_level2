package Lesson_3;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Banana",
                "Cherry",
                "Orange",
                "Kiwi",
                "Banana",
                "Passionfruit",
                "Banana",
                "Kiwi");
        System.out.println(words);
        HashSet<String> unikWords = new HashSet<>(words);
        System.out.println(unikWords);
        repeat(words);
    }

    public static void repeat(List<String> list) {
        int countBan = 0;
        int countKiw = 0;
        int countPas = 0;
        int countChe = 0;
        int countOra = 0;
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            switch (list.get(i)) {
                case "Banana":
                    countBan++;
                    break;
                case "Kiwi":
                    countKiw++;
                    break;
                case "Passionfruit":
                    countPas++;
                    break;
                case "Cherry":
                    countChe++;
                    break;
                case "Orange":
                    countOra++;
                    break;
            }
        }
        System.out.println("Количество раз встречающихся слов. Banan: " + countBan + ". Kiwi: " + countKiw +
                ". Passionfruit: " + countPas + ". Cherry " + countChe + ". Orange: " + countOra);
    }

}
