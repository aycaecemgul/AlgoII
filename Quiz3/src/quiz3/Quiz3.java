package quiz3;

import java.util.Scanner;

/**
 *
 * @author aycae
 */
public class Quiz3 {

    public static void main(String[] args) {
        
        //get the n and k from user
        Scanner scan= new Scanner(System.in);
        System.out.println("n:");
        int n=Integer.parseInt(scan.nextLine());
        System.out.println("k:");
        int k=Integer.parseInt(scan.nextLine());
        balonPozisyonuBul(n, k);

    }

    static void balonPozisyonuBul(int n, int k){
        
        CircularLL ll = new CircularLL(n);
        //nodes that will be used to traverse CLL
        Node currentNode = ll.first;
        Node lastNode = ll.first; 
         
        while(currentNode.next != currentNode)
        {
            //traverse through the CLL
            int count = 1;
            while(count != k)
            {
                lastNode = currentNode;
                currentNode = currentNode.next;
                count++;
            }

            lastNode.next = currentNode.next; //remove the current node
            currentNode = lastNode.next;
        }
        System.out.println(currentNode.data+"th balloon survived.");
        
    }
    
    
}
