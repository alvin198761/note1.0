package org.node.action;

import java.awt.event.ActionEvent;

/**
 * 粘贴 action
 * 
 * @author TANG
 * 
 */
public class PasteAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public PasteAction() {
		super("action.paste", "icon.paste");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		operatebiz.paste();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
