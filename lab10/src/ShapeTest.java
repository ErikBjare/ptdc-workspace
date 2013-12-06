import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.shapes.ShapeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		ShapeList shapes = new ShapeList();
        File f = new File("/home/erb/Programming/Java/ptdc-workspace/lab10/shapedata.txt");
        try {
            Scanner scan = new Scanner(f);

            while(scan.hasNext()) {
                String str = scan.next();
                int x = scan.nextInt();
                int y = scan.nextInt();
                int s = scan.nextInt();
                if(str.equals("S")) {
                    shapes.insert(new Square(x, y, s));
                } else if(str.equals("T")) {
                    shapes.insert(new Triangle(x, y, s));
                } else if(str.equals("C")) {
                    shapes.insert(new Circle(x, y, s));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            shapes.insert(new Square(100, 300, 100));
            shapes.insert(new Triangle(400, 200, 100));
            shapes.insert(new Circle(400, 400, 50));
            shapes.insert(new Square(450, 450, 50));
            shapes.insert(new Square(200, 200, 35));
        }

        shapes.draw(w);

        CommandDispatcher cmd = new CommandDispatcher(w, shapes);
        cmd.mainLoop();
	}
}
