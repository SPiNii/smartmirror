package gui;

import java.awt.Font;

public class Fonts {
	private static Font headerFont;
	private static Font tableFont;

	public static Font getHeaderFont() {
		if (headerFont == null) {
			headerFont = new Font("Verdana", Font.PLAIN, 20);
		}
		return headerFont;
	}

	public static Font getTableFont(){
		if(tableFont == null){
			tableFont = new Font("Verdana", Font.PLAIN, 15);
		}
		return tableFont;
	}
}
