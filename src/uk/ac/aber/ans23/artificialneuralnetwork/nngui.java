package uk.ac.aber.ans23.ArtificialNeuralNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * This class is just for creating a GUI, making the programme easier to use.
 * @author Andreas O'Brien Svingeseth (ans23@aber.ac.uk)
 * @version 1.0
 * Developing phase.
 */
public class NNGUI extends JFrame implements ActionListener
{

	public NNGUI()
	{
		setTitle("Artificial Neural Network for Planetary Exploration");
		setPreferredSize(new Dimension(750, 500));
		setLocation(50, 100);
		this.setLayout(new BorderLayout());
		
		JPanel imagePresenter = new JPanel();//
		this.add(imagePresenter, BorderLayout.CENTER);
		JTextPane textPresenter = new JTextPane();//for text 
		this.add(textPresenter, BorderLayout.PAGE_END);
		
		JMenu fileMenu = new JMenu("Open");
		JMenuItem open = new JMenuItem("Load");
		JMenuBar bar = new JMenuBar();
		bar.add(fileMenu);
		fileMenu.add(open);
		
		fileMenu.addActionListener(this);
			
		open.addActionListener(this); 
   	
		this.setJMenuBar(bar);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(getComponent(0));
		fc.getSelectedFile();
		try 
		{
			BufferedImage image = ImageIO.read(fc.getSelectedFile());
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
}
