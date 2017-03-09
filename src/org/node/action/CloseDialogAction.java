package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 关闭对话框action
 * 
 * @author TANG
 * 
 */
public class CloseDialogAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public CloseDialogAction() {
		super("action.close.dialog");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.closeDialog();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
