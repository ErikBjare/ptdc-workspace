import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

import java.util.ArrayList;

public class ShapeList extends ArrayList<Shape> {
	/**
	 * Skapar en tom lista.
	 */
	public ShapeList() {
		super();
	}

	/**
	 * Lägger in en figur i listan.
	 * 
	 * @param s
	 *            figuren som ska läggas in i listan
	 */
	public void insert(Shape s) {
		add(s);
	}

	/**
	 * Ritar upp figurerna i listan.
	 * 
	 * @param w
	 *            fönstret där figurerna ritas
	 */
	public void draw(SimpleWindow w) {
		for(Shape s : this) {
            s.draw(w);
        }
	}

	/**
	 * Tar reda på en figur som ligger nära punkten xc,yc. Om flera figurer
	 * ligger nära så returneras den första som hittas, om ingen figur ligger
	 * nära returneras null.
	 * 
	 * @param xc
	 *            x-koordinaten
	 * @param yc
	 *            y-koordinaten
	 */
	public Shape findHit(int xc, int yc) {
        for(Shape s : this) {
            if(s.near(xc, yc)) {
                return s;
            }
        }
        return null;
	}
}
