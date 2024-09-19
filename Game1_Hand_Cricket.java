import java.util.Scanner;
import java.io.*;
public class Game1_Hand_Cricket
{
    public static void main()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        char retry='Y';//Used to run the game till the user wants to stop it
        
        Main:while(retry=='y' || retry=='Y' || retry=='Y')
        {   //'Main' is the label of the loop
            double comp_rand;//random decimal number for computer's score
            long i;//used in loops
            long user_n=0;//used to accept the user's number
            long score1=0;//player's score
            long score2=0;//computer's score
            long comp_ch=2;//computer's choice for batting or bowling.
            short comp_n=0;//computer's number as a whole number
            short x;//used in loops
            char user_ch='x';//user's choice for batting or bowling
            double rand;//generrate a random number for computer's choice
            System.out.println("\f");
            
            System.out.println("-------------------");
            System.out.println("WELCOME TO THE GAME");
            System.out.println("-------------------");
            
            System.out.println("");
            System.out.println("Hello,");
            System.out.println("WELCOME TO JAVA CRICKET \n");
            System.out.println("Rules:");
            System.out.println("--> This game is similar to the Hand-Cricket game played by many people.");
            System.out.println("--> There is no limit on the number of balls.");
            System.out.println("--> You will have to enter a number from 1 to 10.");
            System.out.println("--> Whoever is bowling will try to guess the other's number.");
            System.out.println("--> If the bowler's and the batsman's numbers are the same,");
            System.out.println("    the batsman will be declared Out.");
            System.out.println("--> First there will be a coin toss to decide who bats first.");
            
            System.out.println("Welcome to the coin toss");
            double toss=Math.random();//To generate a random decimal number.
            long result=Math.round(toss);//To round off result to 1 or 0.
            System.out.println("Enter 'H' for Heads and 'T' for Tails.");
            char ch=sc.next().charAt(0);//To enter user's choice.
            short ht=2;//To compare result and user's choice.
            if(ch=='h'||ch =='H')ht=0;
            else if(ch=='t'||ch =='T')ht=1;
            else continue;
            if(result==0)System.out.println("\f It is Heads!!!!");
            else if(result==1)System.out.println("\f It is Tails!!!!");
            if(ht==result)
            {
                System.out.println("You have won!!! Congrats!!");
                System.out.println("Enter 'Bat' for batting and 'Bowl' for bowling");
                user_ch=sc.next().charAt(1);
            }
            else if(ht!=result){
                System.out.println("You lost!!! Better luck next time!!");
                rand=Math.random();
                comp_ch=Math.round(rand);
                if(comp_ch==0)System.out.println("The computer chose to bat!");
                else if(comp_ch==1)System.out.println("The computer chose to bowl");
            }
            System.out.println("");
            if(user_ch=='a' || user_ch=='A' || comp_ch==1)
            {
                System.out.println("--> You wll bat first. Enter any number from 1 to 10.");
                System.out.println("--> Enter the numbers carefully without making any mistakes.");
                System.out.println("--> If the number entered by the computer is same as your number,");
                System.out.println("    you will be declared as Out. ");
                System.out.println("--> Your final score will be the sum of the numbers entered by you.");
                System.out.println("--> After you are out, you have to bowl.");
                System.out.println("--> Try entering the same number as the computer.");
                System.out.println("--> After the computer is out, the final scores will be calculated.");
                System.out.println("--> The highest scorer wins!!!");
                System.out.println("--> YOU ARE BATTING!!!!");
                for (i=1; i>0; i++)
                {
                    System.out.println("");
                    System.out.print("Enter Your Number: ");
                    user_n=sc.nextLong();//To input user's number
                    comp_rand=(Math.random())*10;
                    comp_rand+=1;
                    comp_n=(short)(comp_rand);
                    System.out.println("Computer's Number: "+comp_n);
                    if(user_n==comp_n)
                    {
                        System.out.println("");
                        System.out.println("HOWZATTT!!!!!");
                        System.out.println("");
                        System.out.println("###################");
                        System.out.println("YOUR FINAL SCORE = "+score1);
                        System.out.println("###################");
                        System.out.println("");
                        break;
                    }
                    
                    else if(user_n>0 && user_n<=10)score1=score1+user_n;
                    else
                    {
                        System.out.println("You have either tried to cheat or entered an invalid number.");
                        System.out.println("Please try again!!!");
                        System.out.println(":( :( :( :( :( :( :( :(");
                        System.out.println("The game will start again in :");
                        for(x=5; x>=1; x--)
                        {
                            System.out.println(x);
                            for(i=-9999; i<=999999999; i++);
                        }
                        continue Main;//To continue the Main loop if the number is wrong.
                    }
                    System.out.println("Your current score is: "+score1);
                    System.out.println("");
                }
                
                System.out.println("YOU ARE BOWLING!!!!");
                for (i=1; i>0; i++)
                {
                    System.out.println("");
                    System.out.print("Enter Your Number: ");
                    user_n=sc.nextLong();//To input user's number
                    comp_rand=(Math.random())*10;
                    comp_rand+=1;
                    comp_n=(short)(comp_rand);
                    System.out.println("");
                    System.out.println("Computer's Number: "+comp_n);
                    System.out.println("");
                    if(comp_n==user_n)
                    {
                        System.out.println("");
                        System.out.println("COMPUTER IS OUT!!!!!");
                        System.out.println("");
                        System.out.println("##########################");
                        System.out.println("COMPUTER'S  FINAL SCORE = "+score2);
                        System.out.println("##########################");
                        System.out.println("");
                        break;
                    }
                    
                    else if(user_n>0 && user_n<=10)score2+=comp_n;
                    else
                    {
                        System.out.println("You have either tried to cheat or entered an invalid number.");
                        System.out.println("Please try again!!!");
                        System.out.println(":( :( :( :( :( :( :( :(");
                        System.out.println("The game will start again in :");
                        for(x=5; x>=1; x--)
                        {
                            System.out.println(x);
                            for(i=-9999; i<=999999999; i++);
                        }
                        continue Main;//To continue the Main loop if the number is wrong.
                    }
                    if(score2>score1)break;
                    System.out.println("The computer's current score is: "+score2);
                    System.out.println("");
                }
            }
            else if(user_ch=='o' || user_ch=='O' || comp_ch==0)
            {
                System.out.println("--> You wll bowl first. Enter any number from 1 to 10.");
                System.out.println("--> Enter the numbers carefully without making any mistakes.");
                System.out.println("--> Try entering the same number as the computer.");
                System.out.println("--> If the number entered by the computer is same as your number,");
                System.out.println("    the computer will be declared as Out. ");
                System.out.println("--> The computer's score will be the sum of the numbers entered by it.");
                System.out.println("--> After the computer is out, you have to bat.");
                System.out.println("--> After you are out, the final scores will be calculated.");
                System.out.println("--> The highest scorer wins!!!");
                System.out.println("--> YOU ARE BOWLING!!!!");
                for (i=1; i>0; i++)
                {
                    System.out.println("");
                    System.out.print("Enter Your Number: ");
                    user_n=sc.nextLong();//To input user's number
                    comp_rand=(Math.random())*10;
                    comp_rand+=1;
                    comp_n=(short)(comp_rand);
                    System.out.println("");
                    System.out.println("Computer's Number: "+comp_n);
                    System.out.println("");
                    if(comp_n==user_n)
                    {
                        System.out.println("");
                        System.out.println("COMPUTER IS OUT!!!!!");
                        System.out.println("");
                        System.out.println("##########################");
                        System.out.println("COMPUTER'S  FINAL SCORE = "+score2);
                        System.out.println("##########################");
                        System.out.println("");
                        break;
                    }
                    
                    else if(user_n>0 && user_n<=10)score2+=comp_n;
                    else
                    {
                        System.out.println("You have either tried to cheat or entered an invalid number.");
                        System.out.println("Please try again!!!");
                        System.out.println(":( :( :( :( :( :( :( :(");
                        System.out.println("The game will start again in :");
                        for(x=5; x>=1; x--)
                        {
                            System.out.println(x);
                            for(i=-9999; i<=999999999; i++);
                        }
                        continue Main;//To continue the Main loop if the number is wrong.
                    }
                    System.out.println("The computer's current score is: "+score2);
                    System.out.println("");
                }
                System.out.println("--> YOU ARE BATTING!!!!");
                for (i=1; i>0; i++)
                {
                    System.out.println("");
                    System.out.print("Enter Your Number: ");
                    user_n=sc.nextShort();//To input user's number
                    comp_rand=(Math.random())*10;
                    comp_rand+=1;
                    comp_n=(short)(comp_rand);
                    System.out.println("Computer's Number: "+comp_n);
                    if(user_n==comp_n)
                    {
                        System.out.println("");
                        System.out.println("HOWZATTT!!!!!");
                        System.out.println("");
                        System.out.println("###################");
                        System.out.println("YOUR FINAL SCORE = "+score1);
                        System.out.println("###################");
                        System.out.println("");
                        break;
                    }
                    
                    else if(user_n>0 && user_n<=10)score1=score1+user_n;
                    else
                    {
                        System.out.println("You have either tried to cheat or entered an invalid number.");
                        System.out.println("Please try again!!!");
                        System.out.println(":( :( :( :( :( :( :( :(");
                        System.out.println("The game will start again in :");
                        for(x=5; x>=1; x--)
                        {
                            System.out.println(x);
                            for(i=-9999; i<=999999999; i++);
                        }
                        continue Main;//To continue the Main loop if the number is wrong.
                    }
                    if(score1>score2)break;
                    System.out.println("Your current score is: "+score1);
                    System.out.println("");
                }
            }
            if(score1>score2)
            {
                System.out.println("CONGRATS!!");
                System.out.println("You defeated the computer by "+(score1-score2)+" runs!!!!");
                System.out.println("Very well played!!");
                System.out.println("");
            }
            else if(score2>score1)
            {
                System.out.println("OH NO!!");
                System.out.println("The computer defeated you by "+(score2-score1)+" runs!!!!");
                System.out.println("Better luck next time!!");
                System.out.println("");
            }
            else if(score1==score2)
            {
                System.out.println("IT IS A TIE!!");
                System.out.println("You and the computer both scored "+score1+" runs!!!!");
                System.out.println("It was a great match!!");
            }
            System.out.println("Enter 'Yes' to retry:");
            retry=sc.next().charAt(0);
            System.out.println("\f");
        }
        System.out.println("Thank You for Playing!!");
    }
}