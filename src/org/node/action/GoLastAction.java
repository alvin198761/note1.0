package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 上一个
 * 
 * @author TANG
 * 
 */
public class GoLastAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public GoLastAction() {
		super("action.last");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("有时间搞吧");
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
