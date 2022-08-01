package com.thisgary.c3043.lecture.class6.class13.supplementary.package5;

//Fig. 14.16: ButtonTest. java
//Testing ButtonFrame.
import javax. swing. JFrame;
public class ButtonTest
{
	public static void main( String[] args )
	{
		ButtonFrame buttonFrame = new ButtonFrame(); // create ButtonFrame
		buttonFrame.setDefaultCloseOperation( JFrame. EXIT_ON_CLOSE);
		buttonFrame. setSize( 350, 180 ); // set frame size
		buttonFrame.setVisible( true ); // display frame
	} // end main
}	//end class ButtonTest