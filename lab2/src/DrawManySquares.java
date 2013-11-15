import java.util.Scanner;
import se.lth.cs.ptdc.square.Square;
import se.lth.cs.ptdc.window.SimpleWindow;

public class DrawManySquares {
	public static void main(String[] args) {
		System.out.println("Skriv förminskning, rotation");
		Scanner scan = new Scanner(System.in);
		int dim = scan.nextInt();
		int rot = scan.nextInt();
		
		SimpleWindow w = new SimpleWindow(600, 600, "DrawManySquares");
		Square sq = new Square(300, 300, 200);

		while (true) {
			while (sq.getSide() > 0) {
				SimpleWindow.delay(50);
				w.clear();
				sq.draw(w);
				sq.setSide(sq.getSide() - dim);
				sq.rotate(rot);
			}
			while (sq.getSide() < 200) {
				SimpleWindow.delay(50);
				w.clear();
				sq.draw(w);
				sq.setSide(sq.getSide() + dim);
				sq.rotate(rot);
			}
		}
	}
}
