package Assignment3;

import java.util.Scanner;

public class UserInput {

    private static Scanner readin = new Scanner(System.in);

    public static int readInt(String question){
        System.out.println(question);
        int result = readin.nextInt();
        readin.nextLine();
        return result;
    }

    public static String readString(String question){
        System.out.println(question);
        String result = readin.nextLine();
        return result;
    }

    public static double readDouble(String question){
        System.out.println(question);
        double result = readin.nextDouble();
        readin.nextLine();
        return result;
    }
}