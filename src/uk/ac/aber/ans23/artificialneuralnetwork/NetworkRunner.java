package uk.ac.aber.ans23.ArtificialNeuralNetwork;

/**
 * This class will be responsible for running the programme. Creating a new network etc.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 1.0
 * Developing phase.
 */
public class NetworkRunner 
{
	static int maxEpochs; //maximum number of cycles.
	static double minErrorCondition; //Minimum error required for the network to consider the trainign to be completed. 
	
	/**
	 * Runs the programme.
	 * @param args
	 */
	public static void main(String[] args)
	{
		NNGUI nngui = new NNGUI();
		maxEpochs = 1000000; // maximum number of cycles the neural network can run. 
		minErrorCondition = 0.001; //Minimum error that has to be achieved for the training to be successful.
		Network N = new Network();
		N.run(maxEpochs, minErrorCondition);
	}

}
