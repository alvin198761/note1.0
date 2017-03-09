package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 新建
 * 
 * @author TANG
 * 
 */
public class NewNoteAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	public NewNoteAction() {
		super("action.new", "icon.new");
	}

	public void actionPerformed(ActionEvent e) {
		operatebiz.newNoteBook();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
