package com.thisgary.c3043.lecture.class6.class13.supplementary.PACKAGE6;

//Fig. 14.18: CheckBoxTest. java
//Testing CheckBoxFrame.
import javax. swing. JFrame;
public class CheckBoxTest
{
	public static void main( String[] args )
	{
		CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
		checkBoxFrame. setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		checkBoxFrame. setSize( 275, 100 ); // set frame size
		checkBoxFrame.setVisible( true ); // display frame
	} // end main
} // end class CheckBoxTest