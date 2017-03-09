package org.node.biz;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import org.node.action.ActionManager;
import org.node.action.SaveAction;
import org.node.action.UndoRedoableEditManager;
import org.node.gui.FindDialog;
import org.node.gui.NoteFileChooser;
import org.node.gui.NoteFrame;
import org.node.gui.NoteHelpDialog;
import org.node.io.FileOperate;
import org.node.lang.NoteLanguage;
import org.node.system.NoteApplication;
import org.node.system.NoteSystem;
import org.node.util.DialogUtil;

/**
 * 记事本业务操作类
 * 
 * @author TANG
 * 
 */
public class NoteBookOperateBiz {
	/**
	 * 问价选择器
	 */
	private NoteFileChooser noteFileChooser = NoteFileChooser.getFileChooser();
	/**
	 * 文件操作类
	 */
	private FileOperate fileOperate = new FileOperate();
	/**
	 * 支持文件的后缀
	 */
	private String fixpre = NoteFileChooser.DO
			+ NoteFileChooser.NOTE_FILE_TYPE_TXT;

	/**
	 * 新建文本文件
	 */
	public boolean newNoteBook() {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		try {
			Integer isSave = (Integer) NoteSystem.getAttribute("save");
			if (isSave == NoteSystem.NO_SAVE) {
				boolean result = exitOrReset();
				if (result) {
					// 改变标题
					frame.setTitle(NoteLanguage.getValue("title.new.noteBook"
							+ " -- " + NoteApplication.SYSTEM_NAME));
					// 清空文本内容
					frame.getEditorMain().setText("");
					// 清空当前文件消息
					NoteSystem.removeAttribute("currentPath");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 退出 重置 或者打开
	 * 
	 * @return
	 */
	public boolean exitOrReset() {
		// 检查当前文件是否为未保存
		Integer isSave = (Integer) NoteSystem.getAttribute("save");
		// 选择结果
		int result = 0;
		// 如果文件没有保存
		if (isSave == NoteSystem.NO_SAVE) {
			// 提示是否保存
			result = DialogUtil.confirmDialog(NoteLanguage
					.getValue("mess.isSave"));
			if (result == DialogUtil.SELECT_YES) {
				return saveFile();
				// 先判断是否有保存的位置 如果没有 先选择保存位置 在保存
			} else if (result == DialogUtil.SELECT_CANCEL) {

			} else if (result == DialogUtil.SELECT_NO) {
				// 不保存文件
				return true;
			}
		} else {
			return true;
		}
		return false;
	}

	/**
	 * 保存文件
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean saveFile() {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		boolean isOk = false;
		// 检查当前文件是否为未保存
		Integer isSave = (Integer) NoteSystem.getAttribute("save");
		// 当前保存到什么路径
		String path = (String) NoteSystem.getAttribute("currentPath");
		// 如果文件没有保存
		if (isSave == NoteSystem.NO_SAVE) {
			// 当前文件没有要保存的路径
			if (path == null || "".equals(path)) {
				// 弹出对话框 选择路径
				noteFileChooser.showSaveDialog(frame);
				// 得到要保存的路径
				File f = noteFileChooser.getSelectedFile();
				// 如果文件为空
				if (f == null) {
					return false;
				}
				// 补后缀
				if (!f.getName().endsWith(fixpre)) {
					f = new File(f.getAbsolutePath() + fixpre);
				}
				try {
					fileOperate.writeFileContent(f, frame.getEditorMain()
							.getText());
					NoteSystem.setAttribute("save", NoteSystem.IS_SAVE);
					NoteSystem.setAttribute("currentPath", f.getAbsolutePath());
					// 改变标题
					frame.setTitle(f.getAbsolutePath() + " -- "
							+ NoteApplication.SYSTEM_NAME);
					// 状态提示
					frame.getStateInfoLabel().setText(frame.getTitle());

					SaveAction saveAction = (SaveAction) ActionManager
							.getAction(SaveAction.class);
					saveAction.firePropertyChange();
					return true;
				} catch (FileNotFoundException e) {
					DialogUtil.promptError("mess.write.error");
					e.printStackTrace();
					return false;
				}
			}

		} else {
			isOk = true;
		}
		return isOk;
	}

	/**
	 * 打开一个文件
	 * 
	 * @return
	 */
	public boolean openNewFile() {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		int result = noteFileChooser.showOpenDialog(frame);
		if (result != JFileChooser.APPROVE_OPTION) {
			return false;
		}
		File f = noteFileChooser.getSelectedFile();
		if (f == null) {
			return false;
		}
		// 如果用户选择一个非 文本文件类型的文件
		if (!f.getPath().endsWith(fixpre)) {
			String fileType = f.getPath().substring(
					f.getPath().lastIndexOf(NoteFileChooser.DO) + 1);
			if (NoteLanguage.getValue("mess.file.type.cannot.read").indexOf(
					"," + fileType + ",") != -1) {
				DialogUtil.promptWarning(NoteLanguage
						.getValue("mess.file.type.wrong"));
				return false;
			}
			// 提示用户
			int chooser = DialogUtil.confirmDialog(NoteLanguage
					.getValue("mess.file.type.iswilllost"));
			if (chooser == DialogUtil.SELECT_YES) {

			} else if (chooser == DialogUtil.SELECT_NO) {
				return false;
			}
		}
		try {
			if (exitOrReset()) {
				String content = fileOperate.getFileContent(f);
				if (content == null) {
					DialogUtil.promptError("mess.read.file.error");
					return false;
				}
				// 改变内容
				frame.getEditorMain().setText(content);
				// 改变标题
				frame.setTitle(f.getAbsolutePath() + " -- "
						+ NoteApplication.SYSTEM_NAME);
				// 状态提示
				frame.getStateInfoLabel().setText(frame.getTitle());
				// 将文件路保存到系统变量中
				NoteSystem.setAttribute("currentPath", f.getAbsolutePath());
				return true;
			}
		} catch (IOException e) {
			DialogUtil.promptError("mess.read.file.error");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 另存为
	 * 
	 * @return
	 */
	public boolean saveAs() {
		boolean result = false;
		String path = (String) NoteSystem.getAttribute("currentPath");
		int save = (Integer) NoteSystem.getAttribute("save");
		NoteSystem.removeAttribute("currentPath");
		NoteSystem.setAttribute("save", NoteSystem.NO_SAVE);
		result = saveFile();
		if (!result) {
			NoteSystem.setAttribute("currentPath", path);
			NoteSystem.setAttribute("save", save);
		}
		return result;
	}

	/**
	 * 退出事件
	 * 
	 * @return
	 */
	public boolean exit() {
		// 检查当前文件是否为未保存
		Integer isSave = (Integer) NoteSystem.getAttribute("save");
		if (isSave == NoteSystem.NO_SAVE) {
			exitOrReset();
		} else {
			int result = DialogUtil.chooserConfigDialog(NoteLanguage.getValue(
					"mess.exit").replace("<systemName>",
					NoteApplication.SYSTEM_NAME));
			if (result != DialogUtil.SELECT_YES) {
				return false;
			}
		}
		System.exit(0);
		return true;
	}

	/**
	 * 撤销
	 * 
	 * @return
	 */
	public boolean undo() {
		UndoRedoableEditManager undo = (UndoRedoableEditManager) NoteSystem
				.getAttribute("undoSupport");
		undo.undo();
		return true;
	}

	/**
	 * 回复
	 * 
	 * @return
	 */
	public boolean redo() {
		UndoRedoableEditManager undo = (UndoRedoableEditManager) NoteSystem
				.getAttribute("undoSupport");
		undo.redo();
		return true;
	}

	/**
	 * 关闭对话框
	 * 
	 * @return
	 */
	public boolean closeDialog() {
		JDialog dialog = (JDialog) NoteSystem.getAttribute("currentDialog");
		NoteSystem.removeAttribute("currentDialog");
		dialog.setVisible(false);
		dialog.dispose();
		dialog = null;
		return true;
	}

	/**
	 * 复制
	 * 
	 * @return
	 */
	public boolean copy() {
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		JTextArea text = frame.getEditorMain();
		String temp = text.getSelectedText();
		if (temp.equals("")) {
			return false;
		}
		StringSelection content = new StringSelection(temp);
		clipboard.setContents(content, null);
		return true;
	}

	/**
	 * 剪切
	 * 
	 * @return
	 */
	public boolean cut() {
		boolean result = false;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		JTextArea text = frame.getEditorMain();
		String temp = text.getSelectedText();
		if (temp.equals("")) {
			return false;
		}
		StringSelection content = new StringSelection(temp);
		clipboard.setContents(content, null);
		int start = text.getSelectionStart();
		int end = text.getSelectionEnd();
		text.replaceRange("", start, end);
		return result;
	}

	/**
	 * 粘贴
	 * 
	 * @return
	 */
	public boolean paste() {
		boolean result = false;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		Clipboard clipboard = frame.getToolkit().getSystemClipboard();
		JTextArea text = frame.getEditorMain();
		Transferable contents = clipboard.getContents(this);
		DataFlavor flavor = DataFlavor.stringFlavor;
		if (contents.isDataFlavorSupported(flavor)) {
			try {
				String str;
				str = (String) contents.getTransferData(flavor);
				text.append(str);
			} catch (Exception ee) {
			}
		}
		return result;
	}

	/**
	 * 查找
	 * 
	 * @return
	 */
	public boolean find() {
		boolean result = false;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		FindDialog dialog = (FindDialog) NoteSystem
				.getAttribute("currentDialog");
		if (dialog == null) {
			dialog = new FindDialog();
			dialog.setLocationRelativeTo(frame);
		}
		dialog.setVisible(true);
		return result;
	}

	/**
	 * 帮助
	 * 
	 * @return
	 */
	public boolean help() {
		boolean result = false;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		NoteHelpDialog helpDialog = new NoteHelpDialog();
		helpDialog.setLocationRelativeTo(frame);
		helpDialog.setVisible(true);
		return result;
	}

	/**
	 * 全选
	 * 
	 * @return
	 */
	public boolean selectAll() {
		boolean result = true;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		frame.getEditorMain().selectAll();
		return result;
	}

	/**
	 * 根据文件路径得到内容
	 * 
	 * @param f
	 * @return
	 */
	public boolean dropFileToEditor(File f) {
		boolean result = true;
		NoteFrame frame = (NoteFrame) NoteSystem.getAttribute("domain");
		String content;
		try {
			content = fileOperate.getFileContent(f);
		} catch (IOException e) {
			DialogUtil.promptError(NoteLanguage
					.getValue("mess.read.file.error"));
			e.printStackTrace();
			return false;
		}
		// 改变内容
		frame.getEditorMain().setText(content);
		// 改变标题
		frame.setTitle(f.getAbsolutePath() + " -- "
				+ NoteApplication.SYSTEM_NAME);
		// 状态提示
		frame.getStateInfoLabel().setText(frame.getTitle());
		// 将文件路保存到系统变量中
		NoteSystem.setAttribute("currentPath", f.getAbsolutePath());
		return result;
	}
}
