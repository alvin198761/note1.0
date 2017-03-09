package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 自动换行 action
 * 
 * @author TANG
 * 
 */
public class WarpAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public WarpAction() {
		super("action.warp", "icon.warp");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JTextArea text = frame.getEditorMain();
		text.setLineWrap(!text.getLineWrap());
		if (text.getLineWrap()) {
			// 改变图标
		} else {
			// 改变图标
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
