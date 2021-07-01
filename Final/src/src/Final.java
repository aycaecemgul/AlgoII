package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author aycae
 */
public class Final {


    public static void main(String[] args) {
        System.out.println("Reading from txt file and adding to doubly ll");
        DoublyLL doubly = new DoublyLL();
        String adSoyad;
        String adres;
        String phone;
        String yOrN="y";
        ArrayList<String> phoneList=null;
        
        //get the information from txt file and create customerinfo objects then add to doubly ll
        try{
           File file = new File("customer.txt"); //reads the given txt file
           Scanner file_scanner = new Scanner(file);
           file_scanner.useLocale(Locale.US);
           
           while (file_scanner.hasNextLine()) {
               phoneList = new ArrayList<String>();
               String line= file_scanner.nextLine();
               String[] split = line.split(","); //splits the line by ","
               adSoyad=split[0]; //first split is the name
               adres=split[1]; //second split is the address
               
               //other splitted stuff are phone numbers
               for(int i=2;i<split.length;i++){ //gets the (multiple) phone numbers
                   phone=split[i];
                   phoneList.add(phone); //adds it to the phone list
               }
               CustomerInfo c=new CustomerInfo(adSoyad,adres,phoneList); //creates the new customerInfo object
               doubly.add(c); //adds to the doubly ll
               System.out.println("Customer added!");
               
           }
           System.out.println("Done!");
        }
        catch(FileNotFoundException e){
             System.out.println("error while reading input text");
        }
        
        //this part handles the console interaction with the user
        Scanner keyboard = new Scanner(System.in); 
        int answer=0;
        while(answer!=6){
            System.out.println("Hi there! What do you want to do? [1-5]");
            System.out.println("1)Add a new customer.");
            System.out.println("2)Print information of a customer.");
            System.out.println("3)Remove a customer.");
            System.out.println("4)Print list (A to Z)");
            System.out.println("5)Print list (Z to A)");
            System.out.println("6)Exit.");

            answer= keyboard.nextInt(); //gets the answer of the user
            keyboard.nextLine(); //consumes the \n nextInt() didn't 
            if(answer==1){
                    System.out.println("Enter the name and surname of the customer (english characters only!):");
                    adSoyad = keyboard.nextLine();
                    
                    System.out.println("Enter the address:");
                    adres=keyboard.nextLine();
                    phoneList= new ArrayList<String>(); //phone list to keep phone numbers and give it to the customerinfo constructor
                    
                    //while user wants to keep on adding phone numbers
                    while(yOrN.equals("y")){
                        System.out.println("Enter the phone number:");
                        phone=keyboard.nextLine(); //gets the phone number from user
                        phoneList.add(phone); //adds phone number to the phone list
                        System.out.println("Do you want to add another phone? (y/n)");
                        yOrN=keyboard.nextLine(); 
                    }
                    CustomerInfo c=new CustomerInfo(adSoyad,adres,phoneList); //creates the user
                    doubly.add(c); //adds to the list
                    System.out.println("Customer added!: " +c.toString());
            }
            else if(answer==2){
                    System.out.println("Enter the name and surname of the customer you'd like to print (english characters only!):");
                    adSoyad = keyboard.nextLine(); //gets the answer from the user
                    doubly.search(adSoyad); 
            }
            else if(answer==3){
                    System.out.println("Enter the name and surname of the customer you'd like to remove (english characters only!):");
                    adSoyad = keyboard.nextLine(); //gets the answer from the user
                    doubly.delete(adSoyad);
            }
            else if (answer==4){doubly.printAToZ();}
            else if(answer==5){doubly.printZToA();} 
            else if(answer==6){System.exit(0);} 
        }
    }
        
        
}
    

