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

			// exit img, w hide
			Thread.sleep(1000);
			rotatedImage.close();
		}
	}
}