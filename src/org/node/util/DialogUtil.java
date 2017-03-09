/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.node.util;

import java.awt.Component;

import javax.swing.JOptionPane;

import org.node.gui.NoteFrame;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

/**
 * 弹出框工具类
 * 
 * @author 唐植超
 */
public class DialogUtil {

	public static final int SELECT_YES = JOptionPane.YES_OPTION;
	public static final int SELECT_NO = JOptionPane.NO_OPTION;
	public static final int SELECT_CANCEL = JOptionPane.CANCEL_OPTION;

	/**
	 * 消息框
	 * 
	 * @param msg
	 */
	public static void promptMessage(String msg) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JOptionPane.showMessageDialog(frame, msg, NoteLanguage
				.getValue("dialog.message"), JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * 警告框
	 * 
	 * @param msg
	 */
	public static void promptWarning(String msg) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JOptionPane.showMessageDialog(frame, msg, NoteLanguage
				.getValue("dialog.warn"), JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * 错误框
	 * 
	 * @param msg
	 */
	public static void promptError(String msg) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		JOptionPane.showMessageDialog(frame, msg, NoteLanguage
				.getValue("dialog.error"), JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 二项选择框
	 * 
	 * @param msg
	 * @return
	 */
	public static int confirmDialog(String msg) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		int res = JOptionPane.showConfirmDialog(frame, msg, NoteLanguage
				.getValue("dialog.confirm"), JOptionPane.YES_NO_OPTION);
		return res;
	}

	/**
	 * 三项选择框
	 * 
	 * @param msg
	 * @return
	 */
	public static int chooserConfigDialog(String msg) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		int res = JOptionPane.showConfirmDialog(frame, msg, NoteLanguage
				.getValue("dialog.confirm"), JOptionPane.YES_NO_CANCEL_OPTION);
		return res;
	}

	/**
	 * 消息框
	 * 
	 * @param msg
	 * @param comp
	 */
	public static void promptMessage(String msg, Component comp) {
		JOptionPane.showMessageDialog(comp, msg, NoteLanguage
				.getValue("dialog.message"), JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * 警告框
	 * 
	 * @param msg
	 * @param comp
	 */
	public static void promptWarning(String msg, Component comp) {
		JOptionPane.showMessageDialog(comp, msg, NoteLanguage
				.getValue("dialog.warn"), JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * 错误框
	 * 
	 * @param msg
	 * @param comp
	 */
	public static void promptError(String msg, Component comp) {
		JOptionPane.showMessageDialog(comp, msg, NoteLanguage
				.getValue("dialog.error"), JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 二项选择框
	 * 
	 * @param msg
	 * @param comp
	 * @return
	 */
	public static int confirmDialog(String msg, Component comp) {
		int res = JOptionPane.showConfirmDialog(comp, msg, NoteLanguage
				.getValue("dialog.confirm"), JOptionPane.YES_NO_OPTION);
		return res;
	}

	/**
	 * 三项选择框
	 * 
	 * @param msg
	 * @param comp
	 * @return
	 */
	public static int chooserConfigDialog(String msg, Component comp) {
		int res = JOptionPane.showConfirmDialog(comp, msg, NoteLanguage
				.getValue("dialog.confirm"), JOptionPane.YES_NO_CANCEL_OPTION);
		return res;
	}

	/**
	 * 输入框
	 * 
	 * @param title
	 * @param value
	 * @return
	 */
	public static String inputDialog(String title, String value) {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		String res = JOptionPane.showInputDialog(frame, title, value);
		return res;
	}
}
