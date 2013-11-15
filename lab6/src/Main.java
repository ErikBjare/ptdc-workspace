import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter maze ID: ");
        Scanner scan = new Scanner(System.in);
        int mazeID = scan.nextInt();
        SimpleWindow w = new SimpleWindow(500, 500, "Maze");
        Maze m = new Maze(mazeID);
        MazeTurtle mt = new MazeTurtle(w, m);

        m.draw(w);
        mt.walk();
    }
}

class MazeTurtle extends Turtle {
    Maze maze;

    public MazeTurtle(SimpleWindow w, Maze m) {
        super(w, m.getXEntry(), m.getYEntry());
        this.maze = m;
    }

    public void walk() {
        penDown();

        Random random = new Random();

        while (!maze.atExit(getX(), getY())) {
            if (!wallAtLeft()) {
                left(90);
            } else if (!wallInFront()) {
            } else if (!wallAtRight()) {
                left(-90);
            } else {
                left(180);
            }
            forward(1);
        }

        System.out.println("Maze completed!");
    }

    public boolean wallInFront() {
        return (maze.wallInFront(getDirection(), getX(), getY()) ? true : false);
    }

    public boolean wallAtLeft() {
        return (maze.wallAtLeft(getDirection(), getX(), getY()) ? true : false);
    }

    public boolean wallAtRight() {
        return (maze.wallAtLeft(getDirection()-180, getX(), getY()) ? true : false);
    }

}