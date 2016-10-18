/*	Alex Leduc
 *
 *	Lab 6, part 9
 */
 import java.util.*;
 
 public class lab6pt2{
 	public static void main(String[] args){
 		Scanner input = new Scanner(System.in);
 		System.out.println("\nPlease enter the largest integer base for which you would like to create a table of exponentiation for");
 		int baseinput = input.nextInt();
 		System.out.println("\n\n\nn\t\tn^2\t\tn^3\t\tn^4");
 		for(int n=1; n <= baseinput; n++){
 			System.out.println(power(n,1)+ "\t\t" + power(n,2) + "\t\t" + power(n,3) + "\t\t" + power(n,4));
 		}
 		System.exit(0);
 	}
 
 	public static long power(int base, int exponent){
 		long initbase = 1;
 		for(int x=1; x <= exponent; x++){
 			initbase = initbase * base;
 		}
 		return(initbase);
 	}
 }