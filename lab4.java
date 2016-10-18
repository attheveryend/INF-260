/*    Alex Leduc
 *    lab4, conditional statements
 *    INF 260L
 *
 *		I am writing this program under the assumption that the user is a staff member of King's Island.
 */
 import javax.swing.*;
 
 public class lab4
 	{
 	 	public static void main( String[] args ){
 	 		
 	 		//Greeting
 	 		JOptionPane.showMessageDialog(null, "Hello and welcome to the King's Island super delightful ticket booth program!");
 	 		
 	 		//Variable Declaration
 	 		String stringAge = JOptionPane.showInputDialog( null, "What is the age of the customer?");
 	 		int age = Integer.parseInt(stringAge);
 	 		
 	 		//This conditional allows for immediate pricing of children under five, since all get in free, it doesn't matter what county they are from, so even asking that question is redundant.
 	 		if(age<=5){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is absolutely nothing.");
 	 			System.exit(0);
 	 		}	
 	 		
 	 	 	String stringCounty = JOptionPane.showInputDialog( null, "From whence doth yon customer come?\n\nEnter 1 for Warren County\nEnter 2 For Campbell County\nEnter 3 for Clermont County\nEnter 4 for Elsewhere.");
			int county = Integer.parseInt( stringCounty );
/* stringCounty INPUT USES FOLLOWING CONVENTION:
 *  Warrent county  = 1
 *  Campbell county = 2
 *  Clermont county = 3
 *  Everywhere else = 4
 */	
 	 	
 	 		
 	 		
 	 		 	 		 	 		
 	 		//Conditional Statements 	 		}
 	 		if(age<=5);
 	 		else if(age<=14 && county==3){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $36.00");
 	 		}
 	 		else if(age>=65 && county==1){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $15.00");
 	 		}
 	 		else if(age>=65 && county==2){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $18.00");
 	 		}
 	 		else if(age>=65 && (county==3||county==4) ){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $20.00");
 	 		}
 	 		else if(county==1 ){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $30.00");
 	 		}
 	 		else if( county==2||county==3||county==4 ){
 	 			JOptionPane.showMessageDialog(null, "The price of admission for this customer is $40.00");
 	 		}
 	 		else{
 	 			JOptionPane.showMessageDialog(null, "you shouldn't have done that.");
 	 		}
 	 		System.exit(0);
 	}
 }