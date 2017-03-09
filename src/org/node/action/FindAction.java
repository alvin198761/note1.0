package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 查找Action
 * 
 * @author TANG
 * 
 */
public class FindAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public FindAction() {
		super("action.find", "icon.find");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.find();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
