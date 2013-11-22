import java.awt.*;


public class ContrastFilter extends GrayScaleFilter {
    public ContrastFilter(String name) {
        super(name);
    }

    @Override
    public Color[][] apply(Color[][] inPixels, double paramValue) {
        double cutOff = paramValue/100;

        int height = inPixels.length;
        int width = inPixels[0].length;
        int pixels = height*width;

        int[] histogram = new int[256];

        short[][] intensity = computeIntensity(inPixels);
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                histogram[intensity[i][j]] += 1;
            }
        }

        int[] cuts = computeCuts(histogram, cutOff, pixels);

        Color[][] outPixels = new Color[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int newIntensity = 255 * (intensity[i][j] - cuts[0]) / (cuts[1] - cuts[0]);
                if (newIntensity >= 0 && newIntensity <= 255) {
                    outPixels[i][j] = greyScale[newIntensity];
                } else if (newIntensity > 255) {
                    outPixels[i][j] = greyScale[255];
                } else if (newIntensity < 0) {
                    outPixels[i][j] = greyScale[0];
                }
            }
        }

        return outPixels;
    }

    private int[] computeCuts(int[] histogram, double cutOff, int pixels) {
        int[] histAccum = new int[256];
        histAccum[0] = histogram[0];
        histAccum[255] = pixels;

        int lowCut = 0;
        int highCut = 0;
        for (int i=1; i<255; i++) {
            histAccum[i] = histAccum[i-1] + histogram[i];
            if (histAccum[i] >= pixels*cutOff) {
                lowCut = i;
                break;
            }
        }
        for (int i=254; i>0; i--) {
            histAccum[i] = histAccum[i+1] - histogram[i];
            if (histAccum[i] <= pixels*(1-cutOff)) {
                highCut = i;
                break;
            }
        }

        return new int[] {lowCut, highCut};
    }
}
