package org.node.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.node.biz.ReplaceBiz;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

/**
 * 替换 对话框
 * 
 * @author TANG
 * 
 */
public class ReplaceDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField firstStrTextFiled;
	private JTextField secondStrTextFiled;
	private JCheckBox replaceAllCheckBox;
	private ReplaceBiz replaceBiz = new ReplaceBiz();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReplaceDialog dialog = new ReplaceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReplaceDialog() {
		setResizable(false);
		setBounds(100, 100, 450, 186);
		setIconImage(NoteSystem.loadImageByComponent(NoteLanguage
				.getValue("icon.main")));
		setTitle(NoteLanguage.getValue("replace.title"));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		JLabel firstStrLabel = new JLabel(NoteLanguage
				.getValue("replacedialog.replace.str1"));
		GridBagConstraints gbc_firstStrLabel = new GridBagConstraints();
		gbc_firstStrLabel.gridwidth = 2;
		gbc_firstStrLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstStrLabel.gridx = 1;
		gbc_firstStrLabel.gridy = 1;
		contentPanel.add(firstStrLabel, gbc_firstStrLabel);
		firstStrTextFiled = new JTextField();
		GridBagConstraints gbc_firstStrTextFiled = new GridBagConstraints();
		gbc_firstStrTextFiled.gridwidth = 4;
		gbc_firstStrTextFiled.insets = new Insets(0, 0, 5, 0);
		gbc_firstStrTextFiled.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstStrTextFiled.gridx = 3;
		gbc_firstStrTextFiled.gridy = 1;
		contentPanel.add(firstStrTextFiled, gbc_firstStrTextFiled);
		firstStrTextFiled.setColumns(10);
		replaceAllCheckBox = new JCheckBox(NoteLanguage
				.getValue("replacedialog.replace.all"));
		GridBagConstraints gbc_replaceAllCheckBox = new GridBagConstraints();
		gbc_replaceAllCheckBox.anchor = GridBagConstraints.WEST;
		gbc_replaceAllCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_replaceAllCheckBox.gridx = 3;
		gbc_replaceAllCheckBox.gridy = 2;
		contentPanel.add(replaceAllCheckBox, gbc_replaceAllCheckBox);
		JLabel secondStrLabel = new JLabel(NoteLanguage
				.getValue("replacedialog.replace.with"));
		GridBagConstraints gbc_secondStrLabel = new GridBagConstraints();
		gbc_secondStrLabel.anchor = GridBagConstraints.EAST;
		gbc_secondStrLabel.insets = new Insets(0, 0, 5, 5);
		gbc_secondStrLabel.gridx = 2;
		gbc_secondStrLabel.gridy = 3;
		contentPanel.add(secondStrLabel, gbc_secondStrLabel);
		secondStrTextFiled = new JTextField();
		GridBagConstraints gbc_secondStrTextFiled = new GridBagConstraints();
		gbc_secondStrTextFiled.gridwidth = 4;
		gbc_secondStrTextFiled.insets = new Insets(0, 0, 5, 0);
		gbc_secondStrTextFiled.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondStrTextFiled.gridx = 3;
		gbc_secondStrTextFiled.gridy = 3;
		contentPanel.add(secondStrTextFiled, gbc_secondStrTextFiled);
		secondStrTextFiled.setColumns(10);
		JButton okButton = new JButton(NoteLanguage.getValue("dailog.ok.text"));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replaceBiz.replace(firstStrTextFiled.getText(),
						secondStrTextFiled.getText());
			}
		});
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 5;
		gbc_okButton.gridy = 4;
		contentPanel.add(okButton, gbc_okButton);
		JButton cancelButton = new JButton(NoteLanguage
				.getValue("dialog.cancel.text"));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 4;
		contentPanel.add(cancelButton, gbc_cancelButton);
	}

	public JTextField getFirstStrTextFiled() {
		return firstStrTextFiled;
	}

	public JTextField getSecondStrTextFiled() {
		return secondStrTextFiled;
	}

	public JCheckBox getReplaceAllCheckBox() {
		return replaceAllCheckBox;
	}

}
