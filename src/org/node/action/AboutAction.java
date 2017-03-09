package org.node.action;

import java.awt.event.ActionEvent;

import org.node.gui.NoteAboutDialog;
import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 关于 action
 * 
 * @author TANG
 * 
 */
public class AboutAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public AboutAction() {
		super("action.about", "icon.about");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		NoteAboutDialog aboutDialog = new NoteAboutDialog();
		aboutDialog.setLocationRelativeTo(frame);
		aboutDialog.setVisible(true);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
