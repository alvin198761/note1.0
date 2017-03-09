package org.node.action;

import java.awt.event.ActionEvent;

import org.node.system.NoteSystem;

/**
 * 保存action
 * 
 * @author TANG
 * 
 */
public class SaveAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public SaveAction() {
		super("action.save", "icon.save");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.saveFile();
	}

	@Override
	public boolean isEnabled() {
		Integer save = (Integer) NoteSystem.getAttribute("save");
		return save == NoteSystem.NO_SAVE;
	}

}
