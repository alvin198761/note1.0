package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 另存为 action
 * 
 * @author TANG
 * 
 */
public class SaveAsAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public SaveAsAction() {
		super("action.saveAs", "icon.saveAs");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.saveAs();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
