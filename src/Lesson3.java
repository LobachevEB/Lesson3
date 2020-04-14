import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nextGame = 0;
        do {
            guessDigitGame(9,3);
            System.out.println("");
            System.out.println("1 - повторить игру, 0 - закончить");
            nextGame = scn.nextInt();
        }while (nextGame != 0);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        do {
            guessWordGame(words);
            System.out.println("1 - повторить игру, 0 - закончить");
            nextGame = scn.nextInt();
        }while (nextGame != 0);

    }

    public static void guessDigitGame(int bound,int takes){
        Random rnd = new Random();
        int misteryDigit = rnd.nextInt(bound);
        Scanner scn = new Scanner(System.in);
        System.out.println("Угадайте число от 0 до " + bound);
        for (int i = 0; i < takes; i++){
            int t = scn.nextInt();
            if(t == misteryDigit){
                System.out.println("Вы угадали!");
                break;
            }
            else if(t < misteryDigit)
                System.out.println("Загаданное число больше указанного");
            else
                System.out.println("Загаданное меньше указанного");
        }

    }

    public static void guessWordGame(String[] words) {
        StringBuilder bld = new StringBuilder();
        bld.append("###############");
        Random rnd = new Random();
        int misteryWordInd = rnd.nextInt(words.length - 1);
        String misteryWord = words[misteryWordInd];
        System.out.println("Угадайте слово");
        Scanner scn = new Scanner(System.in);
        while (true){
            String attempt = scn.nextLine();
            if(attempt.equals(misteryWord)){
                System.out.println("Вы угадали!");
                break;
            }
            int len = Math.min(misteryWord.length(),attempt.length());
            for (int i = 0; i < len; i++){
                char c1 = attempt.charAt(i);
                char c2 = misteryWord.charAt(i);
                if(c1 == c2)
                    bld.setCharAt(i,c1);
            }
            System.out.println("Подсказка: " + bld.toString());
            System.out.println("Попробуйте еще раз");
        }

    }


}

