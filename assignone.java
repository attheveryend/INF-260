// ********************************************************************
//   Assignone.java                                Author:  Alex Leduc
// 
// Calculates net pay from hourly wage and hours worked based on simple formula
// ********************************************************************

import javax.swing.*;

public class assignone
{
	public static void main( String[] args){
		//Variable Declarations
		String wage, hours;
		double hourly_wage, hours_worked, net_pay, fica, state_tax, fed_tax, gross_pay;
		
		//Constants
		final int health = 150;
		
		//User Input dialog boxes
		wage = JOptionPane.showInputDialog(null, "Enter your hourly wage", "Hourly Wage");
		hours = JOptionPane.showInputDialog(null, "Enter the number of hours worked this pay period", "Hours Worked");
		
		//input parsing assignments
		hourly_wage = Double.parseDouble( wage );
		hours_worked = Double.parseDouble( hours );
		
		//calculations
		gross_pay = hourly_wage*hours_worked;
		fica = .05*gross_pay;
		state_tax = .07*gross_pay;
		fed_tax = .2*gross_pay;
		net_pay = gross_pay-(fica+state_tax+fed_tax+health);
		
		//output return
		System.out.println("Gross Pay: $" + gross_pay );
		System.out.println("Net Pay: $" + net_pay );
		System.exit(0);
				
	}
}

