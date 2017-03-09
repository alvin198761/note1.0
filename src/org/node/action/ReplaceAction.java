package org.node.action;

import java.awt.event.ActionEvent;

import org.node.gui.ReplaceDialog;
import org.node.system.NoteSystem;

/**
 * 替换
 * 
 * @author TANG
 * 
 */
public class ReplaceAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public ReplaceAction() {
		super("action.replace", "icon.replace");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ReplaceDialog dialog = (ReplaceDialog) NoteSystem
				.getAttribute("replacedialog");
		if (dialog == null) {
			dialog = new ReplaceDialog();
			NoteSystem.setAttribute("replacedialog", dialog);
		}
		dialog.setVisible(true);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
