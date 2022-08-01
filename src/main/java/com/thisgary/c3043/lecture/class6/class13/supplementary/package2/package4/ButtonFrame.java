package com.thisgary.c3043.lecture.class6.class13.supplementary.package2.package4;

//Fig. 14.15: ButtonFrame. java
//Creating JButtons.
import java. awt. FlowLayout;
import java. awt. event. ActionListener;
import java. awt. event. ActionEvent;
import javax. swing. JFrame;
import javax. swing. JButton;
import javax. swing. Icon;
import javax. swing. ImageIcon;
import javax. swing. JOptionPane;
@SuppressWarnings("serial")
public class ButtonFrame extends JFrame
{
	private JButton plainJButton; // button with just text
	private JButton fancyJButton; // button with icons
	//ButtonFrame adds JButtons to JFrame
	public ButtonFrame()
	{
		super( "Testing Buttons" );
		setLayout( new FlowLayout() ); // set frame layout
		JButton Button = new JButton( "PlainJButton" ); // button with text
		add( Button ); // add plainJButton to
		
		Icon BB = new ImageIcon( getClass().getResource( "/bud2.png" ) );
		Icon CC = new ImageIcon( getClass().getResource( "/bug2.png" ) );
		fancyJButton = new JButton( "Fancy Button", BB ); // set image
		fancyJButton.setRolloverIcon(CC ); // set rollover image
		add( fancyJButton ); // add fancyJButton to JFrame
		// create new ButtonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener( handler );
		//plainJButton.addActionListener( handler );
		} //	end ButtonFrame constructor
		// inner class for button event handling
	
	private class ButtonHandler implements ActionListener
	{
		// handle button event
		public void actionPerformed( ActionEvent event )
		{
			JOptionPane.showMessageDialog( ButtonFrame. this, String. format(
					"You pressed: %s", event. getActionCommand() ) );
		} 	// end method actionPerformed
}		 // end private inner class ButtonHandler
}		// end class ButtonFrame