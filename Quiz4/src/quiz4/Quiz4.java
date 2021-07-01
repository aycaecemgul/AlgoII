package quiz4;

/**
 *
 * @author aycae
 */
public class Quiz4 {

    public static void main(String[] args) {
        
        //initialize the stack
        Stack myStack = new Stack(25);
        
        //initialize the 5 customers
        Customer c1 = new Customer("1","Sheldon Plankton");
        Customer c2 = new Customer("2","Patrick Star");
        Customer c3 = new Customer("3","Bob Squarepants");
        Customer c4 = new Customer("4","Sandy Cheeks");
        Customer c5 = new Customer("5","Eugene Krabs");
        
        //push to the stack
        myStack.push(c1);
        myStack.push(c2);
        myStack.push(c3);
        myStack.push(c4);
        myStack.push(c5);
        
        //popping the last item and printing its information
        System.out.println("Popped! "+myStack.pop().toString());
        System.out.println("Popped! "+myStack.pop().toString());
        System.out.println("Popped! "+myStack.pop().toString());
        System.out.println("Popped! "+myStack.pop().toString());
        System.out.println("Popped! "+myStack.pop().toString());

    }
    
}
