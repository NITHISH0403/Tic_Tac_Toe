package org.example;

import java.util.Scanner;
import java.util.logging.*;
class Game{
    int search;
    static Scanner s = new Scanner(System.in);
    static Logger l = Logger.getLogger("NITHISH");
    int play = 0;
    String player1 = "Player 1 is Winner.";
    String player2 = "Player 2 is Winner.";
    String draw = "The Match is Draw.";

    //find the Player do play
    void players(String[][] a){
        while (true) {
            //Player 1
            if(play != 16) {
                if (play % 2 == 0) {
                    l.info("Choose the place in Player 1 -> X:");
                    search = s.nextInt();

                    player(a, "X");

                    display(a);

                    condition(a, player1);
                }
                //player 2
                else {
                    l.info("Choose the place in Player 2 -> O:");
                    search = s.nextInt();

                    player(a, "O");

                    display(a);

                    condition(a, player2);
                }
            }
            else{
                System.out.println(draw);
                System.exit(0);
            }

        }
    }

    //player choose is replace our Symbol
    void player(String[][] a, String option){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((a[i][j].equals(String.valueOf(search)))) {
                    if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                        a[i][j] = option;
                        play++;
                    }
                    else {
                        l.info("Please, Choose another place.");
                    }
                }
            }
        }
    }
    //check the condition
    void condition(String[][] a, String x)
    {
        for(int i = 0; i<4; i++){
            //hor
            if(a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][3]) && a[i][3].equals(a[i][0])){
                winner(x);
                System.exit(0);

            }
            //ver
            else if(a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[3][i]) && a[3][i].equals(a[0][i])){
                winner(x);
                System.exit(0);
            }
            //left to right cross
            else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2]) && a[2][2].equals(a[3][3])) {
                winner(x);
                System.exit(0);
            }
            //right to left cross
            else if (a[0][3].equals(a[1][2]) && a[1][2].equals(a[2][1]) && a[2][1].equals(a[3][0])) {
                winner(x);
                System.exit(0);
            }
        }
    }
    //announce the final winner
    void winner(String x){
        l.log(Level.INFO,()->x);
    }
    //display the current board
    void display(String[][] a){
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                String n = String.valueOf(a[i][j]);
                System.out.print("\t" + n + "\t" + "|");
            }
            System.out.println("\n");
        }
    }
}
public class Tictactoc extends Game{
    public static void main(String[] args) {
        String[][] a = new String[10][10];
        int value = 1;
        Tictactoc t = new Tictactoc();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = String.valueOf(value++);
            }
        }
        t.display(a);
        t.players(a);
    }
}
