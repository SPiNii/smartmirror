package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel extends JPanel {
	public Panel(Dimension dim, Color color) {
		Dimension panelDim = new Dimension((int) dim.getWidth() / 2, (int) dim.getHeight() / 2);
		this.setPreferredSize(panelDim);
		this.setOpaque(true);
		this.setBackground(color);
	}
}
