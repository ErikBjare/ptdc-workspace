import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Square extends Shape {
    private int side;

    public Square(int x, int y, int side) {
        super(x, y);
        this.side = side;
    }

    public void draw(SimpleWindow w) {
        w.moveTo(x,      y);
        w.lineTo(x+side, y);
        w.lineTo(x+side, y+side);
        w.lineTo(x,      y+side);
        w.lineTo(x,      y);
    }

    @Override
    public boolean near(int xc, int yc) {
        if(x < xc && xc < x+side && y < yc && yc < y+side) {
            return true;
        }
        return false;
    }
}
