package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 打印action
 * 
 * @author TANG
 * 
 */
public class PrintAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public PrintAction() {
		super("action.print", "icon.print");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 暂时不实现
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
