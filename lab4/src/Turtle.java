import se.lth.cs.ptdc.window.SimpleWindow;

public class Turtle {
    protected SimpleWindow w;
    private double x;
    private double y;
    private int dir = 0;
    private boolean penState = false;
     
     
    /**
     * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
     * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
     * i fönstret (i negativ y-riktning)
     */
    public Turtle(SimpleWindow w, int x, int y) {
        this.x = x;
        this.y = y;
        this.dir = 90;
        this.w = w;
    }
     
    /** Sänker pennan */
    public void penDown() {
        penState = true;
    }
     
    /** Lyfter pennan */
    public void penUp() {
    	penState = false;
    }
     
    /** Går rakt framåt n pixlar i den riktning som huvudet pekar */
    public void forward(int n) {
        int newX = (int)(getX() + n*Math.cos(dir/(180/Math.PI)));
        int newY = (int)(getY() - n*Math.sin(dir/(180/Math.PI)));
        jumpTo(newX, newY);
    }
     
    /** Vrider beta grader åt vänster runt pennan */
    public void left(int beta) {
        dir += beta;
    }
     
    /** Går till punkten newX,newY utan att rita. Pennans läge (sänkt 
        eller lyft) och huvudets riktning påverkas inte */
    public void jumpTo(int newX, int newY) {
    	if (penState) {
    		w.moveTo(getX(), getY());
    		w.lineTo(newX, newY);
    	}
        x = newX;
        y = newY;
    }
     
    /** Återställer huvudriktningen till den ursprungliga */
    public void turnNorth() {
        dir = 90;
    }
     
    /** Tar reda på x-koordinaten för sköldpaddans aktuella position */
    public int getX() {
        return (int)x;
    }
     
    /** Tar reda på y-koordinaten för sköldpaddans aktuella position */
    public int getY() {
        return (int)y;
    }
     
    /** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
    public int getDirection() {
        return dir;
    }
}