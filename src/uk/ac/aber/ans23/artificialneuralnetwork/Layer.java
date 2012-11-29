package uk.ac.aber.ans23.ArtificialNeuralNetwork;
import java.util.ArrayList;

/**
 * This class will be the superclass for the other layers: input layer, hidden layer, output layer.
 * These classes will inherit the methods from this class, but as they are different, they will have methods of their own; thus the coice
 * of making this a super class.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 1.0
 * Developing phase.
 */
public abstract class Layer {
	ArrayList<Neuron> neurons = new ArrayList<Neuron>();

	/**
	 * Constructor for layers.
	 */
	public Layer()
	{
		
	}
	
	/**
	 * This method will add neurons to the layer. This will pretty much be the same for all the classes inheriting this
	 * class, even though the neurons will have slightly different features in the different layers.
	 * @param i allows me to parse through the int so I can add the dynamic input(number of pixels) 
	 * @param n allows me to add a Neuron every time this method is called.
	 */
	public void addNeurons(int i, Neuron n)
	{
		neurons.add(i, n);
	}

}
