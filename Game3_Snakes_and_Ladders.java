import java.util.Scanner;

public class Game3_Snakes_and_Ladders {
    public static void board() {
        Scanner sc = new Scanner(System.in);
        char retry = 'y';
        System.out.println("Enter \'Start\' to start the game:");
        do {
            String start = sc.nextLine();
            System.out.println("The game will start in :");
            for (short x = 5; x >= 1; x--) {
                System.out.println(x);
                for (long i = -9999; i <= 99999999; i++)
                    ;
            }
            System.out.println("\f---------------------------------");
            System.out.println("Welcome to Java Snakes & Ladders!");
            System.out.println("---------------------------------\n");
            System.out.println("Rules:");
            System.out.println("--> This is similar to the Snakes & Ladders game played by many people.");
            System.out.println("--> This is a four-player game.");
            System.out.println("--> There will be a 10x10 board containing some snakes and ladders.");
            System.out.println("--> The players will take turns to roll a dice.");
            System.out.println("--> The player will move ahead according to the number rolled.");
            System.out.println("--> If a player lands on a ladder, he will be able to climb it and go ahead!!");
            System.out.println("--> But if a player lands on a snake, he will have go back!!");
            System.out.println("--> The game will go on until a player reaches 100.\n");
            System.out.println("Enter Player 1's name:");
            String player1 = sc.nextLine();
            System.out.println("Enter Player 2's name:");
            String player2 = sc.nextLine();
            System.out.println("Enter Player 3's name:");
            String player3 = sc.nextLine();
            System.out.println("Enter Player 4's name:");
            String player4 = sc.nextLine();
            System.out.println("\f");
            int[] board = new int[100];
            String[] p1 = new String[100];
            String[] p2 = new String[100];
            String[] p3 = new String[100];
            String[] p4 = new String[100];
            String[] SnakesnLadders = new String[101];
            int order = 0;
            int t = 99;
            int s_and_l = 99;
            int p1_val = 0;
            int p2_val = 0;
            int p3_val = 0;
            int p4_val = 0;
            for (int fill = 99; fill >= 0; fill--) {
                SnakesnLadders[fill] = " ";
                if (fill == 99 - 1)
                    SnakesnLadders[fill] = "    Slip to 5";
                if (fill == 91 - 1)
                    SnakesnLadders[fill] = "   Slip to 75";
                if (fill == 87 - 1)
                    SnakesnLadders[fill] = "   Slip to 24";
                if (fill == 49 - 1)
                    SnakesnLadders[fill] = "   Slip to 23";
                if (fill == 17 - 1)
                    SnakesnLadders[fill] = "   Slip to 3";
                if (fill == 51 - 1)
                    SnakesnLadders[fill] = "   Slip to 47";
                if (fill == 37 - 1)
                    SnakesnLadders[fill] = "   Slip to 29";

                if (fill == 19 - 1)
                    SnakesnLadders[fill] = "  Climb to 80";
                if (fill == 4 - 1)
                    SnakesnLadders[fill] = "  Climb to 14";
                if (fill == 55 - 1)
                    SnakesnLadders[fill] = "  Climb to 63";
                if (fill == 33 - 1)
                    SnakesnLadders[fill] = "  Climb to 83";
                if (fill == 82 - 1)
                    SnakesnLadders[fill] = "  Climb to 97";
                if (fill == 16 - 1)
                    SnakesnLadders[fill] = "  Climb to 25";
                if (fill == 9 - 1)
                    SnakesnLadders[fill] = "  Climb to 39";

                p1[fill] = "";
                p2[fill] = "";
                p3[fill] = "";
                p4[fill] = "";
                board[fill] = fill + 1;
            }
            System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->" + player3
                    + "\t\t\u278D -->" + player4);
            for (int boardi = 1; boardi <= 10; boardi++) {
                if (boardi % 2 == 0) {
                    t = t - 9;
                    s_and_l = s_and_l - 9;
                    order = 1;
                } else if (boardi != 1) {
                    t = t - 11;
                    s_and_l = s_and_l - 11;
                    order = 0;
                }
                for (long boardj = 1; boardj <= 10; boardj++) {
                    System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                    if (order == 1)
                        t++;
                    else if (order == 0)
                        t--;
                }
                System.out.println("");
                for (long boardj = 1; boardj <= 10; boardj++) {
                    if (order == 0) {
                        if (boardj == 1) {
                            if (SnakesnLadders[s_and_l] != " ")
                                System.out.print(SnakesnLadders[s_and_l] + "\t|");
                            else if (SnakesnLadders[s_and_l - 1] != " ")
                                System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                            else
                                System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                        } else if (SnakesnLadders[s_and_l - 1] != " ")
                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                        else
                            System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                    }
                    if (order == 1) {
                        if (boardj == 1) {
                            if (SnakesnLadders[s_and_l] != " ")
                                System.out.print(SnakesnLadders[s_and_l] + "\t|");
                            else if (SnakesnLadders[s_and_l + 1] != " ")
                                System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                            else
                                System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                        } else if (SnakesnLadders[s_and_l + 1] != " ")
                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                        else
                            System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                    }
                    if (order == 1)
                        s_and_l++;
                    else if (order == 0)
                        s_and_l--;
                }
                System.out.println("");
                for (int dash = 1; dash <= 161; dash++)
                    System.out.print("-");
                System.out.println("");
            }
            for (long chance = 1; chance >= 0; chance++) {
                t = 99;
                s_and_l = 99;
                order = 0;
                if ((chance - 1) % 4 == 0) {
                    System.out.println("It is " + player1 + "\'s turn:");
                    System.out.println("Enter \'Roll\' to roll the dice:");
                    char pause = sc.next().charAt(0);
                    System.out.println("\f");
                    int dice = (int) (Math.random() * 6 + 1);
                    p1_val = p1_val + dice;
                    if (p1_val == 100) {
                        System.out.println(player1 + " won!!");
                        break;
                    } else if (p1_val > 100) {
                        System.out.println("You rolled more than you require to reach 100!!");
                        System.out.println("You can't move ahead!!");
                        p1_val = p1_val - dice;
                    }
                    for (int pfill = 0; pfill < 100; pfill++) {
                        p1[pfill] = " ";
                    }
                    p1[p1_val - 1] = " \u278A";
                    System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->" + player3
                            + "\t\t\u278D -->" + player4);
                    for (int boardi = 1; boardi <= 10; boardi++) {
                        if (boardi % 2 == 0) {
                            t = t - 9;
                            s_and_l = s_and_l - 9;
                            order = 1;
                        } else if (boardi != 1) {
                            t = t - 11;
                            s_and_l = s_and_l - 11;
                            order = 0;
                        }
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                            if (order == 1)
                                t++;
                            else if (order == 0)
                                t--;
                        }
                        System.out.println("");
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            if (order == 0) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l - 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l + 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1)
                                s_and_l++;
                            else if (order == 0)
                                s_and_l--;
                        }
                        System.out.println("");
                        for (int dash = 1; dash <= 161; dash++)
                            System.out.print("-");
                        System.out.println("");
                    }
                    System.out.println("Roll = " + dice);
                    if (SnakesnLadders[p1_val - 1] != " ") {
                        // Snakes
                        if (p1_val == 99) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 5!!");
                            p1_val = 5;
                        }
                        if (p1_val == 91) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 75!!");
                            p1_val = 75;
                        }
                        if (p1_val == 87) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 24!!");
                            p1_val = 24;
                        }
                        if (p1_val == 51) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 47!!");
                            p1_val = 47;
                        }
                        if (p1_val == 49) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 23!!");
                            p1_val = 23;
                        }
                        if (p1_val == 37) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 29!!");
                            p1_val = 29;
                        }
                        if (p1_val == 17) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 3!!");
                            p1_val = 3;
                        }
                        // Ladders
                        if (p1_val == 82) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 97!!");
                            p1_val = 97;
                        }
                        if (p1_val == 55) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 63!!");
                            p1_val = 63;
                        }
                        if (p1_val == 33) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 83!!");
                            p1_val = 83;
                        }
                        if (p1_val == 19) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 80!!");
                            p1_val = 80;
                        }
                        if (p1_val == 16) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 25!!");
                            p1_val = 25;
                        }
                        if (p1_val == 9) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 39!!");
                            p1_val = 39;
                        }
                        if (p1_val == 4) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 14!!");
                            p1_val = 14;
                        }
                        t = 99;
                        s_and_l = 99;
                        order = 0;
                        for (long i = -9999; i <= 99999999; i++)
                            ;
                        System.out.print("\f");
                        for (int pfill = 0; pfill < 100; pfill++) {
                            p1[pfill] = " ";
                        }
                        p1[p1_val - 1] = " \u278A";
                        System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->"
                                + player3 + "\t\t\u278D -->" + player4);
                        for (int boardi = 1; boardi <= 10; boardi++) {
                            if (boardi % 2 == 0) {
                                t = t - 9;
                                s_and_l = s_and_l - 9;
                                order = 1;
                            } else if (boardi != 1) {
                                t = t - 11;
                                s_and_l = s_and_l - 11;
                                order = 0;
                            }
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                                if (order == 1)
                                    t++;
                                else if (order == 0)
                                    t--;
                            }
                            System.out.println("");
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                if (order == 0) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l - 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l + 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1)
                                    s_and_l++;
                                else if (order == 0)
                                    s_and_l--;
                            }
                            System.out.println("");
                            for (int dash = 1; dash <= 161; dash++)
                                System.out.print("-");
                            System.out.println("");
                        }
                    }
                } else if (chance % 2 == 0 && chance % 4 != 0) {
                    System.out.println("It is " + player2 + "\'s turn:");
                    System.out.println("Enter \'Roll\' to roll the dice:");
                    char pause = sc.next().charAt(0);
                    System.out.println("\f");
                    int dice = (int) (Math.random() * 6 + 1);
                    p2_val = p2_val + dice;
                    if (p2_val == 100) {
                        System.out.println(player2 + " won!!");
                        break;
                    } else if (p2_val > 100) {
                        System.out.println("You rolled more than you require to reach 100!!");
                        System.out.println("You can't move ahead!!");
                        p2_val = p2_val - dice;
                    }
                    for (int pfill = 0; pfill < 100; pfill++) {
                        p2[pfill] = " ";
                    }
                    p2[p2_val - 1] = " \u278B";
                    System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->" + player3
                            + "\t\t\u278D -->" + player4);
                    for (int boardi = 1; boardi <= 10; boardi++) {
                        if (boardi % 2 == 0) {
                            t = t - 9;
                            s_and_l = s_and_l - 9;
                            order = 1;
                        } else if (boardi != 1) {
                            t = t - 11;
                            s_and_l = s_and_l - 11;
                            order = 0;
                        }
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                            if (order == 1)
                                t++;
                            else if (order == 0)
                                t--;
                        }
                        System.out.println("");
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            if (order == 0) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l - 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l + 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1)
                                s_and_l++;
                            else if (order == 0)
                                s_and_l--;
                        }
                        System.out.println("");
                        for (int dash = 1; dash <= 161; dash++)
                            System.out.print("-");
                        System.out.println("");
                    }
                    System.out.println("Roll = " + dice);
                    if (SnakesnLadders[p2_val - 1] != " ") {
                        // Snakes
                        if (p2_val == 99) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 5!!");
                            p2_val = 5;
                        }
                        if (p2_val == 91) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 75!!");
                            p2_val = 75;
                        }
                        if (p2_val == 87) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 24!!");
                            p2_val = 24;
                        }
                        if (p2_val == 51) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 47!!");
                            p2_val = 47;
                        }
                        if (p2_val == 49) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 23!!");
                            p2_val = 23;
                        }
                        if (p2_val == 37) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 29!!");
                            p2_val = 29;
                        }
                        if (p2_val == 17) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 3!!");
                            p2_val = 3;
                        }
                        // Ladders
                        if (p2_val == 82) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 97!!");
                            p2_val = 97;
                        }
                        if (p2_val == 55) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 63!!");
                            p2_val = 63;
                        }
                        if (p2_val == 33) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 83!!");
                            p2_val = 83;
                        }
                        if (p2_val == 19) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 80!!");
                            p2_val = 80;
                        }
                        if (p2_val == 16) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 25!!");
                            p2_val = 25;
                        }
                        if (p2_val == 9) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 39!!");
                            p2_val = 39;
                        }
                        if (p2_val == 4) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 14!!");
                            p2_val = 14;
                        }
                        t = 99;
                        s_and_l = 99;
                        order = 0;
                        for (long i = -9999; i <= 99999999; i++)
                            ;
                        System.out.print("\f");
                        for (int pfill = 0; pfill < 100; pfill++) {
                            p2[pfill] = " ";
                        }
                        p2[p2_val - 1] = " \u278B";
                        System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->"
                                + player3 + "\t\t\u278D -->" + player4);
                        for (int boardi = 1; boardi <= 10; boardi++) {
                            if (boardi % 2 == 0) {
                                t = t - 9;
                                s_and_l = s_and_l - 9;
                                order = 1;
                            } else if (boardi != 1) {
                                t = t - 11;
                                s_and_l = s_and_l - 11;
                                order = 0;
                            }
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                                if (order == 1)
                                    t++;
                                else if (order == 0)
                                    t--;
                            }
                            System.out.println("");
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                if (order == 0) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l - 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l + 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1)
                                    s_and_l++;
                                else if (order == 0)
                                    s_and_l--;
                            }
                            System.out.println("");
                            for (int dash = 1; dash <= 161; dash++)
                                System.out.print("-");
                            System.out.println("");
                        }
                    }
                } else if ((chance + 1) % 4 == 0) {
                    System.out.println("It is " + player3 + "\'s turn:");
                    System.out.println("Enter \'Roll\' to roll the dice:");
                    char pause = sc.next().charAt(0);
                    System.out.println("\f");
                    int dice = (int) (Math.random() * 6 + 1);
                    p3_val = p3_val + dice;
                    if (p3_val == 100) {
                        System.out.println(player3 + " won!!");
                        break;
                    } else if (p3_val > 100) {
                        System.out.println("You rolled more than you require to reach 100!!");
                        System.out.println("You can't move ahead!!");
                        p3_val = p3_val - dice;
                    }
                    for (int pfill = 0; pfill < 100; pfill++) {
                        p3[pfill] = " ";
                    }
                    p3[p3_val - 1] = " \u278C";
                    System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->" + player3
                            + "\t\t\u278D -->" + player4);
                    for (int boardi = 1; boardi <= 10; boardi++) {
                        if (boardi % 2 == 0) {
                            t = t - 9;
                            s_and_l = s_and_l - 9;
                            order = 1;
                        } else if (boardi != 1) {
                            t = t - 11;
                            s_and_l = s_and_l - 11;
                            order = 0;
                        }
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                            if (order == 1)
                                t++;
                            else if (order == 0)
                                t--;
                        }
                        System.out.println("");
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            if (order == 0) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l - 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l + 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1)
                                s_and_l++;
                            else if (order == 0)
                                s_and_l--;
                        }
                        System.out.println("");
                        for (int dash = 1; dash <= 161; dash++)
                            System.out.print("-");
                        System.out.println("");
                    }
                    System.out.println("Roll = " + dice);
                    if (SnakesnLadders[p3_val - 1] != " ") {
                        // Snakes
                        if (p3_val == 99) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 5!!");
                            p3_val = 5;
                        }
                        if (p3_val == 91) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 75!!");
                            p3_val = 75;
                        }
                        if (p3_val == 87) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 24!!");
                            p3_val = 24;
                        }
                        if (p3_val == 51) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 47!!");
                            p3_val = 47;
                        }
                        if (p3_val == 49) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 23!!");
                            p3_val = 23;
                        }
                        if (p3_val == 37) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 29!!");
                            p3_val = 29;
                        }
                        if (p3_val == 17) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 3!!");
                            p3_val = 3;
                        }
                        // Ladders
                        if (p3_val == 82) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 97!!");
                            p3_val = 97;
                        }
                        if (p3_val == 55) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 63!!");
                            p3_val = 63;
                        }
                        if (p3_val == 33) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 83!!");
                            p3_val = 83;
                        }
                        if (p3_val == 19) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 80!!");
                            p3_val = 80;
                        }
                        if (p3_val == 16) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 25!!");
                            p3_val = 25;
                        }
                        if (p3_val == 9) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 39!!");
                            p3_val = 39;
                        }
                        if (p3_val == 4) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 14!!");
                            p3_val = 14;
                        }
                        t = 99;
                        s_and_l = 99;
                        order = 0;
                        for (long i = -9999; i <= 99999999; i++)
                            ;
                        System.out.print("\f");
                        for (int pfill = 0; pfill < 100; pfill++) {
                            p3[pfill] = " ";
                        }
                        p3[p3_val - 1] = " \u278C";
                        System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->"
                                + player3 + "\t\t\u278D -->" + player4);
                        for (int boardi = 1; boardi <= 10; boardi++) {
                            if (boardi % 2 == 0) {
                                t = t - 9;
                                s_and_l = s_and_l - 9;
                                order = 1;
                            } else if (boardi != 1) {
                                t = t - 11;
                                s_and_l = s_and_l - 11;
                                order = 0;
                            }
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                                if (order == 1)
                                    t++;
                                else if (order == 0)
                                    t--;
                            }
                            System.out.println("");
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                if (order == 0) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l - 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l + 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1)
                                    s_and_l++;
                                else if (order == 0)
                                    s_and_l--;
                            }
                            System.out.println("");
                            for (int dash = 1; dash <= 161; dash++)
                                System.out.print("-");
                            System.out.println("");
                        }
                    }
                } else if (chance % 4 == 0) {
                    System.out.println("It is " + player4 + "\'s turn:");
                    System.out.println("Enter \'Roll\' to roll the dice:");
                    char pause = sc.next().charAt(0);
                    System.out.println("\f");
                    int dice = (int) (Math.random() * 6 + 1);
                    p4_val = p4_val + dice;
                    if (p4_val == 100) {
                        System.out.println(player4 + " won!!");
                        break;
                    } else if (p4_val > 100) {
                        System.out.println("You rolled more than you require to reach 100!!");
                        System.out.println("You can't move ahead!!");
                        p4_val = p4_val - dice;
                    }
                    for (int pfill = 0; pfill < 100; pfill++) {
                        p4[pfill] = " ";
                    }
                    p4[p4_val - 1] = " \u278D";
                    System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->" + player3
                            + "\t\t\u278D -->" + player4);
                    for (int boardi = 1; boardi <= 10; boardi++) {
                        if (boardi % 2 == 0) {
                            t = t - 9;
                            s_and_l = s_and_l - 9;
                            order = 1;
                        } else if (boardi != 1) {
                            t = t - 11;
                            s_and_l = s_and_l - 11;
                            order = 0;
                        }
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                            if (order == 1)
                                t++;
                            else if (order == 0)
                                t--;
                        }
                        System.out.println("");
                        for (long boardj = 1; boardj <= 10; boardj++) {
                            if (order == 0) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l - 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1) {
                                if (boardj == 1) {
                                    if (SnakesnLadders[s_and_l] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                } else if (SnakesnLadders[s_and_l + 1] != " ")
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                else
                                    System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                            }
                            if (order == 1)
                                s_and_l++;
                            else if (order == 0)
                                s_and_l--;
                        }
                        System.out.println("");
                        for (int dash = 1; dash <= 161; dash++)
                            System.out.print("-");
                        System.out.println("");
                    }
                    System.out.println("Roll = " + dice);
                    if (SnakesnLadders[p4_val - 1] != " ") {
                        // Snakes
                        if (p4_val == 99) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 5!!");
                            p4_val = 5;
                        }
                        if (p4_val == 91) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 75!!");
                            p4_val = 75;
                        }
                        if (p4_val == 87) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 24!!");
                            p4_val = 24;
                        }
                        if (p4_val == 51) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 47!!");
                            p4_val = 47;
                        }
                        if (p4_val == 49) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 23!!");
                            p4_val = 23;
                        }
                        if (p4_val == 37) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 29!!");
                            p4_val = 29;
                        }
                        if (p4_val == 17) {
                            System.out.println("Oh no You landed on a snake!!!");
                            System.out.println("You Slip to 3!!");
                            p4_val = 3;
                        }
                        // Ladders
                        if (p4_val == 82) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 97!!");
                            p4_val = 97;
                        }
                        if (p4_val == 55) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 63!!");
                            p4_val = 63;
                        }
                        if (p4_val == 33) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 83!!");
                            p4_val = 83;
                        }
                        if (p4_val == 19) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 80!!");
                            p4_val = 80;
                        }
                        if (p4_val == 16) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 25!!");
                            p4_val = 25;
                        }
                        if (p4_val == 9) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 39!!");
                            p4_val = 39;
                        }
                        if (p4_val == 4) {
                            System.out.println("WOW! You landed on a ladder!!!");
                            System.out.println("You Climb to 14!!");
                            p4_val = 14;
                        }
                        t = 99;
                        s_and_l = 99;
                        order = 0;
                        for (long i = -9999; i <= 99999999; i++)
                            ;
                        System.out.print("\f");
                        for (int pfill = 0; pfill < 100; pfill++) {
                            p4[pfill] = " ";
                        }
                        p4[p4_val - 1] = " \u278D";
                        System.out.println("\u278A -->" + player1 + "\t\t\u278B -->" + player2 + "\t\t\u278C -->"
                                + player3 + "\t\t\u278D -->" + player4);
                        for (int boardi = 1; boardi <= 10; boardi++) {
                            if (boardi % 2 == 0) {
                                t = t - 9;
                                s_and_l = s_and_l - 9;
                                order = 1;
                            } else if (boardi != 1) {
                                t = t - 11;
                                s_and_l = s_and_l - 11;
                                order = 0;
                            }
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                System.out.print(p1[t] + p2[t] + "\t" + board[t] + p3[t] + p4[t] + "\t|");
                                if (order == 1)
                                    t++;
                                else if (order == 0)
                                    t--;
                            }
                            System.out.println("");
                            for (long boardj = 1; boardj <= 10; boardj++) {
                                if (order == 0) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l - 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l - 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1) {
                                    if (boardj == 1) {
                                        if (SnakesnLadders[s_and_l] != " ")
                                            System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                        else if (SnakesnLadders[s_and_l + 1] != " ")
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|");
                                        else
                                            System.out.print("\t" + SnakesnLadders[s_and_l] + "\t|\t");
                                    } else if (SnakesnLadders[s_and_l + 1] != " ")
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|");
                                    else
                                        System.out.print(SnakesnLadders[s_and_l] + "\t|\t");
                                }
                                if (order == 1)
                                    s_and_l++;
                                else if (order == 0)
                                    s_and_l--;
                            }
                            System.out.println("");
                            for (int dash = 1; dash <= 161; dash++)
                                System.out.print("-");
                            System.out.println("");
                        }
                    }
                }
            }

            System.out.println("");
            System.out.println("Press y or Y to retry.");
            System.out.println("Enter any other character to exit ");
            retry = sc.next().charAt(0);
            System.out.println("\f");
        } while (retry == 'y' || retry == 'Y');
        System.out.println("Thank You.");
    }
}
