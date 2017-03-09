package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.undo.UndoManager;

import org.node.system.NoteSystem;

/**
 * 撤销 action
 * 
 * @author TANG
 * 
 */
public class UndoActioin extends SuperAction {

	private static final long serialVersionUID = 1L;

	public UndoActioin() {
		super("action.undo", "icon.undo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.undo();
	}

	@Override
	public boolean isEnabled() {
		UndoManager um = (UndoManager) NoteSystem.getAttribute("undoManager");
		if (um == null) {
			return false;
		}
		return um.canUndo();
	}

}
