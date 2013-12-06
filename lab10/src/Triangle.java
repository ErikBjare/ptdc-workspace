import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Triangle extends Shape {
    private int side;

    public Triangle(int x, int y, int side) {
        super(x, y);
        this.side = side;
    }

    public void draw(SimpleWindow w) {
        double d1 = Math.toRadians(-90);
        double d2 = Math.toRadians(-210);
        double d3 = Math.toRadians(30);

        w.moveTo((int)(x+side*Math.cos(d1)),   (int)(y+side*Math.sin(d1)));
        w.lineTo((int)(x+side*Math.cos(d2)),   (int)(y+side*Math.sin(d2)));
        w.lineTo((int)(x+side*Math.cos(d3)),   (int)(y+side*Math.sin(d3)));
        w.lineTo((int)(x+side*Math.cos(d1)),   (int)(y+side*Math.sin(d1)));
    }

    @Override
    public boolean near(int xc, int yc) {
        if(Math.abs(x-xc) < side && Math.abs(y-yc) < side) {
            return true;
        }
        return false;
    }
}
