package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 剪切 action
 * 
 * @author TANG
 * 
 */
public class CutAction extends SuperAction {

	public CutAction() {
		super("action.cut", "icon.cut");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.cut();
	}

	@Override
	public boolean isEnabled() {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JTextArea jta = frame.getEditorMain();
		String text = jta.getSelectedText();
		if (text == null || "".equals(text)) {
			return false;
		}
		return true;
	}

}
