package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Panel;
import trains.TrainPanel;

public class Main extends JFrame {
	private static final long serialVersionUID = -8301129972275226789L;
	private Dimension dimension;
	private TrainPanel topLeft;
	private JPanel topRight, bottomLeft, bottomRight;

	private Main() {
		this.dimension = new Dimension(1000, 1000);
		this.topLeft = new TrainPanel(new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 2));
		this.topRight = new Panel(dimension, Color.BLUE);
		this.bottomLeft = new Panel(dimension, Color.RED);
		this.bottomRight = new Panel(dimension, Color.YELLOW);

		this.setTitle("Smart Mirror");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(dimension);
		this.setLayout(new GridLayout(2, 2, 0, 0));

		this.add(topLeft);
		this.add(topRight);
		this.add(bottomLeft);
		this.add(bottomRight);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
