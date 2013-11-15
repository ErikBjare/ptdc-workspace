import se.lth.cs.ptdc.window.SimpleWindow;
import java.util.Random;
import java.lang.Math;
import java.awt.Color;

public class BlindConfusedTurtles {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "BCT");
		ColorTurtle t1 = new ColorTurtle(w, 250, 250, Color.RED);
		t1.penDown();
		ColorTurtle t2 = new ColorTurtle(w, 350, 350, Color.BLUE);
		t2.penDown();
		while (Math.hypot(t1.getX() - t2.getX(), t1.getY() - t2.getY()) > 50) {
			t1.walkRandom();
			t2.walkRandom();
			SimpleWindow.delay(10);
		}
		System.out.println("Done!");
	}
}