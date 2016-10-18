/*Alex Leduc
 *program 3
 */
 
 import java.util.*;
 
 public class prog3{
 	public static void main( String[] args ){
 		long [] array = new long [20];
 		Scanner input = new Scanner(System.in);
 		initArray(array);
 		commandUI(array, input );
 	}//end main
 	
 	 					//initArray
 	public static void initArray( long [] ar ){
 		for(int r = 0; r<20; r++){
 			ar[r] = r;
 		}//end for
 		System.out.println("The array has been initialized to :");
 		printArray(ar);
 	}//end initArray
 						//printArray
 	public static void printArray( long [] thing ){
 		for(int r = 0; r< thing.length; r++){
 			System.out.print( thing[r] + "  " );
 		}//end for
 		System.out.println("\n");
 	}//end printArray
 	
 						//commandUI
 	public static void commandUI(long [] ar, Scanner userin ){
 		int value = 0;
 		while(value < 5){
 			System.out.println("\nPlease select an option:\n\t0 - Initialize array\n\t1 - Square array values\n\t2 - Reverse array values\n\t3 - Accumulate array values\n\t4 - Halve array values\n\t or any other integer to quit.");
 			value = userin.nextInt();
 			if(value == 0)
 				initArray(ar);
 			else if( value == 1)
 				squareArray(ar);
 			else if( value == 2)
 				reverseArray(ar);
 			else if( value == 3)
 				accumulateArray(ar);
 			else if( value == 4)
 				halveArray(ar);
 			}
 			System.out.println("Quitting");
 			System.exit(0);
 		}//end commandUI
 		
 						//squareArray
 	public static void squareArray( long [] ar){
 		for(int r = 0; r< ar.length; r++){
 			ar[r]=ar[r]*ar[r];
 		}//end for
 		System.out.println("The array is now:  ");		
 		printArray(ar);
 	}//end squareArray
	
						//reverseArray
	public static void reverseArray(long [] ar){
		long temp = 0;
		int dim = ar.length-1;
		for(int r = 0; r < ar.length/2; r++){
			temp = ar[ r ];
			ar[ r ] = ar[dim - r ];
			ar[dim - r] = temp;
		}//end for
		System.out.println("The array is now:  ");		
 		printArray(ar);
	}//end reverseArray
						
						//accumulateArray
	public static void accumulateArray(long [] ar){
		long sum = 0;
		for(int r = 0; r<ar.length; r++){
			sum=sum+ar[r];
			ar[r]=sum;
		}//end for
		System.out.println("The array is now:  ");		
 		printArray(ar);
	}//end accumulateArray
	
						//halveArray
	public static void halveArray( long [] ar){
		for(int r = 0; r<ar.length; r++){
			ar[r]=ar[r]/2;
		}//end for
		System.out.println("The array is now:  ");		
 		printArray(ar);
	}//end halveArray
}