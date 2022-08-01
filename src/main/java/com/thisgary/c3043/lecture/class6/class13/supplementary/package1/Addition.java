package com.thisgary.c3043.lecture.class6.class13.supplementary.package1;

//Fig. 14.2: Addition. java
//Addition program that uses JOptionPane for input and output.
import javax.swing.JOptionPane; // program uses JOptionPane

public class Addition
{
  public static void main( String[] args )
	{		
		//obtain user input from JOptionPane input dialogs
		String firstNumber = JOptionPane.showInputDialog("Enteer first Float" );
		String secondNumber =
		JOptionPane. showInputDialog( "Enter second Float" );
		//convert String inputs to int values for use in a calculatio
		float number1 = Float. parseFloat( firstNumber );
		float number2 = Float. parseFloat( secondNumber );
		float sum = number1 + number2; // add numbers 
		//display result in a JOptionPane message dialog
		JOptionPane.showMessageDialog(null, "The sum is  "+ sum+ "  Sum of Two Integers", null, JOptionPane.ERROR_MESSAGE );
		JOptionPane.showMessageDialog(null, "The sum is  "+ sum+ "  Sum of Two Integers", null, JOptionPane.INFORMATION_MESSAGE );
		JOptionPane.showMessageDialog(null, "The sum is  "+ sum+ "  Sum of Two Integers", null, JOptionPane.WARNING_MESSAGE );
		JOptionPane.showMessageDialog(null, "The sum is  "+ sum+ "  Sum of Two Integers", null, JOptionPane.QUESTION_MESSAGE );
		JOptionPane.showMessageDialog(null, "The sum is  "+ sum+ "  Sum of Two Integers", null, JOptionPane.PLAIN_MESSAGE );

		
	}//end method main
	
}