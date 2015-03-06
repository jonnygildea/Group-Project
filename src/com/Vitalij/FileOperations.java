package com.Vitalij;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public abstract class FileOperations extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String saveLocation = "src/com/Vitalij/save.ser";
	
	static void save(MainFrame m) {
		Record r;
		// code for writing file follows
		
		try {
			r = new Record(m);
			System.out.println("Before trying to write object");
			FileOutputStream fout = new FileOutputStream(saveLocation);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(r);
			oos.close();
			System.out.println("Done");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static void load(JRootPane rootPane) {
		Record r;
		
		try {
			FileInputStream fin = new FileInputStream(saveLocation);
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
			//return null;
		}
	}
}