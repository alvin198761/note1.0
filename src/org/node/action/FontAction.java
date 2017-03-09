package org.node.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import org.node.gui.FontDialog;
import org.node.gui.NoteFrame;
import org.node.system.NoteSystem;

/**
 * 字体
 * 
 * @author TANG
 * 
 */
public class FontAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	public FontAction() {
		super("action.font", "icon.font");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FontDialog fontDialog = (FontDialog) NoteSystem
				.getAttribute("fontdialog");
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		if (fontDialog == null) {
			fontDialog = new FontDialog();
			fontDialog.setLocationRelativeTo(frame);
			NoteSystem.setAttribute("fontdialog", fontDialog);
		}
		fontDialog.getPreviewLabel().setForeground(
				frame.getEditorMain().getForeground());
		fontDialog.getPreviewLabel().setFont(frame.getEditorMain().getFont());
		fontDialog.setVisible(true);
		if (fontDialog.isApplity()) {
			Color color = fontDialog.getPreviewLabel().getForeground();
			Font font = fontDialog.getPreviewLabel().getFont();
			frame.getEditorMain().setForeground(color);
			frame.getEditorMain().setFont(font);
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
