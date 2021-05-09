package quiz1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        int an_old_shoe=1;
        int a_huge_fish=100;
        int a_leaf=2;
        int a_small_fish=50;
        int a_rock=3;
        int garbage=0;
        
        String answer= "Y";
        double points=0;
        int cast=0;
        int min=1;
        int max=6;
        
        while(answer.equals("Y") || answer.equals("y") ){
            
        int random_number = ThreadLocalRandom.current().nextInt(min, max + 1);

        System.out.println("Let's go fishing!");
        cast++;
        switch(random_number){
            case 1:
                System.out.println("You caught an old shoe!");
                points+=1;
                break;
            case 2:
                System.out.println("You caught a huge fish!");
                points+=100;
                break;
            case 3:
                System.out.println("You caught a leaf!");
                points+=2;
                break;
            case 4:
                System.out.println("You caught a small fish!");
                points+=50;
                break;
            case 5:
                System.out.println("You caught a rock!");
                points+=3;
                break;
            case 6:
                System.out.println("You caught a garbage...");
                break;
            
        }
        
        System.out.println("Try fishing again? (Y or N)");
        Scanner scanner = new Scanner(System.in);
        answer = scanner. nextLine();
        }
        double average = points/cast;
        
        System.out.println("You got a total of "+ points + " fishing points.");
        System.out.println("You casted your fishing line "+ cast +" times.");
        NumberFormat formatter = new DecimalFormat("#0000.00"); 
        System.out.println("Average = "+formatter.format(average));
        
        if(10.0<average && average<20.0){
            System.out.println("That is some fine fishing");
        }
        else if(average<10.0){
            System.out.println("Try again in future");      
        }
        else if(average>20.0){
            System.out.println("Great Job");
        }
    }
    
}
