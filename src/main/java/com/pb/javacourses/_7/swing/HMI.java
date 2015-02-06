package com.pb.javacourses._7.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class HMI extends JFrame {

	private JPanel map;
	private LeftMenu leftMenu;
	private JSplitPane split;

	public HMI(String title) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			System.out.println("Look and feel does not exist");
		}

		map = new JPanel();
		leftMenu = new LeftMenu();
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftMenu, map);
		setLayout(new BorderLayout());

		add(split, BorderLayout.CENTER);
		split.setOneTouchExpandable(true);
		split.setBorder(BorderFactory.createEmptyBorder());

//		setSize(1024, 768);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// NESTED
	public class LeftMenu extends JTabbedPane {
		TabLogg logg;

		public LeftMenu() {
			logg = new TabLogg();
			addTab("Logg", null, logg, "Visar loggar av information f�r kartan");
		}
	}

	// NESTED
	public class TabLogg extends JPanel {

		private JButton reset = new JButton("Clear logg");
		private TitledBorder border = BorderFactory.createTitledBorder("Logg");
		private JTextArea text = new JTextArea();

		public TabLogg() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			text.setLineWrap(true);
			text.setEditable(false);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			reset.setAlignmentX(Component.RIGHT_ALIGNMENT);
			add(text);
			add(reset);
			text.setText("testststg sd sdgs gsdg sd gs gsdgsdg");
		}
	}

	public static void main(String[] arg) {
		HMI human = new HMI("V�ltnavigeringssystem Interface - Ny");
	}
}