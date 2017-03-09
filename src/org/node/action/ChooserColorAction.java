package org.node.action;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import org.node.gui.FontDialog;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

/**
 * 颜色选择框
 * 
 * @author TANG
 * 
 */
public class ChooserColorAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	public ChooserColorAction() {
		super("action.choosercolor");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FontDialog fontDialog = (FontDialog) NoteSystem
				.getAttribute("fontdialog");
		Color selectColor = JColorChooser.showDialog(fontDialog, NoteLanguage
				.getValue("colordialog.title"), Color.BLACK);
		if (selectColor == null) {
			return;
		}
		fontDialog.getPreviewLabel().setForeground(selectColor);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
