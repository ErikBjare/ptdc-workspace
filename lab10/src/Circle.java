import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public void draw(SimpleWindow w) {
        w.moveTo(x+radius, y);
        for(double d=0; d<Math.PI*2; d+=0.05) {
            w.lineTo((int)(x+radius*Math.cos(d)), (int)(y+radius*Math.sin(d)));
        }
    }

    @Override
    public boolean near(int xc, int yc) {
        if(radius > Math.sqrt(Math.pow(x-xc, 2)+Math.pow(y-yc, 2))) {
            return true;
        }
        return false;
    }
}
