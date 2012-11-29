package uk.ac.aber.ans23.ArtificialNeuralNetwork;

public class NeuronConnections {

	double weight = 0;
	double previousDeltaWeight = 0; // for momentum
	double deltaWeight = 0;
	final Neuron leftNeuron;
	final Neuron rightNeuron;
	static int counter = 0;
	final public int id; // auto increment, starts at 0

	public NeuronConnections(Neuron outputFromNeuron, Neuron toNeuron) 
	{
		leftNeuron = outputFromNeuron;
		rightNeuron = toNeuron;
		id = counter;
		counter++;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double w) {
		weight = w;
	}

	public void setDeltaWeight(double w) {
		previousDeltaWeight = deltaWeight;
		deltaWeight = w;
	}

	public double getPrevDeltaWeight() {
		return previousDeltaWeight;
	}

	public Neuron getFromNeuron() {
		return leftNeuron;
	}

	public Neuron getToNeuron() {
		return rightNeuron;
	}

}
