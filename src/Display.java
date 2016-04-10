import javax.swing.*;

import java.awt.*;
import java.util.*;


class Display extends JFrame{

	static int locX = 100;

	static int locY = 100;
	
	protected JFrame mainFrame;
	protected static JLabel label;
	public Display(){
		mainFrame = new JFrame("Leap"); // name of the program at top of the
		// window

		

		mainFrame.setLayout(null);
		label = new JLabel();
		label.setText("Robot");
		label.setLocation(100, 100);
		label.setSize(new Dimension(100,100));
		mainFrame.add(label);
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(1280,720));
		mainFrame.setVisible(true);
		mainFrame.pack();
	}
	
	public static void updateLocation(int x , int y){
		label.setLocation(x,y);
		locX = x;
		locY = y;
	}
}
