import se.lth.cs.ptdc.window.SimpleWindow;

import java.awt.Color;
import java.util.Random;


public class ColorTurtle extends Turtle {
	private Color color; 
	private final Random r;
	
	public ColorTurtle(SimpleWindow w, int x, int y, Color color) {
		super(w, x, y);
		r = new Random();
		this.color = color;
	}
	
	public void walkRandom() {
		forward(r.nextInt(10)+1);
		left(r.nextInt(360)-180);
	}
	
	public void forward(int n) {
		Color savedColor = w.getLineColor();
		w.setLineColor(color);
		super.forward(n);
		w.setLineColor(savedColor);
	}
}
