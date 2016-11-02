package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
	private Controller controller;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JTextPane htmlTextPane = new JTextPane();
	private JEditorPane plainTextPane = new JEditorPane();

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void init() {
		initGui();
		FrameListener frameListener = new FrameListener(this);
		this.addWindowListener(frameListener);
		setVisible(true);
	}

	public void initMenuBar() {
	}

	public void initEditor() {
	}

	public void initGui() {
		initMenuBar();
		initEditor();
		pack();
	}

	public void exit() {
		controller.exit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void selectedTabChanged() {

	}
}
