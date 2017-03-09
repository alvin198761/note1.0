package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 复制 action
 * 
 * @author TANG
 * 
 */
public class CopyAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public CopyAction() {
		super("action.copy", "icon.copy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.copy();
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
