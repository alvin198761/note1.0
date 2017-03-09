package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 删除行 action
 * 
 * @author TANG
 * 
 */
public class DeleteAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public DeleteAction() {
		super("action.delete", "icon.delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("没有实现");
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
