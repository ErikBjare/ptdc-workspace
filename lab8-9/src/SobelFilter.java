import se.lth.cs.ptdc.images.ImageFilter;

import java.awt.*;

public class SobelFilter extends ImageFilter {

    private static short[][] SOBEL_X_KERNEL = {{-1, 0, 1},
                                               {-2, 0, 2},
                                               {-1, 0, 1}};

    private static short[][] SOBEL_Y_KERNEL = {{-1,-2,-1},
                                               { 0, 0, 0},
                                               { 1, 2, 1}};

    public SobelFilter(String name) {
        super(name);
    }

    public Color[][] apply(Color[][] inPixels, double paramValue) {
        int width = inPixels.length;
        int height = inPixels[0].length;

        int weight = 1;

        short[][] intensity = computeIntensity(inPixels);
        Color[][] outPixels = inPixels.clone();

        for (int i=1; i<width-1; i++) {
            for (int j=1; j<height-1; j++) {
                int sx = convolve(intensity, i, j, SOBEL_X_KERNEL, 1);
                int sy = convolve(intensity, i, j, SOBEL_Y_KERNEL, 1);
                int contour = Math.abs(sx) + Math.abs(sy);

                Color c;
                if (contour > paramValue) {
                    c = Color.black;
                } else {
                    c = Color.white;
                }
                outPixels[i][j] = c;
            }
        }

        return outPixels;
    }
}
