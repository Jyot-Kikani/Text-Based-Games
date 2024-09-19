import java.util.Scanner;
public class Game2_Tic_Tac_Toe
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        char retry='y';
        System.out.println("Enter \'Start\' to start the game:");
        do
        {
            String start=sc.nextLine();
            System.out.println("The game will start in :");
            for(short x=5; x>=1; x--)
            {
                System.out.println(x);
                for(long i=-9999; i<=999999999; i++);
            }
            System.out.println("\f-----------------------------");
            System.out.println("Welcome to Java Tic-Tac-Toe!");
            System.out.println("-----------------------------\n");
            System.out.println("Rules:");
            System.out.println("--> This is similar to the Tic-Tac-Toe game played by many people.");
            System.out.println("--> This is a two-player game.");
            System.out.println("--> There will be a 3x3 board.");
            System.out.println("--> Players will take turns to put \'X\' or \'O\' in one of the boxes.");
            System.out.println("--> Enter the letter of the box in which you want to put your character.");
            System.out.println("--> If a player manages to fill a diagonal, column, or row with his character,");
            System.out.println("    he will win. ");
            System.out.println("--> Player 1 will get \'X\' and Player 2 will get \'O\'.\n");
            System.out.println("Enter Player 1's name:");
            String p1=sc.nextLine();
            System.out.println("Enter Player 2's name:");
            String p2=sc.nextLine();
            char a='a';
            char b='b';
            char c='c';
            char d='d';
            char e='e';
            char f='f';
            char g='g';
            char h='h';
            char i='i';
            for(long loopmain=0; loopmain>=0;loopmain++)
            {
                if(loopmain%2==0)
                {
                    for(long loop1=0; loop1>=0; loop1++){
                        System.out.println("\fThis is "+p1+"'s turn.");
                        System.out.println(" ");
                        System.out.println("   "+a+"   |   "+b+"   |   "+c);
                        System.out.println("-------+-------+--------");
                        System.out.println("   "+d+"   |   "+e+"   |   "+f);
                        System.out.println("-------+-------+-------");
                        System.out.println("   "+g+"   |   "+h+"   |   "+i);
                        System.out.println("");
                        System.out.println("Enter the box in which you want to put the \'X\'");
                        char input=sc.next().charAt(0);
                        System.out.println("\f");
                        if(input=='a' && a=='a')
                        {
                            a='X';
                            break;
                        }
                        else if(input=='b' && b=='b')
                        {
                            b='X';
                            break;
                        }
                        else if(input=='c' && c=='c')
                        {
                            c='X';
                            break;
                        }
                        else if(input=='d' && d=='d')
                        {
                            d='X';
                            break;
                        }
                        else if(input=='e' && e=='e')
                        {
                            e='X';
                            break;
                        }
                        else if(input=='f' && f=='f')
                        {
                            f='X';
                            break;
                        }
                        else if(input=='g' && g=='g')
                        {
                            g='X';
                            break;
                        }
                        else if(input=='h' && h=='h')
                        {
                            h='X';
                            break;
                        }
                        else if(input=='i' && i=='i')
                        {
                            i='X';
                            break;
                        }
                        else continue;
                    }
                }
                else if(loopmain%2!=0)
                {
                    for(long loop2=0; loop2>=0; loop2++){
                        System.out.println("\fThis is "+p2+"'s turn.");
                        System.out.println(" ");
                        System.out.println("   "+a+"   |   "+b+"   |   "+c);
                        System.out.println("-------+-------+--------");
                        System.out.println("   "+d+"   |   "+e+"   |   "+f);
                        System.out.println("-------+-------+--------");
                        System.out.println("   "+g+"   |   "+h+"   |   "+i);
                        System.out.println("");
                        System.out.println("Enter the box in which you want to put the \'O\'");
                        char input=sc.next().charAt(0);
                        System.out.println("\f");
                        if(input=='a' && a=='a')
                        {
                            a='O';
                            break;
                        }
                        else if(input=='b' && b=='b')
                        {
                            b='O';
                            break;
                        }
                        else if(input=='c' && c=='c')
                        {
                            c='O';
                            break;
                        }
                        else if(input=='d' && d=='d')
                        {
                            d='O';
                            break;
                        }
                        else if(input=='e' && e=='e')
                        {
                            e='O';
                            break;
                        }
                        else if(input=='f' && f=='f')
                        {
                            f='O';
                            break;
                        }
                        else if(input=='g' && g=='g')
                        {
                            g='O';
                            break;
                        }
                        else if(input=='h' && h=='h')
                        {
                            h='O';
                            break;
                        }
                        else if(input=='i' && i=='i')
                        {
                            i='O';
                            break;
                        }
                        else continue;
                    }
                }
                if(a=='X' && d=='X' && g=='X')
                {
                    System.out.println(p1+" has completed the first column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a=='O' && d=='O' && g=='O')
                {
                    System.out.println(p2+" has completed the first column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(b=='X' && e=='X' && h=='X')
                {
                    System.out.println(p1+" has completed the second column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(b=='O' && e=='O' && h=='O')
                {
                    System.out.println(p2+" has completed the second column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(c=='X' && f=='X' && i=='X')
                {
                    System.out.println(p1+" has completed the third column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(c=='O' && f=='O' && i=='O')
                {
                    System.out.println(p2+" has completed the third column!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a=='X' && b=='X' && c=='X')
                {
                    System.out.println(p1+" has completed the first row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a=='O' && b=='O' && c=='O')
                {
                    System.out.println(p2+" has completed the first row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(d=='X' && e=='X' && f=='X')
                {
                    System.out.println(p1+" has completed the second row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(d=='O' && e=='O' && f=='O')
                {
                    System.out.println(p2+" has completed the second row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(g=='X' && h=='X' && i=='X')
                {
                    System.out.println(p1+" has completed the third row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(g=='O' && h=='O' && i=='O')
                {
                    System.out.println(p2+" has completed the third row!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a=='X' && e=='X' && i=='X')
                {
                    System.out.println(p1+" has completed the first diagonal!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a=='O' && e=='O' && i=='O')
                {
                    System.out.println(p2+" has completed the first diagonal!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(g=='X' && e=='X' && c=='X')
                {
                    System.out.println(p1+" has completed the second diagonal!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(g=='O' && e=='O' && c=='O')
                {
                    System.out.println(p2+" has completed the second diagonal!!!");
                    System.out.println("Congrats!! You are the champion of Tic-Tac-Toe!!");
                    break;
                }
                else if(a!='a' && b!='b' && c!='c' && d!='d' && e!='e' && f!='f' && g!='g' && h!='h' && i!='i')
                {
                    System.out.println("It is a tie!!!");
                    System.out.println("It was a tough game!!!");
                    break;
                }
            }
            System.out.println("");
            System.out.println("   "+a+"   |   "+b+"   |   "+c);
            System.out.println("-------+-------+--------");
            System.out.println("   "+d+"   |   "+e+"   |   "+f);
            System.out.println("-------+-------+--------");
            System.out.println("   "+g+"   |   "+h+"   |   "+i);
            System.out.println("");
            System.out.println("Press y or Y to retry.");
            System.out.println("Enter any other character to exit ");
            retry=sc.next().charAt(0);
            System.out.println("\f");
        }while(retry=='y' || retry=='Y');
        System.out.println("Thank You.");
    }
}