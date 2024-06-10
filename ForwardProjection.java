import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.plugin.filter.PlugInFilter;
import ij.gui.Plot;

public class ForwardProjection implements PlugInFilter {

	// return DOES_8G - specify plugin works w 8-bit grayscale img
	@Override
	public int setup(String arg, ImagePlus imp) {
		return DOES_8G;
	}

	@Override
	public void run(ImageProcessor ip) {
		int width = ip.getWidth();
		int height = ip.getHeight();
		double[] xValues = new double[width];

		// loop xVal
		for (int i = 0; i < width; i++) {
			xValues[i] = i;
		}

		// loop img rot
		for (int angle = 0; angle < 180; angle += 10) {
			ImageProcessor rotatedIp = ip.duplicate();
			rotatedIp.setInterpolationMethod(ImageProcessor.BILINEAR);
			rotatedIp = rotatedIp.rotate(angle);

			// img rot
			ImagePlus rotatedImage = new ImagePlus("Rot img at " + angle + " ... ", rotatedIp);
			rotatedImage.show();

			// ploting proj
			double[] proj = new double[width];
			for (int x = 0; x < width; x++) {
				double s = 0;
				for (int y = 0; y < height; y++) {
					s += rotatedIp.getPixelValue(x, y);
				}
				proj[x] = s;
			}
			Plot plot = new Plot("Proj at " + angle + " deg.", "X", "Proj", xValues, proj);
			plot.show();

			// exit img, w hide
			Thread.sleep(1000);
			rotatedImage.close();
			plot.close();
		}
	}
}