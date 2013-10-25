import javax.swing.*;

import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Editor");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textbox = new JTextArea();
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem search= new JMenuItem("Search");

		JMenuItem load = new JMenuItem("Load");
		
		JMenuItem save = new JMenuItem("Save");
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener( ) {
		      public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		      }   
		    }); 
		
		JMenu edit = new JMenu("Edit");
		
		JMenuItem copy = new JMenuItem("Copy");
		
		JMenuItem cut = new JMenuItem("Cut");
		
		JMenuItem paste = new JMenuItem("Paste");
		
		JMenuItem undo = new JMenuItem("Undo");
		
		JMenuItem redo = new JMenuItem("Redo");		
		
		//Launch everything
		file.add(search);
		file.add(load);
		file.add(save);
		file.add(exit);
		menubar.add(file);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(undo);
		edit.add(redo);
		menubar.add(edit);
		frame.add(textbox);
		frame.setSize(300,200);
		frame.setJMenuBar(menubar);
		frame.setVisible(true);
		
		
	}

}
