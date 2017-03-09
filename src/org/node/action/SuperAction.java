package org.node.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.node.biz.NoteBookOperateBiz;
import org.node.lang.NoteLanguage;
import org.node.system.NoteSystem;

/**
 * 所有action 的父类
 * 
 * @author TANG
 * 
 */
public abstract class SuperAction extends AbstractAction {
	/**
	 * 业务类
	 */
	protected NoteBookOperateBiz operatebiz = new NoteBookOperateBiz();

	/**
	 * 处理一个请求
	 */
	public abstract void actionPerformed(ActionEvent e);

	/**
	 * 创建一个action
	 */
	public SuperAction() {
		setEnabled(true);
	}

	/**
	 * 创一个带文本的action
	 * 
	 * @param text
	 */
	public SuperAction(String text) {
		super(NoteLanguage.getValue(text));
	}

	/**
	 * 创建一个带图标和文本的action
	 * 
	 * @param text
	 * @param iconName
	 */
	public SuperAction(String text, String iconName) {
		super(NoteLanguage.getValue(text), NoteSystem
				.loadIconByName(NoteLanguage.getValue(iconName)));
	}

	/**
	 * 是否启用action
	 */
	public abstract boolean isEnabled();

	/**
	 * 属性值改变
	 */
	public void firePropertyChange() {
		boolean newValue = this.isEnabled();
		firePropertyChange("enabled", Boolean.valueOf(!newValue), Boolean
				.valueOf(newValue));
	}

}
