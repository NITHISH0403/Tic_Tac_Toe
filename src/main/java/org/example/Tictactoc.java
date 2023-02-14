package org.example;

import java.util.Scanner;
import java.util.logging.*;
class Game{
        static final String[][] a = new String[3][3];
        int search;
        Scanner s = new Scanner(System.in);
        Logger l = Logger.getLogger("NITHISH");
        int player = 0;
        String player1 = "Player 1 is Winner.";
        String player2 = "Player 1 is Winner.";
        String draw = "The Match is Draw.";
    void players(){
        while (true) {
            //Player 1
            if(player != 9) {
                if (player % 2 == 0) {
                    l.info("Choose the place in Player 1 -> X:");
                    search = s.nextInt();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((a[i][j].equals(String.valueOf(search)))) {
                                if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                                    a[i][j] = "X";
                                    player++;
                                }
                                else {
                                    l.info("Please, Choose another place.");
                                }
                            }
                        }
                    }
                    System.out.println("+-------+-------+-------+");
                    for (int i = 0; i < 3; i++) {
                        l.info("|");
                        for (int j = 0; j < 3; j++) {
                            String n = String.valueOf(a[i][j]);
                            l.log(Level.INFO,()->"\t" + n + "\t" + "|");
                        }
                        l.info("\n+-------+-------+-------+");
                    }
                    for (int i = 0; i < 3; i++) {
                        //hor
                        if (a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][0])) {
                            l.info(player1);
                            System.exit(0);
                        }
                        //ver
                        else if (a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[0][i])) {
                            l.info(player1);
                            System.exit(0);
                        }
                        //left to right cross
                        else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2])) {
                            l.info(player1);
                            System.exit(0);
                            break;
                        } else if (a[0][2].equals(a[1][1]) && a[1][1].equals(a[2][0])) {
                            l.info(player1);
                            System.exit(0);
                            break;
                        }
                    }
                }
                //player 2
                else {
                    l.info("Choose the place in Player 2 -> O:");
                    search = s.nextInt();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((a[i][j].equals(String.valueOf(search)))) {
                                if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                                    a[i][j] = "O";
                                    player++;
                                }
                                else {
                                    l.info("Please, Choose another place.");
                                }
                            }
                        }
                    }
                    l.info("+-------+-------+-------+");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("|");
                        for (int j = 0; j < 3; j++) {
                            String n = String.valueOf(a[i][j]);
                            l.log(Level.INFO,()->"\t" + n + "\t" + "|");
                        }
                        l.info("\n+-------+-------+-------+");
                    }
                }
            }
            else{
                l.info(draw);
                System.exit(0);
            }
            for(int i = 0; i<3; i++){
                //hor
                if(a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][0])){
                    l.info(player2);
                    System.exit(0);
                }
                //ver
                else if(a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[0][i])){
                    l.info(player2);
                    System.exit(0);
                }
                //left to right cross
                else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2])) {
                    l.info(player2);
                    System.exit(0);
                    break;
                }

            }
        }
    }
}
public class Tictactoc extends Game{
    public static void main(String[] args) {
        int value = 1;
        Tictactoc t = new Tictactoc();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = String.valueOf(value++);
            }
        }
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print("\t" + a[i][j] + "\t" + "|");
            }
            System.out.println("\n+-------+-------+-------+");
        }
        t.players();
    }
}
