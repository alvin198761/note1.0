package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 打开文件action
 * 
 * @author TANG
 * 
 */
public class OpenFileAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public OpenFileAction() {
		super("action.open", "icon.open");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.openNewFile();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
