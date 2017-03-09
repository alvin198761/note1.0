package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 转到 action
 * 
 * @author TANG
 * 
 */
public class GotoAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public GotoAction() {
		super("action.goto", "icon.goto");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("不知道是干什么的");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
