package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
	private Controller controller;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JTextPane htmlTextPane = new JTextPane();
	private JEditorPane plainTextPane = new JEditorPane();

	public View() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

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
		JMenuBar menuBar = new JMenuBar();
		MenuHelper.initFileMenu(this, menuBar);
		MenuHelper.initEditMenu(this, menuBar);
		MenuHelper.initStyleMenu(this, menuBar);
		MenuHelper.initAlignMenu(this, menuBar);
		MenuHelper.initColorMenu(this, menuBar);
		MenuHelper.initFontMenu(this, menuBar);
		MenuHelper.initHelpMenu(this, menuBar);

		this.getContentPane().add(menuBar, BorderLayout.NORTH);
	}

	public void initEditor() {
		htmlTextPane.setContentType("text/html");
		tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
		tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
		tabbedPane.setPreferredSize(getPreferredSize());
		tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
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

	public boolean canUndo() {
		return false;
	}

	public boolean canRedo() {
		return false;
	}
}
