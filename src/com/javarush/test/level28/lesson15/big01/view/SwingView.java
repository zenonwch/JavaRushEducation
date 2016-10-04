package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SwingView implements View {
	private Controller controller;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru"));

	@Override
	public void update(List<Vacancy> vacancies) {
		try {
			updateContent(getUpdatedContent(vacancies));
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void userCitySelectEmulationMethod() {
		controller.onCitySelect("Odessa");
	}

	private JTable getUpdatedContent(List<Vacancy> vacancies) {
		Collections.sort(vacancies, new Comparator<Vacancy>() {
			public int compare(Vacancy o1, Vacancy o2) {
				if (o1.getDate() == null || o2.getDate() == null)
					return 0;
				return o2.getDate().compareTo(o1.getDate());
			}
		});

		final JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(0, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String columnNames[] = {"Title", "City", "Company Name", "Salary", "Date"};

		tableModel.setColumnIdentifiers(columnNames);
		table.setModel(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				Object title = table.getValueAt(row, col);
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						URI uri = new URI(((Vacancy) title).getUrl());
						desktop.browse(uri);
					}
					catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				Vacancy vac = (Vacancy) value;
				return new JLabel("<html><a href=\"" + vac.getUrl() + "\">" + vac.getTitle() + "</a>");
			}
		});

		MouseMotionAdapter mma = new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (table.columnAtPoint(e.getPoint()) == 0)
					table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				else table.setCursor(Cursor.getDefaultCursor());
			}
		};


		table.addMouseMotionListener(mma);

		try {
			for (final Vacancy vac : vacancies) {
				tableModel.addRow(new Object[]{
						vac,
						vac.getCity(),
						vac.getCompanyName(),
						vac.getSalary(),
						vac.getDate() == null ? "" : dateFormat.format(vac.getDate())
				});

			}
		}
		catch (Exception e) {
			System.out.println("Some exception occurred");
		}
		return table;
	}

	private void updateContent(JTable content) {
		JFrame f = new JFrame("Java Vacancies");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane(content);
		f.getContentPane().add(scrollPane, BorderLayout.CENTER);
		f.setSize(1200, 800);
		f.setVisible(true);
	}
}
