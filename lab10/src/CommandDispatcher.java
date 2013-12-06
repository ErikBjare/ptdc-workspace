import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.shapes.ShapeList;


class CommandDispatcher {
    private SimpleWindow w;
    private ShapeList shapes;

    public CommandDispatcher(SimpleWindow w, ShapeList shapes) {
        this.w = w;
        this.shapes = shapes;
    }

    public void mainLoop() {
        while (true) {
            // användaren klickar på en figur
            // användaren klickar på en ny position
            // figuren flyttas till den nya positionen
            w.waitForMouseClick();
            int m_x = w.getMouseX();
            int m_y = w.getMouseY();

            Shape s = shapes.findHit(m_x, m_y);
            if(s != null) {
                w.waitForMouseClick();
                m_x = w.getMouseX();
                m_y = w.getMouseY();
                s.moveToAndDraw(w, m_x, m_y);
            }
        }
    }
}