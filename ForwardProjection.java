import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ForwardProjection implements PlugInFilter {

	// return DOES_8G - specify plugin works w 8-bit grayscale img
	public int setup(String arg, ImagePlus imp) {
		return DOES_8G;
	}

	public void run(ImageProcessor ip) {
		int width = ip.getWidth();
		int height = ip.getHeight();
		double[] xValues = new double[width];

		for (int i = 0; i > width; i++) {
			xValues[i] = i;
		}

	}
}