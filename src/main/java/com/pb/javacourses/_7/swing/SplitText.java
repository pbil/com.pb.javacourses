package com.pb.javacourses._7.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

/*from w  ww.j ava  2  s  . co m*/
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class SplitText extends JFrame {

	static String sometext = "This is a test from java2s.com.";

	public SplitText() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JTextArea jt1 = new JTextArea(sometext);
		JTextArea jt2 = new JTextArea(sometext);
		JScrollPane sc2 = new JScrollPane(jt2);
		// Make sure our text boxes do line wrapping and have reasonable
		// minimum sizes.
		jt1.setLineWrap(true);
		jt2.setLineWrap(true);
//		jt1.setMinimumSize(new Dimension(150, 150));
//		jt2.setMinimumSize(new Dimension(150, 150));
//		jt1.setPreferredSize(new Dimension(250, 200));
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jt1, sc2);
		setSize(450, 800);
		add(sp, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		SplitText ssb = new SplitText();
		ssb.setVisible(true);
	}
}