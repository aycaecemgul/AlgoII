package quiz4;

public class Stack {
    
    Object[] array;
    int index;
    int capacity;
    
    //constructor has a parameter capacity that
    //is used as the array length while creating the array
    //index is 0 because when the stack is created
    //it is empty at first
    
    public Stack(int capacity) {
        this.capacity = capacity;
        array=new Object[capacity];
        index=0;
    }

    public int getIndex() {
        return index;
    }
    
    //if the index is 0, it means the stack is empty.
    public boolean isEmpty(){
        return index != 0;
    }
    
    //to push an object
    //first increment the index value
    //then add the object to the new index.
    public void push(Object object){
    
        index+=1;
        array[index]=object;
        
    }
    
    //to pop the last object on stack
    //store the last pushed object as popped_object and remove
    //the object on the index then dec the index value
    //then return the popped object
    public Object pop(){
        if(index!=0){
            Object popped_object=array[index];
            array[index]=null;
            index-=1;
            return popped_object;
        }
        else return null;
    }
    
    
    
}
