package org.node.biz;

import org.node.gui.NoteFrame;
import org.node.gui.ReplaceDialog;
import org.node.system.NoteSystem;

/**
 * 替换业务操作 呵呵 估计还有待改进
 * 
 * @author TANG
 * 
 */
public class ReplaceBiz {
	/**
	 * 替换操作
	 * 
	 * @param firstStr
	 * @param secondStr
	 */
	public void replace(String firstStr, String secondStr) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		ReplaceDialog reDialog = (ReplaceDialog) NoteSystem
				.getAttribute("replacedialog");
		String text = frame.getEditorMain().getText();
		// 全部替换
		if (reDialog.getReplaceAllCheckBox().isSelected()) {
			frame.getEditorMain().setText(text.replaceAll(firstStr, secondStr));
		} else {
			frame.getEditorMain().setText(
					text.replaceFirst(firstStr, secondStr));
		}
	}
}
