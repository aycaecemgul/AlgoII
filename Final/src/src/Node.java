package src;

/**
 *
 * @author aycae
 */
public class Node {
    
    //data of the node
    CustomerInfo customer;
    //previous and next nodes
    Node prev;
    Node next;
    
    
    //constructors
    public Node(CustomerInfo customer, Node prev, Node next) {
        this.customer = customer;
        this.prev = prev;
        this.next = next;
    }

    public Node() {
    }

    public Node(CustomerInfo customer) {
        this.customer = customer;
        prev=null;
        next=null;
    }
    
    //getter and setter

    public CustomerInfo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Node" + "customer= " + customer.toString();
    }
    
    
    //adds a node before this node (helper function for adding a new node to doubly ll)
    public void insertNode(Node node){

        node.next=this;
        node.prev=this.prev;
        this.prev=node;
        
    }
    
}
