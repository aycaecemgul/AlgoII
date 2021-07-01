package src;

/**
 *
 * @author aycae
 */
public class DoublyLL {
    
    Node head;
    Node tail;
    
    //constructor
    public DoublyLL() {
        
        tail=null;
        head=null;
        
    }
    
    //adds a customer to doubly ll
    public void add(CustomerInfo customer){
        Node newNode = new Node(customer); //create a new node with the customer data.
        Node currentNode;
        Node lastNode=null;
        
        //if the list is empty add the new node as head and tail.
        if(head==null){
            head=newNode;
            tail=newNode;
            head.prev = null;
            head.next = null;
        } 
        
        //if head isnt empty
        else if (head != null){
            currentNode=head;
            String surname= getSoyad(customer.getAdSoyad()); //get the last name of the new customer that will be added to doublyll
            String currentNodeSurname;
            while(currentNode!=null){ //traverse through ll
         
                currentNodeSurname=getSoyad(currentNode.getCustomer().getAdSoyad()); //last name of the current node
                
                if(surname.compareToIgnoreCase(currentNodeSurname)<0 || surname.compareToIgnoreCase(currentNodeSurname)==0){ //if the surname is alphabetically before or same as the current node
                    
                    //add the newNode before the currentNode
                    Node temp=currentNode.prev;
                    currentNode.prev=newNode;
                    newNode.next=currentNode;
                    newNode.prev=temp;
                    if(temp!=null){temp.next=newNode;}
                    //if the currentNode was head, make the newNode head
                    else{head=newNode;}
                    break;
                }
                //move to the next node
                lastNode=currentNode;
                currentNode=currentNode.next;
            }
            //if currentNode is null, add newNode next to tail and make the newNode tail
            if(currentNode==null){
                lastNode.next=newNode;
                newNode.prev=lastNode;
                tail=newNode;
            }
        }
    }
    
    //searches a customer by their name
    public void search(String adSoyad){
        //if the list is empty
        if(head==null){System.out.println("Empty list!");}
        
        else{
            String surname=getSoyad(adSoyad);
            Node currentNode;
            currentNode=head;
            boolean found=false;
            //while the customer is not found
            while(!found){
                String currentNodeSurname=getSoyad(currentNode.getCustomer().getAdSoyad());
                if(currentNodeSurname.equals(surname)){ //if the searched name and the currentNode's name match return true and print info
                    currentNode.getCustomer().toString();
                    found=true;
                    System.out.println("Found!");
                    System.out.println(currentNode.getCustomer().toString());
                }
                else{
                    //if it's the end of the doubly ll, exit.
                    if(currentNode.equals(tail)){
                        System.out.println("Customer not found!");
                        break;
                    }
                    currentNode=currentNode.next; //if its not found, keep on traversing
                }
            }
        }
    
    }
    
    //removes a customer with given name
    public void delete(String adSoyad){
        //if the list is empty
        if(head==null){System.out.println("Empty list!");}
        else{
            String surname=getSoyad(adSoyad);
            Node currentNode;
            currentNode=head;
            boolean deleted=false;
            //while the node is not deleted
            while(!deleted){
                String currentNodeName=currentNode.getCustomer().getAdSoyad();
                String currentNodeSurname=getSoyad(currentNodeName);
                if(currentNodeSurname.equals(surname)){ //if the currentNodes customer name is equal to the given name
                    Node nextNode=currentNode.next; //get the next node of the currentnode
                    Node prevNode=currentNode.prev; //get the previous node of the currentnode
                    
                    //by connecting the prev and next nodes,current node is removed.
                    prevNode.next=nextNode; 
                    nextNode.prev=prevNode;
                    //to exit the loop change the deleted variable
                    deleted=true;
                    System.out.println("Deleted!");
                }
                else{
                    //if you traversed to the tail and couldnt find any matchs it means there aren't any customers with that name. exit!
                    if(currentNode.equals(tail)){
                        System.out.println("Customer not found!");
                        break;
                    }
                    //if youre not in the tail yet, keep on traversing
                    currentNode=currentNode.next;
                }
            }
        }
    
    }
    
    //prints the list Z to A
    public void printZToA(){
        Node currentNode=tail;
        do{
            System.out.println(currentNode.toString()); //print info
            currentNode=currentNode.prev; //traverse the list backwards
        }
        while(!currentNode.equals(head)); //if the currentnode is head, stop the traversing and print the head
        System.out.println(head.toString());
        
    }
    
    public void printAToZ(){
        Node currentNode=head;
        do{
            System.out.println(currentNode.toString()); //print info
            currentNode=currentNode.next; //traverse the list
        }
        while(!currentNode.equals(tail)); //if the currentnode is tail, stop the traversing and print the tail
        System.out.println(tail.toString());
    }

    @Override
    public String toString() {
        return "DoublyLL{" + "head=" + head.toString() + ", tail=" + tail.toString() + '}';
    }
    
    //returns the surname of the customer
    public String getSoyad(String adSoyad){
        String surname;
        String[] parts = adSoyad.split(" "); //splits the string
        switch (parts.length) {
            case 4: //if there are 4 names (low chance but you never know),get the last one
                surname=parts[3];
                break;
            case 3: //if there are 3 names,get the last one
                surname=parts[2];
                break;
            case 2: //if there are 2 names,get the last one
                surname=parts[1];
                break;
            default:
                System.out.println("error.");return null; //if there arent any name on the string
        }
        return surname;
    }
    
}
