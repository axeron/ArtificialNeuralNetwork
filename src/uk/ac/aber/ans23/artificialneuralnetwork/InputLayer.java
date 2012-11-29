package uk.ac.aber.ans23.ArtificialNeuralNetwork;

/**
 * InputLayer:
 * initially after the network has been created; we feed inputs into the inputLayer, this is done simply
 * by setting the outputs of the neurons in layer 1 to the input values we need to feed into it. In this project's
 * case; this will be the values from the already processed images. Each input will be a part of the image.
 * So if the image is 20x20 pixel, 400 neurons in the input layer will be needed.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 0.4
 * Developing mode
 */
public class InputLayer extends Layer{
	
	/**
	 * Constructor for the input layer.
	 */
	public InputLayer()
	{
		//TODO
	}
	
	/*public something initializeInputLayer()
	{
		i = 0;
	for each neuron in the inputLayer:
	neuron.outputValue = inputs(i); //input array
	i=i+1;
	next;
	}*/
}
