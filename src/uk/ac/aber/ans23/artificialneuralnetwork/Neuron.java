package uk.ac.aber.ans23.ArtificialNeuralNetwork;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 0.4
 * Developing mode.
 *
 */
public class Neuron {

	protected double input;
	protected double output;
	protected double outputValue;
	public int numberOfPix; //this will be the number of pixels in the image being processed
	static int counter = 0;
	final public int id;  // auto increment, starts at 0
	NeuronConnections biasConnection;
	final double bias = -1;
	ArrayList<NeuronConnections> Inconnections = new ArrayList<NeuronConnections>();
	HashMap<Integer,NeuronConnections> connectionLookup = new HashMap<Integer,NeuronConnections>();

	/**
	 * First constructor for the neuron class, allows me to create a neuron with a counter.
	 */
	public Neuron()
	{
		id = counter;
		counter++;
	}

	/**
	 * The second constructor, used to create a new neuron with the number of
	 * @param input
	 * @param outputValue
	 */
	public Neuron(double outputValue)
	{
		id = counter;
		//this.addInConnectionsS(null);
		//this.getAllInConnections();
		//this.g(this.sigmoidActivationFunction(input));
		outputValue = this.getOutput();
	}

	/**
	 * Method to calculate the total output from a neuron.
	 */
	public void calculateOutput()
	{
		double s = 0;
		for(NeuronConnections con : Inconnections)
		{
			Neuron leftNeuron = con.getFromNeuron();
			double weight = con.getWeight();
			double a = leftNeuron.getOutput(); //output from previous layer    
			s = s + (weight*a);
		}
		s = s + (biasConnection.getWeight()*bias);
		output = g(s);
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	double g(double x) 
	{
		return sigmoidActivationFunction(x);
	}

	/**
	 * Sigmoidal activation; used to make the outputvalue a decimal number.
	 * @param x
	 * @return
	 */
	double sigmoidActivationFunction(double x) 
	{
		return 1.0 / (1.0 +  (Math.exp(-x)));
	}

	/**
	 * Method to add all the connections into a neuron.
	 * @param inNeurons
	 */
	public void addInConnectionsS(ArrayList<Neuron> inNeurons)
	{
		for(Neuron n: inNeurons)
		{
			NeuronConnections neurcon = new NeuronConnections(n,this);
			Inconnections.add(neurcon);
			connectionLookup.put(n.id, neurcon);
		}
	}

	/**
	 * Method used to retrive what connection the neuron has.
	 */
	public NeuronConnections getConnection(int neuronIndex)
	{
		return connectionLookup.get(neuronIndex);
	}

	/**
	 * Used to add a single neuron connection.
	 * @param neurcon
	 */
	public void addInConnection(NeuronConnections neurcon)
	{
		Inconnections.add(neurcon);
	}

	/**
	 * Method used to add a a bias connection.
	 * @param n
	 */
	public void addBiasConnection(Neuron n)
	{
		NeuronConnections con = new NeuronConnections(n,this);
		biasConnection = con;
		Inconnections.add(con);
	}

	/**
	 * Method that allows the network to find all the connections that specific neuron has.
	 * @return
	 */
	public ArrayList<NeuronConnections> getAllInConnections()
	{
		return Inconnections;
	}

	/**
	 * Method used to get a bias value.
	 * @return
	 */
	public double getBias() 
	{
		return bias;
	}

	/**
	 * Method used to retrieve the output from a neuron.
	 * @return
	 */
	public double getOutput() 
	{
		return output;
	}

	/**
	 * Method used to set the output of a single neuron.
	 * @param o
	 */
	public void setOutput(double o)
	{
		output = o;
	}
}