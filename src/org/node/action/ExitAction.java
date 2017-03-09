package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 退出action
 * 
 * @author TANG
 * 
 */
public class ExitAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public ExitAction() {
		super("action.exit", "icon.exit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.exit();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
