/*	Alex Leduc
 *	INF 260
 *	Queue Data Structure Main
 *
 */
 
 public class prog6{
 	public static void main(String[] args){
 		
 		Queue  Q = new Queue( 20 );

 // Load the queue with 10 random integers

		for  (int x = 0; x < 10; x++)
  		Q.enqueue( x );

// test if the queue enqueue worked via the dequeue
		System.out.println("Testing Q – output should be 0-9");
 		while ( !Q.isempty( ) )
     		System.out.println( Q.dequeue( ) );
   
// test if queue grows automatically when truly full

		System.out.println("\nTesting for automatic growth of queue when truly full \n");
		System.out.println("Should be 0 – 34");

		for  (int x = 0; x < 35; x++)
     		Q.enqueue(x);

		while (!Q.isempty( ) )
     		System.out.println( Q.dequeue( ) );

		System.out.println("\nTesting if queue copy works when not truly full");

// insert 10 elements
		for ( int x = 0; x < 10; x++)
   			Q.enqueue(x);

// now delete 8 of them
 		for ( int x = 0; x < 8; x++)
    		Q.dequeue( );

 // now queue should have 2 elements at positions 8-9
// so we will try to add 12 elements.
 		for ( int x = 10; x < 22; x++)
   		Q.enqueue(x);

		System.out.println("Testing copyOf not truly full output should be 8-21\n");
		while (!Q.isempty( ))
     		System.out.println(Q.dequeue( ) );
     		
     	
 		}
 }