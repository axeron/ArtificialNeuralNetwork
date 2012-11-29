package uk.ac.aber.ans23.ArtificialNeuralNetwork;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		JPanel menu = new JPanel();
		this.add(p);
		
		menu.setBorder(BorderFactory.createEmptyBorder(20,5,10,5));
		GridLayout layout = new GridLayout(5,2,5,3);
		menu.setLayout(layout);
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		menu.add(fileMenu);
		menu.add(helpMenu);
		
		setJMenuBar(menubar);
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		open.setMnemonic('O');
		exit.setMnemonic('X');
		
		fileMenu.add(open);
		fileMenu.add(exit);
		
		open.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(getComponent(0));
			}
			
		});
		
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					System.exit(-1);
				}
			});
		
		//vel fra JFileChooser kan du bruke chooser.getFile(). Så da har du en File alt, så kan du bruke BufferedImage image = ImageIO.read(chooser.getFile())
		
	}
}
