package com.Vitalij;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

public class FileOperations {
	static void save(MainFrame m) {
		Record r;
		// code for writing file follows
		
		try {
			r = new Record(m);
			System.out.println("Before trying to write object");
			FileOutputStream fout = new FileOutputStream("src/com/Vitalij/save.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(r);
			oos.close();
			System.out.println("Done");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static void load() {
		Record r;
		
		try {
			FileInputStream fin = new FileInputStream("src/com/Vitalij/save.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			r = (Record) ois.readObject();
			ois.close();
			
			MainFrame frame = new MainFrame(r);
			
			//////////////////////////////////////////
			frame.setSize(1200, 700);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			//return null;
		}
	}
}