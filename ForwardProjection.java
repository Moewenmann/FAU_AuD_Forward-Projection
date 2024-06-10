import ij.ImagePlus;

public class ForwardProjection implements PlugInFilter {

	// return DOES_8G - specify plugin works w 8-bit grayscale img
	public int setup(String arg, ImagePlus imp) {
		return DOES_8G;
	}
}