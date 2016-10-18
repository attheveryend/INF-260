/*	Alex Leduc
 *	Lab6, part 5
 *
 */
 
 import javax.swing.*;
 	
 public class lab6pt1{
 	public static void main( String[] args ){
 		
 		//acquisition of user input for initial value of sum
 		String userinput = JOptionPane.showInputDialog(null, "Please enter the first integer you would like to sum.  \n\nEnter \"0\" to quit.");
 		
 		//declaration of variables and parsing
 		int value = Integer.parseInt(userinput);
 		int sum = value;
 		int counter = 0;
 		int oddcounter = 0;
 		double average;
 		
 		//loop to acquire more inputs, sum them, and count the odd inputs.
 		while(value != 0){
 			if(value % 2 == 1){
 				oddcounter++;
 			}
 			userinput = JOptionPane.showInputDialog(null, "Please enter the next integer you would like to sum.  \n\nEnter \"0\" to quit.");
 			value = Integer.parseInt(userinput);
 			sum = sum + value;
 			counter++;
 		}
 		
 		//to avoid division by zero, I set up a conditional to only calculate average for nonzero counter values.
 		//Today I learned about integer division vs. floating point division.  I had no idea there was a difference until this sting starting giving me wacko answers.
 		if(counter!=0){
 			double counterfloat=counter;
 			average = sum/counterfloat;
 		    JOptionPane.showMessageDialog(null, "The sum of the last " + counter + " non-zero integers entered is " + sum + "\nThe average value entered was " + average + "\nThere were " + oddcounter + " odd values entered.");
 		}
 		else{
 			average = 0;
 			JOptionPane.showMessageDialog(null, "The sum of the last " + counter + " non-zero integers entered is " + sum + "\nThe average value entered was " + average + "\nThere were " + oddcounter + " odd values entered.");
 		}
 		System.exit(0);
 	}
 }