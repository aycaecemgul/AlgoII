
package quiz3;

/**
 *
 * @author aycae
 */

//circular linked list
public class CircularLL {
    
    Node first;
    Node last;
    int length;
    //to create an empty circular linkedlist
    public CircularLL() {
    }

    //to create a cll that has given lenght and nodes that corresponds to their indexes.
    public CircularLL(int len){
        this.length=len;
        first= new Node(1);
        //CLL with 1 NODE
        if(len==1){last=new Node(1); last.next=first;return;}
        //Adds "len" amount of nodes to CLL 
        Node current = first;
        for(int i=2;i<len;i++){
            Node node=new Node(i);
            current.next=node;
            current=node;
        }        
        last = new Node(len);
        current.next=last;
        last.next=first;
    }
    
    //adds nodes to CLL
    public void add(){
        Node node= new Node(length+1); //node data is same as index
        if(first==null){
            first=new Node(1);
            last=new Node(1);     
        }
        else{
            last.next=node;
            last=node;
        }
        
        last.next=first; //connect the CLL
        length++;
    }

          
}
    
    

