package org.node.system;

import javax.swing.KeyStroke;

import org.node.lang.NoteLanguage;

/**
 * 快捷键工具类
 * 
 * @author TANG
 * 
 */
public class KeyUtil {

	/**
	 * 新建
	 */
	public static final KeyStroke NEW = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.new"));
	/**
	 * 打开
	 */
	public static final KeyStroke OPEN = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.open"));
	/**
	 * 保存
	 */
	public static final KeyStroke SAVE = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.save"));
	/**
	 * 另存为
	 */
	public static final KeyStroke SAVEAS = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.saveAs"));
	/**
	 * 页面设置
	 */
	public static final KeyStroke PAGECONFIGURE = KeyStroke
			.getKeyStroke(NoteLanguage.getValue("key.pageConfigure"));
	/**
	 * 打印
	 */
	public static final KeyStroke PRINT = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.print"));
	/**
	 * 打印
	 */
	public static final KeyStroke EXIT = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.print"));
	/**
	 * 撤销
	 */
	public static final KeyStroke UNDO = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.undo"));
	/**
	 * 回复
	 */
	public static final KeyStroke REDO = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.redo"));
	/**
	 * 剪切
	 */
	public static final KeyStroke CUT = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.cut"));
	/**
	 * 复制
	 */
	public static final KeyStroke COPY = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.copy"));
	/**
	 * 粘贴
	 */
	public static final KeyStroke PASTE = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.paste"));
	/**
	 * 删除行
	 */
	public static final KeyStroke DELETE = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.delete"));
	/**
	 * 查找
	 */
	public static final KeyStroke FIND = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.find"));
	/**
	 * 查找下一个
	 */
	public static final KeyStroke FINDNEXT = KeyStroke
			.getKeyStroke("key.findNext");
	/**
	 * 替换
	 */
	public static final KeyStroke REPLACE = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.replace"));
	/**
	 * 转到
	 */
	public static final KeyStroke GOTO = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.goto"));
	/**
	 * 全选
	 */
	public static final KeyStroke SELECTALL = KeyStroke
			.getKeyStroke(NoteLanguage.getValue("key.all"));
	/**
	 * 日期
	 */
	public static final KeyStroke DATE = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.date"));
	/**
	 * 换行
	 */
	public static final KeyStroke WRAP = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.warp"));
	/**
	 * 字体
	 */
	public static final KeyStroke FONT = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.font"));
	/**
	 * 状态栏
	 */
	public static final KeyStroke LOOKUP_STATE = KeyStroke
			.getKeyStroke(NoteLanguage.getValue("key.state"));
	/**
	 * 帮助
	 */
	public static final KeyStroke HELP = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.help"));
	/**
	 * 关于
	 */
	public static final KeyStroke ABOUT = KeyStroke.getKeyStroke(NoteLanguage
			.getValue("key.about"));

}
