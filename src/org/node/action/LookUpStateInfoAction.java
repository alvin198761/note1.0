package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 查看状态栏
 * 
 * @author TANG
 * 
 */
public class LookUpStateInfoAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public LookUpStateInfoAction() {
		super("action.state", "icon.state");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
