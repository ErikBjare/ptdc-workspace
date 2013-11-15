import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.square.Square;
import java.awt.Color;

public class PrintClicksDrawSquare {
	private static final boolean step = true;
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClicks");
		Square sq = new Square(300, 300, 50);
		sq.draw(w);
		while (true) {
			w.waitForEvent();
			switch (w.getEventType()) {
			case 1:
				// Mouse event
				int mx = w.getMouseX();
				int my = w.getMouseY();
				System.out.println("x = " + mx + ", " + "y = " + my);
				int dX = mx - sq.getX();
				int dY = my - sq.getY();
				for (int i = 0; i < 10; i++) {
					if (!step) sq.erase(w);
					sq.move(dX / 10, dY / 10);
					sq.draw(w);
				}
				break;
			case 2:
				// Key event
				if (w.getKey() == 'r') {
					w.setLineColor(Color.RED);
				} else {
					w.setLineColor(Color.BLACK);
				}
				break;
			}
		}
	}
}
