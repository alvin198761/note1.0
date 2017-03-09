package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 查找下一个 action
 * 
 * @author TANG
 * 
 */
public class FindNextAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public FindNextAction() {
		super("action.findNext", "icon.findNext");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
