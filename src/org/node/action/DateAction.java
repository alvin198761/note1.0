package org.node.action;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 日前 action
 * 
 * @author TANG
 * 
 */
public class DateAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	/**
	 * 格式化日前
	 */
	private SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public DateAction() {
		super("action.date", "icon.date");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JTextArea jta = frame.getEditorMain();
		jta.replaceRange(format.format(new Date()), jta.getSelectionStart(),
				jta.getSelectionEnd());
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
