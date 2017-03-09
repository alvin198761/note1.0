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
import org.node.system.NoteApplication;
import org.node.system.NoteSystem;

/**
 * 关于面包
 * 
 * @author TANG
 * 
 */
public class NoteAboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public NoteAboutDialog() {
		setBounds(100, 100, 544, 325);
		setTitle("About " + NoteApplication.SYSTEM_NAME);
		setModal(true);
		setResizable(false);
		setIconImage(NoteSystem.loadImageByComponent(NoteLanguage
				.getValue("icon.main")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(NoteSystem.loadIconByName(NoteLanguage
				.getValue("icon.main")));
		iconLabel.setBounds(10, 33, 167, 194);
		contentPanel.add(iconLabel);

		JLabel infoMationLabel = new JLabel();
		infoMationLabel.setText(NoteLanguage.getValue("mess.about"));
		infoMationLabel.setBounds(187, 33, 331, 194);
		contentPanel.add(infoMationLabel);
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
