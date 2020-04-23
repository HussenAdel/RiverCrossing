package rivercrossing;


import com.sun.javafx.iio.ImageLoader;
import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class loadingImage extends Applet {
	
	public static BufferedImage loadImage (String path) {
	    try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
	    return null;
	}
}
