package org.node.gui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.node.lang.NoteLanguage;
import org.node.util.DialogUtil;

/**
 * 文件选择器
 * 
 * @author TANG
 * 
 */
public class NoteFileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;
	/**
	 * 文本文件后缀
	 */
	public static final String NOTE_FILE_TYPE_TXT = NoteLanguage
			.getValue("type.note");

	public static final String DO = NoteLanguage.getValue("do");

	@Override
	public void approveSelection() {
		// 得到当前选择的文件
		File f = getSelectedFile();
		// 文件为 null
		if (f != null) {
			// 得到当前对话框的类型
			int type = getDialogType();
			// 如果是打开类型
			if (type == OPEN_DIALOG) {
				// 如果说文件不存在
				if (!f.exists()) {
					DialogUtil.promptError("mess.fileNotExist");
				}
			} else if (type == SAVE_DIALOG) {// 如果是保存类型
				// 如果文件存在
				if (f.exists()) {
					int result = DialogUtil.confirmDialog(getInfomation(
							"mess.fileIsOverride", f.getName()), this);
					if (result != DialogUtil.SELECT_YES) {
						return;
					}
				} else {

					int result = DialogUtil.confirmDialog(getInfomation(
							"mess.fileIsCreate", f.getName()), this);
					if (result == DialogUtil.SELECT_YES) {
						try {
							f.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
							DialogUtil
									.promptError(getInfomation(
											"mess.fileCannotCreate", f
													.getName()), this);
						}
					}

				}
			}
		}
		super.approveSelection();
	}

	/**
	 * 得到提示消息
	 * 
	 * @param key
	 * @return
	 */
	private String getInfomation(String key, String name) {
		return NoteLanguage.getValue(key).replaceAll("<fileName>", name);
	}

	// construct
	private NoteFileChooser() {
	}

	// 静态实例
	private static NoteFileChooser instance;

	/**
	 * 得到文件选择器实例对象
	 * 
	 * @return
	 */
	public synchronized static NoteFileChooser getFileChooser() {
		if (instance == null) {
			instance = new NoteFileChooser();
			instance.setFileFilter(new FileNameExtensionFilter(NoteLanguage
					.getValue("desc.type.txt"), NOTE_FILE_TYPE_TXT));
		}
		return instance;
	}
}
