package org.node.biz;

import org.node.gui.JNoteEditor;
import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 查找的业务逻辑
 * 
 * @author TANG
 * 
 */
public class FindDialogBiz {
	/**
	 * 查找
	 * 
	 * @param text
	 * @param flag
	 * @param caseCompare
	 * @param regx
	 * @return
	 */
	public boolean find(String text, boolean flag, boolean caseCompare,
			boolean regx) {
		boolean result = false;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JNoteEditor editor = frame.getEditorMain();
		int startIndex = editor.getSelectionStart();
		int endIndex = editor.getSelectionEnd();
		if (startIndex == -1) {
			startIndex = 0;
		}
		if (endIndex == -1) {
			endIndex = 0;
		}
		String allText = editor.getText();
		String temp = "";
		String subTemp = "";
		int length = text.length();
		if (!flag) {
			// 向上查找
			if (startIndex - length <= 0) {
				startIndex = allText.length() - 1;
			}
			temp = allText.substring(0, startIndex);
			for (int i = temp.length() - length; i >= 1; i--) {
				subTemp = temp.substring(i, i + length);
				// 忽略大小写
				if (caseCompare) {
					if (subTemp.equals(text)) {
						editor.setSelectionStart(i);
						editor.setSelectionEnd(editor.getSelectionStart()
								+ length);
						result = true;
						break;
					}
					if (regx) {
						if (subTemp.matches(text)) {
							editor.setSelectionStart(i);
							editor.setSelectionEnd(editor.getSelectionStart()
									+ length);
							result = true;
							break;
						}
					}
				} else if (subTemp.equalsIgnoreCase(text)) {
					editor.setSelectionStart(i);
					editor.setSelectionEnd(editor.getSelectionStart() + length);
					result = true;
					break;
				}
			}
			if (!result) {
				editor.setSelectionStart(allText.length() - 1);
				editor.setSelectionEnd(allText.length() - 1);
			}
		} else {
			// 向下查找
			if (endIndex + length >= allText.length() - 1) {
				endIndex = 0;
				editor.setSelectionEnd(0);
			}
			for (int i = endIndex; i < allText.length() - length; i++) {
				subTemp = allText.substring(i, i + length);
				if (caseCompare) {
					if (subTemp.equals(text)) {
						editor.setSelectionStart(i);
						editor.setSelectionEnd(i + length);
						result = true;
						break;
					}
					if (regx) {
						if (subTemp.matches(text)) {
							editor.setSelectionStart(i);
							editor.setSelectionEnd(i + length);
							result = true;
							break;
						}
					}
				} else if (subTemp.equalsIgnoreCase(text)) {
					editor.setSelectionStart(i);
					editor.setSelectionEnd(i + length);
					result = true;
					break;
				}
			}
		}
		if (!result) {
			editor.setSelectionStart(0);
			editor.setSelectionEnd(0);
		}
		return result;
	}
}
