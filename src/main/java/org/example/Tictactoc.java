package org.example;

import java.util.Scanner;
class Game{
    int search;
    Scanner s = new Scanner(System.in);
    int player = 0;
    String player1 = "Player 1 is Winner.";
    String player2 = "Player 2 is Winner.";
    String draw = "The Match is Draw.";
    static String design = "+-------+-------+-------+";
    void players(String[][] a){
        while (true) {
            //Player 1
            if(player != 9) {
                if (player % 2 == 0) {
                    System.out.println("Choose the place in Player 1 -> X:");
                    search = s.nextInt();

                    player(a, "X");

                    display(a);
                    
                    win(a, player1);
                }
                //player 2
                else {
                    System.out.println("Choose the place in Player 2 -> O:");
                    search = s.nextInt();

                    player(a, "O");
                    
                    display(a);
                    
                    win(a, player2);
                }
            }
            else{
                System.out.println(draw);
                System.exit(0);
            }

        }
    }
    void player(String[][] a, String option){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((a[i][j].equals(String.valueOf(search)))) {
                    if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                        a[i][j] = option;
                        player++;
                    }
                    else {
                        System.out.println("Please, Choose another place.");
                    }
                }
            }
        }
    }
    void display(String[][] a){
        System.out.println(design);
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                String n = String.valueOf(a[i][j]);
                System.out.print("\t" + n + "\t" + "|");
            }
            System.out.println("\n" + design);
        }
    }
    void win(String[][] a,String player2)
    {
        for(int i = 0; i<3; i++){
            //hor
            if(a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][0])){
                System.out.println(player2);
                System.exit(0);

            }
            //ver
            else if(a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[0][i])){
                System.out.println(player2);
                System.exit(0);
            }
            //left to right cross
            else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2])) {
                System.out.println(player2);
                System.exit(0);
                break;
            }
            //right to left cross
            else if (a[0][2].equals(a[1][1]) && a[1][1].equals(a[2][0])) {
                System.out.println(player2);
                System.exit(0);
                break;
            }
        }
    }
}
public class Tictactoc extends Game{
    public static void main(String[] args) {
        String[][] a = new String[3][3];
        int value = 1;
        Tictactoc t = new Tictactoc();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = String.valueOf(value++);
            }
        }
        System.out.println(design);
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                String n = String.valueOf(a[i][j]);
                System.out.print("\t" + n + "\t" + "|");
            }
            System.out.println("\n" + design);
        }
        t.players(a);
    }
}
