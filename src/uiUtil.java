import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class uiUtil {


	// /ads location variable
	public static void initFrame(JFrame frame, String title,
			double locX, double locY, Dimension size) {
		frame.setTitle(title);
		frame.setLocation((int) locX, (int) locY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(size);
		frame.setPreferredSize(size);
	}

	
}