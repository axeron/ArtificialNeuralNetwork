package uk.ac.aber.ans23.ArtificialNeuralNetwork;

/**
 * This class is responsible for training the network. Will keep count of the number of epochs (cycles), as well as the training itself.
 * @author Andreas O'Brien Svingeseth (ans23@abe.ac.uk)
 * @version 1.0
 * Developing phase
 * @param <Bias>
 *
 */
public class TrainingClass {

	private double epoch;
	private double neuronValue;
	int input;
	int connectionweight;
	Neuron n;
	Network nw;
	private double bias;
	InputLayer il;
	HiddenLayer hl;

	/**
	 * Constructor for the training class.
	 */
	public TrainingClass()
	{
		
		neuronValue = 0;
		bias = n.bias;
	}
	

	

	
	//TransferUnit=
	//the transfer method is a simple method, it uses the neuronValue to generate an output. This output
	//is then propagated to the neuron in the next layer. 
	//sigmoid transfer function: will take the neuronValue and produce an output that is greater than 0 and less than 1.
	//output = 1/(1-Exp(-neuronValue);
	
	//Calculating the error or delta
	//errorCalculation
	//in this method, the error of the network can be stated as the difference between the expected output and the actual
	//output. e.g. the output from the outputLayer will most likely be wrong the first time, this is 
	//based on the random values assigned to the bias and connection weights of each neuron.
	
	//how to calculate the error of each neuron in all of the layers:
	//1. first we calculate the error of each neuron in the output layer.
	//2. the error value thus calculated will be used to calculate the error of the neurons in the previous layer.i.e. the hiddenLayer.
	//3. the error value of all neurons in the last hidden layer is used to calculate the error in the previous layer,
	// i.e, the second to last hidden layer.
	//4. this process is continued until we reach the fist hidden layer, error of the input layer is not calculated.
	
	//the general equation for finding the error-value of a neuron is
	//neuronError = neuronOutput*(1-neuronOutput)*errorFactor
	
	//the error factor of neurons in the output layer can be calculated directly, since we know the expected output of each neuron in
	//the output layer
	
	//for a neuron in the output layer
	//error factor of an output layer neuron = expectedOutput - neuron's actual output
	
	//for a neuron in the hidden layer, error factor calculation is somewhat different, to calculate the error factor of 
	//a neuron in the hidden layer:
	//	first the errorValue of each neuron to which the neuron is connected is multiplied with the weight if this connecting.
	//	these products are summed up together to obtain the error factor of a hidden layer-neuron.
	
	//to calculate the output of a neuron, we use the connected neurons in previous layers, along with the corresponding connection weights.#
	//calculating the error factor of a neuron in a hidden layer:
	//for each neuron N to which this neuron is connected "sum of all errorValue" * weight;
	//error factor = error factor + (neuron.ErrorValue * weight of connection from this.neuron to N)
	//next
	
	//error factor of neuron can easily be calculated
	//X1.errorValue = X1.output * (1 - X1.output) * errorFactor of X1
	
	//adjusting the weights and bias
	//after calculating the errorValue of all neurons in all of the layers, we can correct the bias with respect to the errorValue, 
	//to produce a more accurate output next time. connection weights and bias together are called free parameters, a neuron must update 
	//more than one number of weights - because there are weights associated with each connection to a neuron.
	
	//update free parameters of all neurons in a hidden layer:
	//for each layer in hiddenLayer:
	//	for each neuron in layer.neurons
	//		neuron.updateFreeParams();
	//	next
	//next
	public void updateFreeParams()
	{
		//for(Neuron n: )
		{
			
		}
	}
	
	//update free parameters for all neurons in the output layer
	//for each neuron in outputLayer.neurons;
	//	neuron.updateFreeparams();
	//next
	
	//updateFreeParams method simply does two things:
	//- find the new bias of a neuron, based on the errorValue we calculated earlier
	//- update the connection weights based on the errorValue we calculated earlier
	
	//new biasValue = old biasValue + learningRate * 1 * errorValue
	
	//the new weights associated with an input neuron can be calculated as:
	//new weight of N = old weight of N + learningRate * 1 * neuron.Output * errorValue
	
	//as a neuron can have more than 1 input, the above step should be performed for all neurons connected to this neuron
	//i.e.
	//for each inputNeuron N connected to this.neuron
	//	new weight of N = old weight of N + learningRate * 1 * neuron.output * this.neuron.errorValue;
	
	//updating the neuron:
		//first, neuronValue is calculated using the summationUnit, and then it's provided to the transfer function
		//to obtain the output of the neuron
		
		//neuronValue as single = bias;
		//for each inputLayer.neuron connected to this neuron:
		//	neuronValue = neuronValue + (weight associated with inputLayer.Neuron * neuronOutput;
		//next;
	public void updateNeuron()
	{
		neuronValue = bias;
		//for (Neuron N: )
		{
			neuronValue = neuronValue + (n.getOutput()); //TODO weight associated with inputLayer.Neuron * neuronOutput)
		}
	}
	
	/**
	 *SummationUnit=
	  input values x(i) of each input to the neuron is multiplied with the associated connection weight w(i). 
	  every neuron have a bias value, which is random to begin with, but as the network has been initiated,
	  the training class will change the bias based on the error-calculation method.
	  if x is the input, and w is the associated weight
	  protected neuronValue = 0;
	  for i = 0 .. neuronInputCounter-1
	  neuronValue = neuronValue+x(i)*w(i)
	 */
	public void summationUnit()
	{
	 n.g(0);
		{
			Neuron.counter = -1;
			neuronValue = neuronValue + input * connectionweight; //TODO
		}
	}
	
	
}
