package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
	private View view;
	private HTMLDocument document;
	private File currentFile;

	public Controller(View view) {
		this.view = view;
	}

	public HTMLDocument getDocument() {
		return document;
	}

	public void init() {
		createNewDocument();
	}

	public void exit() {
		System.exit(0);
	}

	public void resetDocument() {
		if (document != null)
			document.removeUndoableEditListener(view.getUndoListener());
		document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
		document.addUndoableEditListener(view.getUndoListener());
		view.update();
	}

	public void setPlainText(String text) {
		resetDocument();
		StringReader sr = new StringReader(text);
		try {
			new HTMLEditorKit().read(sr, document, 0);
		}
		catch (Exception e) {
			ExceptionHandler.log(e);
		}
	}

	public String getPlainText() {
		StringWriter sw = new StringWriter();
		try {
			new HTMLEditorKit().write(sw, document, 0, document.getLength());
		}
		catch (Exception e) {
			ExceptionHandler.log(e);
		}
		return sw.toString();
	}

	public void createNewDocument() {
		view.selectHtmlTab();
		resetDocument();
		view.setTitle("HTML редактор");
		view.resetUndo();
		currentFile = null;
	}

	public void openDocument() {
		view.selectHtmlTab();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new HTMLFileFilter());
		int retrival = fileChooser.showOpenDialog(view);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			currentFile = fileChooser.getSelectedFile();
			resetDocument();
			view.setTitle(currentFile.getName());
			try (FileReader fr = new FileReader(currentFile)) {
				new HTMLEditorKit().read(fr, document, 0);
			}
			catch (Exception e) {
				ExceptionHandler.log(e);
			}
			view.resetUndo();
		}
	}

	public void saveDocument() {
		view.selectHtmlTab();
		if (currentFile != null)
			try (FileWriter fw = new FileWriter(currentFile)) {
				new HTMLEditorKit().write(fw, document, 0, document.getLength());
			}
			catch (Exception e) {
				ExceptionHandler.log(e);
			}
		else
			saveDocumentAs();
	}

	public void saveDocumentAs() {
		view.selectHtmlTab();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new HTMLFileFilter());
		int retrival = fileChooser.showSaveDialog(view);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			currentFile = fileChooser.getSelectedFile();
			view.setTitle(currentFile.getName());
			try (FileWriter fw = new FileWriter(currentFile)) {
				new HTMLEditorKit().write(fw, document, 0, document.getLength());
			}
			catch (Exception e) {
				ExceptionHandler.log(e);
			}
		}
	}

	public static void main(String[] args) {
		View view = new View();
		Controller controller = new Controller(view);
		view.setController(controller);
		view.init();
		controller.init();
	}
}
