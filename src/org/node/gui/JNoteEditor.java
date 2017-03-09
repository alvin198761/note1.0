package org.node.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;

import org.node.action.ActionManager;
import org.node.action.SaveAction;
import org.node.action.UndoActioin;
import org.node.biz.NoteBookOperateBiz;
import org.node.system.NoteSystem;

/**
 * * 编辑框 * *
 * 
 * @author TANG *
 */
public class JNoteEditor extends JTextArea implements DropTargetListener,
		KeyListener {
	private static final long serialVersionUID = 1L;
	/**
	 * 业务类
	 */
	private NoteBookOperateBiz biz = new NoteBookOperateBiz();

	public JNoteEditor() {
		setDropTarget(new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE,
				this));
		addKeyListener(this);
	}

	public void dragEnter(DropTargetDragEvent dtde) {
	}

	public void dragExit(DropTargetEvent dte) {
	}

	public void dragOver(DropTargetDragEvent dtde) {
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public void drop(DropTargetDropEvent dtde) {
		try {
			// 得到拖入的数据
			Transferable tr = dtde.getTransferable();
			// 判断是否为java支持的类型
			if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
				// 复制
				dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
				// 得到拖入的文件
				List list = (List) (dtde.getTransferable()
						.getTransferData(DataFlavor.javaFileListFlavor));
				if (list != null && list.size() > 0) {
					File f = (File) list.get(0);
					biz.dropFileToEditor(f);
				}
				dtde.dropComplete(true);
				this.updateUI();
			} else {
				dtde.rejectDrop();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (UnsupportedFlavorException ufe) {
			ufe.printStackTrace();

		}
	}

	public void dropActionChanged(DropTargetDragEvent dtde) {
	}

	public void keyPressed(KeyEvent e) {
		changeActionEnable(e);
	}

	public void keyReleased(KeyEvent e) {
		changeActionEnable(e);
	}

	public void keyTyped(KeyEvent e) {
		changeActionEnable(e);
	}

	/**
	 * 启用action
	 */
	private void changeActionEnable(KeyEvent e) {
		if (!e.isActionKey()) {
			NoteSystem.setAttribute("save", NoteSystem.NO_SAVE);
			SaveAction action = (SaveAction) ActionManager
					.getAction(SaveAction.class);
			action.firePropertyChange();

			UndoActioin undo = (UndoActioin) ActionManager
					.getAction(UndoActioin.class);
			undo.firePropertyChange();
		}
	}
}
