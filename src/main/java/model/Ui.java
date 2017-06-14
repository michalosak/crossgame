package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Ui {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String strNormalSize = "\033[0;0m";
    public static final String strBoldSize = "\033[0;1m";

    public void clear() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printHeader(String text) {

        Integer howMuch = text.length();
        System.out.print(ANSI_RED);
        for (Integer i=0; i < howMuch; i++){
            System.out.print('-');
        }
        System.out.println(ANSI_RESET);
        System.out.println(strBoldSize + ANSI_RED + text + ANSI_RESET + strNormalSize);
        System.out.print(ANSI_RED);
        for (Integer i=0; i < howMuch; i++){
            System.out.print('-');
        }
        System.out.println(ANSI_RESET);
    }

    public void printBoard(Cell[][] table) {

        for (int x = 0; x <= 2; x++ ) {
            for (int  y = 0; y <= 2; y++){

                if (table[x][y].getContent().equals(Seed.EMPTY)) System.out.print(" ");
                if (table[x][y].getContent().equals(Seed.CROSS)) System.out.print("X");
                if (table[x][y].getContent().equals(Seed.NOUGHT)) System.out.print("O");

                if (y < table.length - 1) System.out.print(" | ");
            }

            System.out.println();
            if (x < table.length - 1) System.out.println("---------");
        }


    }

    public String userInputString(String input) {

        Scanner user_input = new Scanner(System.in);
        System.out.print(input);
        return user_input.nextLine();
    }

    public void printWarning(String text) {

        System.out.print(ANSI_YELLOW);
        System.out.println("WARNING: " + text);
        System.out.println(ANSI_RESET);

    }

    public Integer selectFromList(Integer maxInput, String text) {

        Scanner one = new Scanner(System.in);
        String option;

        do {
            try
            {
                System.out.print(text);
                option = one.next();
                Integer intOption = Integer.parseInt(option);
                if (intOption<=maxInput && 1<=intOption){
                    return intOption-1;
                } else {
                    printWarning("Please write correct value (1-" + maxInput + ")");
                }
            }
            catch (Exception e)
            {
                printWarning("Please write correct value (1-" + maxInput + ")");

            }
        } while (true);
    }

    public void printInformation(String text) {

        System.out.print(ANSI_GREEN);
        System.out.println(text);
        System.out.println(ANSI_RESET);
    }
}
