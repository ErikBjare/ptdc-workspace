import se.lth.cs.ptdc.images.ImageFilter;

import java.awt.*;


public class GrayScaleFilter extends ImageFilter {
    protected Color[] greyScale = new Color[256];

    public GrayScaleFilter(String name) {
        super(name);
        for (int i=0; i<256; i++) greyScale[i] = new Color(i, i, i);
    }

    public Color[][] apply(Color[][] inPixels, double paramValue) {
        int height = inPixels.length;
        int width = inPixels[0].length;
        Color[][] outPixels = new Color[height][width];
        short[][] intensity = computeIntensity(inPixels);
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                outPixels[i][j] = greyScale[intensity[i][j]];
            }
        }
        return outPixels;
    }
}
