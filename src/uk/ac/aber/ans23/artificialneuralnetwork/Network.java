package uk.ac.aber.ans23.ArtificialNeuralNetwork;


import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.Scanner;

import org.omg.CORBA.BAD_PARAM;

/**
 * This class will be responsible for adding all the layers, and adding the neurons to the layers. 
 * It will be responsible for the methods for loading images, saving outputs etc.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 1.0
 * Developing phase.
 */
public class Network 
{
	private PixelAmountGrabber pix;
	//private Scanner in;
	private double learningRate;
	private double momentum;

	final double epsilon = 0.00000000001;

	//ArrayList<Neuron> numberOfNeurons = new ArrayList<Neuron>(); 
	final int[] inputs; //TODO needs to take in the number of pixels in the image to be looked at.
	final double expectedOutputs[][] = { { }, { }, { }, { } }; //TODO don't think I will know the expected outputs.
	double resultOutputs[][] = { { }, { }, { }, { } };  //TODO pretty sure this isn't needed
	double output[];

	final Neuron bias = new Neuron();
	final ArrayList<Neuron> inputLayer = new ArrayList<Neuron>(); //TODO maybe this replaces the need for entire classes for the layers classes? investigate
	final ArrayList<Neuron> hiddenLayer = new ArrayList<Neuron>();
	final ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();

	final HashMap<String, Double> weightUpdate = new HashMap<String, Double>();


	/**
	 * Constructor for the network, parses in how many neurons needed.
	 * @param input
	 * @param hidden
	 * @param hidden2
	 * @param output
	 */
	public Network()
	{
		inputs = new int[pix.amountOfPixels()];
	}

	/**
	 * Load method will be the method used to load a new image into the network.
	 * @param FilePath
	 */
	public void load(String filePath) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	} 

	/**
	 * Create the network, adds the layers, adds the neurons.
	 */
	public void createNetwork()
	{
		//TODO not sure if needed anymore.
	}

	/**
	 * This method controls the network during training. And applies the error back propagation during run-time.
	 * @param maxSteps
	 * @param minError
	 */
	public void run(int maxSteps, double minError) 
	{
		int i;
		// Train neural network until minError reached or maxSteps exceeded
		double error = 1;
		for (i = 0; i < maxSteps && error > minError; i++) 
		{
			error = 0;
			for (int p = 0; p < inputs.length; p++) 
			{
				setInput(inputs);
				activate();
				output = getOutput();
				resultOutputs[p] = output;
				for (int j = 0; j < expectedOutputs[p].length; j++) 
				{
					double err = Math.pow(output[j] - expectedOutputs[p][j], 2);
					error += err;
				}
				applyBackpropagation(expectedOutputs[p]);
			}
		}

		//printResult();
		//System.out.println("Sum of squared errors = " + error);

		System.out.println("##### EPOCH " + i+"\n");

		if (i == maxSteps) 
		{

			System.out.println("!Error training try again");
		} else 
		{
			//printAllWeights();
			//printWeightUpdate();
		}
	}

	/**
	 * Used to calculate the output for all the neurons in the hidden layers and output layers.
	 */
	public void activate()
	{
		for (Neuron n : hiddenLayer)
		{
			n.calculateOutput();
		}

		for (Neuron n : outputLayer)
		{
			n.calculateOutput();
		}
	}

	/**
	 * This method gets the output and puts it in an array.
	 * @return
	 */
	public double[] getOutput() 
	{

		double[] outputs = new double[outputLayer.size()];

		for (int i = 0; i < outputLayer.size(); i++)
			outputs[i] = outputLayer.get(i).getOutput();
		return outputs;
	}

	/**
	 * Method to set the input in the input layer. //TODO this method needs to be dynamic and decide how many neurons are needed based on number of pixels.
	 * @param inputs
	 */
	public void setInput(int inputs[]) 
	{
		for (int i = 0; i < inputLayer.size(); i++) 
		{
			inputLayer.get(i).setOutput(inputs[i]);
		}
	}

	/**
	 * The most important method in the entire network, the error back propagation. 
	 * @param expectedOutput
	 */
	public void applyBackpropagation(double expectedOutput[]) 
	{
		// error check, normalize value ]0;1[
		for (int i = 0; i < expectedOutput.length; i++) 
		{
			double d = expectedOutput[i];
			if (d < 0 || d > 1) 
			{
				if (d < 0)
					expectedOutput[i] = 0 + epsilon;
				else
					expectedOutput[i] = 1 - epsilon;
			}
		}


		int i = 0;
		for (Neuron n : outputLayer) 
		{
			ArrayList<NeuronConnections> connections = n.getAllInConnections();
			for (NeuronConnections ncons : connections) 
			{
				double ak = n.getOutput();
				double ai = ncons.leftNeuron.getOutput();
				double desiredOutput = expectedOutput[i];
				double partialDerivative = -ak * (1 - ak) * ai * (desiredOutput - ak);
				double deltaWeight = -learningRate * partialDerivative;
				double newWeight = ncons.getWeight() + deltaWeight;
				ncons.setDeltaWeight(deltaWeight);
				ncons.setWeight(newWeight + momentum * ncons.getPrevDeltaWeight());
			}
			i++;
		}
		// update weights for the hidden layer
		for (Neuron n : hiddenLayer)
		{
			ArrayList<NeuronConnections> connections = n.getAllInConnections();
			for (NeuronConnections ncons : connections) 
			{
				double aj = n.getOutput();
				double ai = ncons.leftNeuron.getOutput();
				double sumKoutputs = 0;
				int j = 0;

				for (Neuron out_neu : outputLayer)
				{
					double wjk = out_neu.getConnection(n.id).getWeight();
					double desiredOutput = (double) expectedOutput[j];
					double ak = out_neu.getOutput();
					j++;
					sumKoutputs = sumKoutputs + (-(desiredOutput - ak) * ak * (1 - ak) * wjk);
				}
				double partialDerivative = aj * (1 - aj) * ai * sumKoutputs;
				double deltaWeight = -learningRate * partialDerivative;
				double newWeight = ncons.getWeight() + deltaWeight;
				ncons.setDeltaWeight(deltaWeight);
				ncons.setWeight(newWeight + momentum * ncons.getPrevDeltaWeight());
			}
		}
	}

}
