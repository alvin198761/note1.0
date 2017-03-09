package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 页面配置action
 * 
 * @author TANG
 * 
 */
public class PageConfigureAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public PageConfigureAction() {
		super("action.pageConfigure", "icon.pageConfigure");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("暂时不实现");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
