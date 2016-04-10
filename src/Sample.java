

import java.io.IOException;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

class SampleListener extends Listener  {
	public void onInit(Controller controller) {
		System.out.println("Initialized");
		
		  
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}

	public void onDisconnect(Controller controller) {
		// Note: not dispatched when running in a debugger.
		System.out.println("Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}

	public void onFrame(Controller controller) {
		// Get the most recent frame and report some basic information
		Frame frame = controller.frame();
		/*System.out.println("Frame id: " + frame.id() + ", timestamp: "
				+ frame.timestamp() + ", hands: " + frame.hands().count()
				+ ", fingers: " + frame.fingers().count() + ", tools: "
				+ frame.tools().count() + ", gestures "
				+ frame.gestures().count());*/

		// Get hands
		for (Hand hand : frame.hands()) {
			/*String handType = hand.isLeft() ? "Left hand" : "Right hand";
			System.out.println("  " + handType + ", id: " + hand.id()
					+ ", palm position: " + hand.palmPosition());*/

			//System.out.println(hand.palmPosition().getX());
			double palmPositionX = hand.palmPosition().getX();
			double palmPositionY = hand.palmPosition().getY();
			double palmPositionZ = hand.palmPosition().getZ();
			
			int speed = 15;
			
			if (palmPositionX > 0  && Display.locX < 1200)
			{
				System.out.println("right");
				Display.updateLocation(Display.locX + (int)(palmPositionX/speed), Display.locY);
			}
			else if (palmPositionX < 0 && Display.locX > 10){
				System.out.println("left");
				Display.updateLocation(Display.locX + (int)(palmPositionX/speed) , Display.locY);
			}
			
			if (palmPositionZ < 0 && Display.locY > 0)
			{
				System.out.println("u");
				Display.updateLocation(Display.locX , Display.locY + (int)(palmPositionZ/speed));
			}
			else if (palmPositionZ > 0 && Display.locY < 600){
				System.out.println("d");
				Display.updateLocation(Display.locX , Display.locY + (int)(palmPositionZ/speed) );
			}
			System.out.println(palmPositionZ);
			
		}

	}
}

class Sample {
	public static void main(String[] args) {
		Display display = new Display();
		// Create a sample listener and controller
		SampleListener listener = new SampleListener();
		Controller controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		System.out.println("Press Enter to quit...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// Remove the sample listener when done
		controller.removeListener(listener);
		
		
	}
}
