package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {
	public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.addActionListener(actionListener);
		parent.add(menuItem);
		return menuItem;
	}

	public static JMenuItem addMenuItem(JMenu parent, Action action) {
		JMenuItem menuItem = new JMenuItem(action);
		parent.add(menuItem);
		return menuItem;
	}

	public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
		JMenuItem menuItem = addMenuItem(parent, action);
		menuItem.setText(text);
		return menuItem;
	}

	public static void initHelpMenu(View view, JMenuBar menuBar) {}

	public static void initFontMenu(View view, JMenuBar menuBar) {}

	public static void initColorMenu(View view, JMenuBar menuBar) {}

	public static void initAlignMenu(View view, JMenuBar menuBar) {}

	public static void initStyleMenu(View view, JMenuBar menuBar) {}

	public static void initEditMenu(View view, JMenuBar menuBar) {}

	public static void initFileMenu(View view, JMenuBar menuBar) {}
}
