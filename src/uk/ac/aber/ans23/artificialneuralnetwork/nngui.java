package uk.ac.aber.ans23.ArtificialNeuralNetwork;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is just for creating a GUI, making the programme easier to use.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 1.0
 * Developing phase.
 */
public class NNGUI extends JFrame
{

	public NNGUI()
	{
		setTitle("Artificial Neural Network for Planetary Exploration");
		setSize(750,500);
		setLocation(50, 100);
		JPanel p = new JPanel();
		this.add(p);
	}
	
	

}
