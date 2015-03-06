package com.Vitalij;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JRootPane;

public abstract class FileOperations {
	private static final String saveFileLocation = "src/com/Vitalij/save.ser";
	private static Record r;
	
	static void save(MainFrame m) {
		try {
			r = new Record(m);
			System.out.println("Attempting to write to save file");
			FileOutputStream fout = new FileOutputStream(saveFileLocation);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(r);
			oos.close();
			System.out.println("Save file successfully written");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static void load(JRootPane rootPane) {
		try {
			FileInputStream fin = new FileInputStream(saveFileLocation);
			ObjectInputStream ois = new ObjectInputStream(fin);
			r = (Record) ois.readObject();
			ois.close();
			
			MainFrame frame = new MainFrame(r);
			frame.setSize(1200, 700);
			frame.setVisible(true);
			
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent ev) {
					rootPane.getTopLevelAncestor().setVisible(true);
				}
			});
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}