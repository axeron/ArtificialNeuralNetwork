package uk.ac.aber.ans23.cannyedgedetector;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CannyEdgeRunner
{
	private static BufferedImage img = null;

	public void load() throws FileNotFoundException
	{
		try 
		{
			img = ImageIO.read(new File("/CannyEdgeDetector/src/uk/ac/aber/ans23/cannyedgedetector/images/190176_10150417228735618_6185388_n.jpg"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		CannyEdgeDetector detector = new CannyEdgeDetector();
		detector.setLowThreshold(0.5f);
		detector.setHighThreshold(1f);
		detector.setSourceImage(img);
		detector.process();
		BufferedImage edges = detector.getEdgesImage(); 
	}

}
