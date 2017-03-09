package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.undo.UndoManager;

import org.node.system.NoteSystem;

/**
 * 回复 action
 * 
 * @author TANG
 * 
 */
public class RedoAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public RedoAction() {
		super("action.redo", "icon.redo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.redo();
	}

	@Override
	public boolean isEnabled() {
		UndoManager um = (UndoManager) NoteSystem.getAttribute("undoManager");
		if (um == null) {
			return false;
		}
		return um.canRedo();
	}
}
