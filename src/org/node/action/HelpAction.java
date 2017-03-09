package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 帮助 action
 * 
 * @author TANG
 * 
 */
public class HelpAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public HelpAction() {
		super("action.help", "icon.help");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.help();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
