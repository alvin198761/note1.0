package org.node.action;

import java.awt.event.ActionEvent;

import org.node.biz.FindDialogBiz;
import org.node.gui.FindDialog;
import org.node.system.NoteSystem;

/**
 * 查找上一个
 * 
 * @author TANG
 * 
 */
public class FindDialogLastAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	private FindDialogBiz findBiz = new FindDialogBiz();

	public FindDialogLastAction() {
		super("action.findd.dialog.findbutton");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FindDialog findDialog = (FindDialog) NoteSystem
				.getAttribute("currentDialog");
		findBiz.find(findDialog.getFindTextField().getText(), !findDialog
				.getBackwardRadioButton().isSelected(), findDialog
				.getCompareToBigWordCheckBox().isSelected(), findDialog
				.getRegexCompareCheckBox().isSelected());
	}

	@Override
	public boolean isEnabled() {
		FindDialog findDialog = (FindDialog) NoteSystem
				.getAttribute("currentDialog");
		return findDialog.getFindTextField().getText().equals("");
	}

}
