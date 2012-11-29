package uk.ac.aber.ans23.ArtificialNeuralNetwork;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class PixelAmountGrabber implements ImageObserver
{
	private Image img = null;
	private int amountOfPixels = 0;
	private int width;
	private int height;
	
	public PixelAmountGrabber()
	{

	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) 
	{
		return false;
	}
	
	public int amountOfPixels()
	{
		width = img.getWidth(this);
		height = img.getHeight(this);
		amountOfPixels = width * height;
		return amountOfPixels;//number of neurons needed for input layer, hidden layers and output layer.
	}
}
