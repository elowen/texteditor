import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;


public class Edit {
	JMenu edit;
	public Edit(JMenu edit){
		this.edit=edit;
	}

	public void copy(final JTextArea textbox){
		JMenuItem copy = new JMenuItem("Copy");
		copy.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				textbox.copy();
			}   
		}); 
		edit.add(copy);
	}

	public void paste(final JTextArea textbox){
		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				textbox.paste();
			}   
		}); 
		edit.add(paste);
	}
	public void cut(final JTextArea textbox){
		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				textbox.cut();
			}   
		});
		edit.add(cut);
	}

	public void find(final JFrame frame,final JTextArea textbox){
		JMenuItem find = new JMenuItem("Find");
		final Highlighter hilite = new DefaultHighlighter();
		final Highlighter.HighlightPainter paint = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
		textbox.setHighlighter(hilite);
		find.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				
				String question = JOptionPane.showInputDialog("Search:");
				int place=0;

				while(textbox.getText().indexOf(question, place)!=-1)
				{
					place = textbox.getText().indexOf(question, place);
					try{hilite.addHighlight(place, (place+question.length()), paint);
					System.out.println("FOUND");}catch(Exception e2){e2.printStackTrace();}
					//textbox.select(place, (place+question.length()));
					place+=question.length();
				}
				
				JOptionPane.showMessageDialog(null, "Search Complete");{
					hilite.removeAllHighlights();
				}
			}   

			
		}); 
		edit.add(find);
	}

	public void undo(final UndoManager manager){
		JMenuItem undo = new JMenuItem("Undo");
		undo.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if(manager.canUndo())
				manager.undo();
			}   
		}); 
		edit.add(undo);
	}

	public void redo(final UndoManager manager){
		JMenuItem redo = new JMenuItem("Redo");
		redo.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				if(manager.canRedo())
				manager.redo();
			}   
		}); 
		edit.add(redo);
	}


}
