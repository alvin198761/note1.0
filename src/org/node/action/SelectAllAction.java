package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 全选 action
 * 
 * @author TANG
 * 
 */

public class SelectAllAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public SelectAllAction() {
		super("action.all", "icon.all");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.selectAll();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
