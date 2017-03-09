package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 选择下一个
 * 
 * @author TANG
 * 
 */
public class GoNextActioin extends SuperAction {

	public GoNextActioin() {
		super("action.next");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
