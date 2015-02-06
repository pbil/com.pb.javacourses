package com.pb.javacourses._7.swing;

import javax.swing.*;
import java.awt.event.*;

public class DialogWindows extends JFrame {

	public DialogWindows() {
		super("DialogWindows");
		// выход при закрытии
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// пара кнопок, вызывающих создание диалоговых окон
		JButton buttonl = new JButton("Обычное окно");
		buttonl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = createDialog("Немодальное", false);
				dialog.setVisible(true);
			}
		});
		JButton button2 = new JButton("Модальное окно");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = createDialog("Модальное", true);
				dialog.setVisible(true);
			}
		});
		// создаем панель содержимого и выводим окно на экран
		JPanel contents = new JPanel();
		contents.add(buttonl);
		contents.add(button2);
		setContentPane(contents);
		setSize(350, 100);
		setVisible(true);
	}

	// создает диалоговое окно
	private JDialog createDialog(String title, boolean modal) {
		JDialog dialog = new JDialog(this, title, modal);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dialog.setSize(200, 60);
		return dialog;
	}

	public static void main(String[] args) {
		new DialogWindows();
	}
}
