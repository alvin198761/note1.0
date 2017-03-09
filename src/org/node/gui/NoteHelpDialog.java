package org.node.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.node.action.ActionManager;
import org.node.action.CloseDialogAction;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

/**
 * 帮助
 * 
 * @author TANG
 * 
 */
public class NoteHelpDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public NoteHelpDialog() {
		setBounds(100, 100, 450, 413);
		setTitle(NoteLanguage.getValue("mess.help.title"));
		setIconImage(NoteSystem.loadImageByComponent(NoteLanguage
				.getValue("icon.main")));
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel titleLabel = new JLabel(NoteLanguage.getValue("mess.help.Info"));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(10, 10, 424, 43);
		contentPanel.add(titleLabel);

		JLabel helpInfoLabel = new JLabel(NoteLanguage
				.getValue("mess.help.Info.detail"));
		helpInfoLabel.setBounds(10, 63, 424, 279);
		contentPanel.add(helpInfoLabel);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton(ActionManager
				.getAction(CloseDialogAction.class));
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		NoteSystem.setAttribute("currentDialog", this);
	}

}
