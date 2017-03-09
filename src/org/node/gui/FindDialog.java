package org.node.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.node.action.ActionManager;
import org.node.action.FindDialogLastAction;
import org.node.gui.component.NoteTextFiled;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

public class FindDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel findLabel = new JPanel();
	private NoteTextFiled findTextField;
	private JCheckBox regexCompareCheckBox;
	private JCheckBox compareToBigWordCheckBox;
	private JLabel stateInfoLabel;
	private JRadioButton backwardRadioButton;
	private JRadioButton forwardRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindDialog dialog = new FindDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindDialog() {
		NoteSystem.setAttribute("currentDialog", this);
		setBounds(100, 100, 383, 172);
		setIconImage(NoteSystem.loadImageByComponent(NoteLanguage
				.getValue("icon.main")));
		setTitle(NoteLanguage.getValue("findDialog.title"));
		getContentPane().setLayout(new BorderLayout());
		findLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(findLabel, BorderLayout.CENTER);
		GridBagLayout gbl_findLabel = new GridBagLayout();
		gbl_findLabel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_findLabel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_findLabel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_findLabel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		findLabel.setLayout(gbl_findLabel);
		JLabel label = new JLabel(NoteLanguage.getValue("findDialog.findLabel"));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 3;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		findLabel.add(label, gbc_label);

		findTextField = new NoteTextFiled();
		GridBagConstraints gbc_findTextField = new GridBagConstraints();
		gbc_findTextField.gridwidth = 3;
		gbc_findTextField.insets = new Insets(0, 0, 5, 5);
		gbc_findTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_findTextField.gridx = 4;
		gbc_findTextField.gridy = 0;
		findLabel.add(findTextField, gbc_findTextField);
		findTextField.setColumns(10);

		stateInfoLabel = new JLabel("");
		GridBagConstraints gbc_stateInfoLabel = new GridBagConstraints();
		gbc_stateInfoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_stateInfoLabel.anchor = GridBagConstraints.WEST;
		gbc_stateInfoLabel.gridwidth = 8;
		gbc_stateInfoLabel.gridx = 0;
		gbc_stateInfoLabel.gridy = 1;
		findLabel.add(stateInfoLabel, gbc_stateInfoLabel);

		ButtonGroup bg = new ButtonGroup();

		forwardRadioButton = new JRadioButton(NoteLanguage
				.getValue("findDialog.forward.text"));
		forwardRadioButton.setSelected(true);
		bg.add(forwardRadioButton);
		GridBagConstraints gbc_forwardRadioButton = new GridBagConstraints();
		gbc_forwardRadioButton.gridwidth = 3;
		gbc_forwardRadioButton.anchor = GridBagConstraints.WEST;
		gbc_forwardRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_forwardRadioButton.gridx = 3;
		gbc_forwardRadioButton.gridy = 2;
		findLabel.add(forwardRadioButton, gbc_forwardRadioButton);

		backwardRadioButton = new JRadioButton(NoteLanguage
				.getValue("findDialog.backward.text"));
		bg.add(backwardRadioButton);
		GridBagConstraints gbc_backwardRadioButton = new GridBagConstraints();
		gbc_backwardRadioButton.anchor = GridBagConstraints.WEST;
		gbc_backwardRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_backwardRadioButton.gridx = 6;
		gbc_backwardRadioButton.gridy = 2;
		findLabel.add(backwardRadioButton, gbc_backwardRadioButton);

		compareToBigWordCheckBox = new JCheckBox(NoteLanguage
				.getValue("findDialog.matchCase"));
		GridBagConstraints gbc_compareToBigWordCheckBox = new GridBagConstraints();
		gbc_compareToBigWordCheckBox.gridwidth = 3;
		gbc_compareToBigWordCheckBox.anchor = GridBagConstraints.WEST;
		gbc_compareToBigWordCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_compareToBigWordCheckBox.gridx = 3;
		gbc_compareToBigWordCheckBox.gridy = 3;
		findLabel.add(compareToBigWordCheckBox, gbc_compareToBigWordCheckBox);

		regexCompareCheckBox = new JCheckBox(NoteLanguage
				.getValue("findDialog.rege"));
		GridBagConstraints gbc_regexCompareCheckBox = new GridBagConstraints();
		gbc_regexCompareCheckBox.anchor = GridBagConstraints.WEST;
		gbc_regexCompareCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_regexCompareCheckBox.gridx = 6;
		gbc_regexCompareCheckBox.gridy = 3;
		findLabel.add(regexCompareCheckBox, gbc_regexCompareCheckBox);

		JButton findButton = new JButton(ActionManager
				.getAction(FindDialogLastAction.class));

		getRootPane().setDefaultButton(findButton);
		GridBagConstraints gbc_lastbutton = new GridBagConstraints();
		gbc_lastbutton.insets = new Insets(0, 0, 0, 5);
		gbc_lastbutton.gridx = 6;
		gbc_lastbutton.gridy = 4;
		findLabel.add(findButton, gbc_lastbutton);
	}

	public JTextField getFindTextField() {
		return findTextField;
	}

	public void setFindTextField(NoteTextFiled findTextField) {
		this.findTextField = findTextField;
	}

	public JCheckBox getRegexCompareCheckBox() {
		return regexCompareCheckBox;
	}

	public void setRegexCompareCheckBox(JCheckBox regexCompareCheckBox) {
		this.regexCompareCheckBox = regexCompareCheckBox;
	}

	public JCheckBox getCompareToBigWordCheckBox() {
		return compareToBigWordCheckBox;
	}

	public void setCompareToBigWordCheckBox(JCheckBox compareToBigWordCheckBox) {
		this.compareToBigWordCheckBox = compareToBigWordCheckBox;
	}

	public JLabel getStateInfoLabel() {
		return stateInfoLabel;
	}

	public void setStateInfoLabel(JLabel stateInfoLabel) {
		this.stateInfoLabel = stateInfoLabel;
	}

	public JRadioButton getBackwardRadioButton() {
		return backwardRadioButton;
	}

	public JRadioButton getForwardRadioButton() {
		return forwardRadioButton;
	}

}
