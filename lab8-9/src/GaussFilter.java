import se.lth.cs.ptdc.images.ImageFilter;

import java.awt.*;


public class GaussFilter extends ImageFilter {

    private static short[][] GAUSS_KERNEL = {{0, 1, 0},
                                             {1, 4, 1},
                                             {0, 1, 0}};
    private static short GAUSS_WEIGHT = 8;

    public GaussFilter(String name) {
        super(name);
    }

    public Color[][] apply(Color[][] inPixels, double paramValue) {
        int width = inPixels.length;
        int height = inPixels[0].length;

        short[][] red = new short[width][height];
        short[][] green = new short[width][height];
        short[][] blue = new short[width][height];

        Color[][] outPixels = inPixels.clone();

        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                red[i][j] = (short)inPixels[i][j].getRed();
                green[i][j] = (short)inPixels[i][j].getGreen();
                blue[i][j] = (short)inPixels[i][j].getBlue();
            }
        }

        for (int i=1; i<width-1; i++) {
            for (int j=1; j<height-1; j++) {
                Color c = new Color(convolve(red,   i, j, GAUSS_KERNEL, GAUSS_WEIGHT),
                                    convolve(green, i, j, GAUSS_KERNEL, GAUSS_WEIGHT),
                                    convolve(blue,  i, j, GAUSS_KERNEL, GAUSS_WEIGHT));
                outPixels[i][j] = c;
            }
        }

        return outPixels;
    }
}
