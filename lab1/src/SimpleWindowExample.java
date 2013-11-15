import se.lth.cs.ptdc.window.SimpleWindow;
import java.lang.Math;
import java.awt.Color;

public class SimpleWindowExample {
	public static void main(String[] args){		
		SimpleWindow w = new SimpleWindow(500,500,"Blöh window");
		w.setLineWidth(2);
		Color pink = new Color(255,0,150);
		w.setLineColor(pink);

		while (true) {
			w.waitForMouseClick();
			Point p = new Point(w.getMouseY(), w.getMouseX());
			Circle c = new Circle(p, 100);
			drawCircle(w, c);
			System.out.println("X: " + p.x + "\tY: " + p.y);
		}
	}
	
	public static void drawCircle(SimpleWindow w, Circle c){
		w.moveTo(c.mid.y+100, c.mid.x);
		for(double d = 0; d<=(2*Math.PI); d += 0.001){
			w.lineTo((int)(c.mid.y+c.r*Math.cos(d)), (int)(c.mid.x+c.r*Math.sin(d)));
		}
	}
	
}

class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Circle {
	public int r;
	public Point mid;
	
	public Circle(Point mid, int r) {
		this.mid = mid;
		this.r = r;
	}
}