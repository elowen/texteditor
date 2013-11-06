import javax.swing.*;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;
import javax.swing.undo.*;

import java.awt.event.*;

public class Main {


	public static void main(String[] args) {

		final JFrame frame = new JFrame("Text Editor");
		final UndoManager manager = new UndoManager();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextArea textbox = new JTextArea();
		
		
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");

		File f =new File(file);
		f.exit();
		f.load(textbox,manager);
		f.save(textbox);

		JMenu edit = new JMenu("Edit");
		Edit e = new Edit(edit);
		e.copy(textbox);
		e.cut(textbox);
		e.paste(textbox);
		e.find(frame,textbox);
		e.undo(manager);
		e.redo(manager);
		textbox.getDocument().addUndoableEditListener(manager);
		frame.getContentPane().add(textbox);

		menubar.add(file);

		menubar.add(edit);
		//frame.add(textbox);
		frame.setSize(500,500);
		frame.setJMenuBar(menubar);
		frame.setVisible(true);


	}


}
