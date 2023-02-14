package org.example;

import java.util.Scanner;
class Game{
        public static String[][] a = new String[3][3];
        int search;
        Scanner s = new Scanner(System.in);
        int player = 0;
    void player(){
        while (true) {
            //Player 1
            if(player != 9) {
                if (player % 2 == 0) {
                    System.out.println("Choose the place in Player 1 -> X:");
                    search = s.nextInt();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((a[i][j].equals(String.valueOf(search)))) {
                                if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                                    a[i][j] = "X";
                                    player++;
                                }
                                else {
                                    System.out.println("Please, Choose another place.");
                                }
                            }
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
                    for (int i = 0; i < 3; i++) {
                        //hor
                        if (a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][0])) {
                            System.out.println("Player 1 is Winner.");
                            System.exit(0);
                        }
                        //ver
                        else if (a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[0][i])) {
                            System.out.println("Player 1 is Winner.");
                            System.exit(0);
                        }
                        //left to right cross
                        else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2])) {
                            System.out.println("Player 1 is Winner.");
                            System.exit(0);
                            break;
                        } else if (a[0][2].equals(a[1][1]) && a[1][1].equals(a[2][0])) {
                            System.out.println("Player 1 is Winners.");
                            System.exit(0);
                            break;
                        }
                    }
                }
                //player 2
                else {
                    System.out.println("Choose the place in Player 2 -> O:");
                    search = s.nextInt();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((a[i][j].equals(String.valueOf(search)))) {
                                if (!a[i][j].equals("X") || !a[i][j].equals("O")) {
                                    a[i][j] = "O";
                                    player++;
                                }
                                else {
                                    System.out.println("Please, Choose another place.");
                                }
                            }
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
                }
            }
            else{
                System.out.println("The Match is Draw.");
                System.exit(0);
            }
            for(int i = 0; i<3; i++){
                //hor
                if(a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && a[i][2].equals(a[i][0])){
                    System.out.println("Player 2 is Winner.");
                    System.exit(0);
                }
                //ver
                else if(a[0][i].equals(a[1][i]) && a[1][i].equals(a[2][i]) && a[2][i].equals(a[0][i])){
                    System.out.println("Player 2 is Winner.");
                    System.exit(0);
                }
                //left to right cross
                else if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2])) {
                    System.out.println("Player 2 is Winner.");
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
        t.player();
    }
}