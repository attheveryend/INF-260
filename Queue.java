/**
 * 	Alex Leduc
 *	INF 260
 *	Queue data structure
 * 
 * 
 */


public class Queue {

private Integer [] elts;
private int front,rear;


	//============================================================================== constructors
    public Queue() {
    	elts = new Integer[10];
    	front = 0;
    	rear = 0;
    	
    }//end default constructor
    
    public Queue(int n ){
    	elts = new Integer[n];
    	front = 0;
    	rear = 0;
    }//end variable length constructor
    
    //==============================================================================	getfront
    public int getfront(){
    	return(front);
    }//end getfront
    
    //==============================================================================	isempty
    public boolean isempty(){
    	if(front==rear){
    		front=0;
    		rear=0;
    		return(true);
    	}//end if
    	return(false);
    }//end isempty
    
    //==============================================================================	dequeue
    public int dequeue(){
    	int temp = elts[front].intValue();
    	elts[front]=null;
    	front++;
    	return(temp);
    }//end dequeue
    
    //==============================================================================	enqueue
    //dependence:  copyOf
    //note:  copyOf method resets front and rear to relevant positions
    public void enqueue(int x){
    	
    	if( rear<elts.length ){
    		elts[rear]=new Integer(x);
    		rear++;
    	}
    	else if( (rear - front)< elts.length ){
    		elts = copyOf(elts, elts.length,front, rear);
    		elts[rear]=new Integer(x);
    		rear++;
    	}
    	else if( (rear-front)== elts.length ){
    		elts = copyOf(elts, elts.length*2, front, rear);
    		elts[rear]=new Integer(x);
    		rear++;
    	}//end if-else
    	
    }//end enqueue
    
    private Integer[] copyOf(Integer[] things,int length, int start, int end){
    	Integer[] copy = new Integer[length];
    	int a = 0;
    	for(int i = start; i<end;i++ ){
    		copy[a] = things[i];
    		a++;
    	}//end for
    	front = 0;
    	rear = a;
    	return(copy);
    }//end copyOf
    
}//end class queue