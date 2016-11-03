package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
	private View view;

	public TextEditMenuListener(View view) {
		this.view = view;
	}

	@Override
	public void menuSelected(MenuEvent menuEvent) {
		JMenu selectedMenu = (JMenu) menuEvent.getSource();
		for (Component menuItem : selectedMenu.getMenuComponents())
			menuItem.setEnabled(view.isHtmlTabSelected());
	}

	@Override
	public void menuDeselected(MenuEvent menuEvent) {

	}

	@Override
	public void menuCanceled(MenuEvent menuEvent) {

	}
}
