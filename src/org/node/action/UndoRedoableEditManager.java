package org.node.action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEditSupport;

import org.node.system.NoteSystem;

/**
 * 撤销回复编辑管理
 * 
 * @author TANG
 * 
 */
@SuppressWarnings("unchecked")
public class UndoRedoableEditManager {
	/**
	 * 回复 撤销管理
	 */
	private UndoManager undoManager = new UndoManager();
	/**
	 * 撤销 回复 支持
	 */
	private UndoableEditSupport support = new UndoableEditSupport();
	/**
	 * 消息机制
	 */
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public UndoRedoableEditManager() {
		support.addUndoableEditListener(undoManager);
		NoteSystem.setAttribute("undoManager", undoManager);
	}

	/**
	 * 添加属性的事件
	 * 
	 * @param propertyName
	 * @param listener
	 */
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * 删除所有的节点
	 */
	public void removeEdit() {
		undoManager.discardAllEdits();
		fireActionPropertyChange();
	}

	/**
	 * 刷新actioin 状态S
	 */
	public void fireActionPropertyChange() {
		SuperAction undoAction = (SuperAction) ActionManager
				.getAction(UndoActioin.class);
		undoAction.firePropertyChange();
		SuperAction redoAction = (SuperAction) ActionManager
				.getAction(RedoAction.class);
		redoAction.firePropertyChange();
	}

	/**
	 * 属性值已经更改
	 * 
	 * @param name
	 * @param oldValue
	 * @param newValue
	 */
	public void firePropertyChange(String name, Object oldValue, Object newValue) {
		propertyChangeSupport.firePropertyChange(name, oldValue, newValue);
	}

	/**
	 * 撤销的执行
	 */
	public void undo() {
		if (undoManager.canUndo()) {
			undoManager.undo();
			if (!undoManager.canUndo()) {
				RedoAction redoAction = (RedoAction) ActionManager
						.getAction(RedoAction.class);
				redoAction.firePropertyChange();
				UndoActioin undoActioin = (UndoActioin) ActionManager
						.getAction(UndoActioin.class);
				undoActioin.firePropertyChange();
			}
		}
	}

	/**
	 * 回复的执行
	 */
	public void redo() {
		if (undoManager.canRedo()) {
			undoManager.redo();
			if (!undoManager.canRedo()) {
				RedoAction redoAction = (RedoAction) ActionManager
						.getAction(RedoAction.class);
				redoAction.firePropertyChange();
				UndoActioin undoActioin = (UndoActioin) ActionManager
						.getAction(UndoActioin.class);
				undoActioin.firePropertyChange();
			}
		}
	}

	public UndoManager getUndoManager() {
		return undoManager;
	}

}
