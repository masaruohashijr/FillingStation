package com.vindixit.station.service;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
/**
 * Class responsible to show the report and the resume of the whole processing.
 * @author Logus
 *
 */
public class ShowDetails extends JFrame {
	private static ShowDetails instance = null;

	public static ShowDetails getInstance() {
		if (instance == null) {
			instance = new ShowDetails();
		}
		return instance;
	}
	/**
	 * Method used to show an input dialog with a textarea containing a report.
	 * @param title
	 * @param defaultText
	 * @return
	 */
	public String showInputDialog(String title, String defaultText) {
		JTextArea msg = new JTextArea(defaultText);
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(msg);
		scrollPane.setPreferredSize(new Dimension(600, 320));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		int ris = JOptionPane.showConfirmDialog(null, scrollPane, title, JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (ris == JOptionPane.OK_OPTION)
			return msg.getText();
		else
			return defaultText;
	}
}