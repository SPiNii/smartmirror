package trains;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Fonts;

public class TrainPanel extends JPanel {
	private static final long serialVersionUID = -5295972689419036858L;
	private JPanel upperPanel, middlePanel;
	private TrainDatabase db;
	private TrainReader reader;
	private JLabel header;

	public void setupPanel(Dimension dim) {
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());

		this.upperPanel = new JPanel();
		this.upperPanel.setPreferredSize(new Dimension((int) dim.getHeight() / 4, (int) dim.getWidth()));

		this.middlePanel = new JPanel();
		this.middlePanel.setPreferredSize(new Dimension((int) dim.getHeight() / 3, (int) dim.getWidth()));
		this.middlePanel.setLayout(new GridLayout(5, 3));

		this.add(upperPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.SOUTH);
	}

	public TrainPanel(Dimension dim) {
		this.reader = new TrainReader();
		this.db = reader.getTrains();
		this.setupPanel(dim);

		header = new JLabel("Next trains from Rosenberg-, Seidenstraﬂe:");
		header.setFont(Fonts.getHeaderFont());
		header.setPreferredSize(upperPanel.getSize());
		upperPanel.add(header, BorderLayout.NORTH);
		header.setOpaque(true);
		header.setBackground(Color.GREEN);
		this.repaint();
	}
}
