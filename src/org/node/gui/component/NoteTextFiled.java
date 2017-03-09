package org.node.gui.component;

import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JTextField;

/**
 * 组件拖拽数据
 * 
 * @author TANG
 * 
 */
public class NoteTextFiled extends JTextField implements DragSourceListener,
		DragGestureListener {
	/**
	 * 操作实体
	 */
	private DragSource dragSource;

	public NoteTextFiled() {
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this,
				DnDConstants.ACTION_COPY, this);
	}

	private static final long serialVersionUID = 1L;

	public void dragDropEnd(DragSourceDropEvent dsde) {

	}

	public void dragEnter(DragSourceDragEvent dsde) {

	}

	public void dragExit(DragSourceEvent dse) {

	}

	public void dragOver(DragSourceDragEvent dsde) {

	}

	public void dropActionChanged(DragSourceDragEvent dsde) {

	}

	public void dragGestureRecognized(DragGestureEvent dge) {
		// 复制数据
		StringSelection text = new StringSelection(getText());
		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, text, this);
	}
}
