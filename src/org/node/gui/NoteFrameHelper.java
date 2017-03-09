package org.node.gui;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTextArea;

import org.node.action.AboutAction;
import org.node.action.ActionManager;
import org.node.action.CopyAction;
import org.node.action.CutAction;
import org.node.action.DateAction;
import org.node.action.DeleteAction;
import org.node.action.ExitAction;
import org.node.action.FindAction;
import org.node.action.FindNextAction;
import org.node.action.FontAction;
import org.node.action.GotoAction;
import org.node.action.HelpAction;
import org.node.action.LookUpStateInfoAction;
import org.node.action.NewNoteAction;
import org.node.action.OpenFileAction;
import org.node.action.PageConfigureAction;
import org.node.action.PasteAction;
import org.node.action.PrintAction;
import org.node.action.RedoAction;
import org.node.action.ReplaceAction;
import org.node.action.SaveAction;
import org.node.action.SelectAllAction;
import org.node.action.UndoActioin;
import org.node.action.UndoRedoableEditManager;
import org.node.action.WarpAction;
import org.node.system.KeyUtil;
import org.node.system.NoteSystem;

/**
 * 主窗体帮助类
 * 
 * @author TANG
 * 
 */
public class NoteFrameHelper {
	/**
	 * 撤销 回复支持
	 */
	private UndoRedoableEditManager undoSupport = new UndoRedoableEditManager();

	public NoteFrameHelper(NoteFrame noteFrame) {
		loadAction(noteFrame.getEditorMain());
	}

	/**
	 * 加载快捷键
	 * 
	 * @param editor
	 */
	public void loadAction(JTextArea editor) {
		// 将undo manager 保存到属性范围
		NoteSystem.setAttribute("undoSupport", undoSupport);
		editor.getDocument().addUndoableEditListener(
				undoSupport.getUndoManager());

		InputMap imp = editor.getInputMap();
		ActionMap amp = editor.getActionMap();

		amp.put("undo", ActionManager.getAction(UndoActioin.class));
		amp.put("redo", ActionManager.getAction(RedoAction.class));
		amp.put("copy", ActionManager.getAction(CopyAction.class));
		amp.put("cut", ActionManager.getAction(CutAction.class));
		amp.put("paste", ActionManager.getAction(PasteAction.class));
		amp.put("delete", ActionManager.getAction(DeleteAction.class));
		amp.put("find", ActionManager.getAction(FindAction.class));
		amp.put("findNext", ActionManager.getAction(FindNextAction.class));
		amp.put("replace", ActionManager.getAction(ReplaceAction.class));
		amp.put("all", ActionManager.getAction(SelectAllAction.class));
		amp.put("goto", ActionManager.getAction(GotoAction.class));
		amp.put("date", ActionManager.getAction(DateAction.class));
		amp.put("open", ActionManager.getAction(OpenFileAction.class));
		amp.put("new", ActionManager.getAction(NewNoteAction.class));
		amp.put("save", ActionManager.getAction(SaveAction.class));
		amp.put("saveAs", ActionManager.getAction(SaveAction.class));
		amp.put("pageConfigure", ActionManager
				.getAction(PageConfigureAction.class));
		amp.put("print", ActionManager.getAction(PrintAction.class));
		amp.put("exit", ActionManager.getAction(ExitAction.class));
		amp.put("wrap", ActionManager.getAction(WarpAction.class));
		amp.put("font", ActionManager.getAction(FontAction.class));
		amp.put("lookUpState", ActionManager
				.getAction(LookUpStateInfoAction.class));
		amp.put("about", ActionManager.getAction(AboutAction.class));
		amp.put("help", ActionManager.getAction(HelpAction.class));

		imp.put(KeyUtil.HELP, "help");
		imp.put(KeyUtil.COPY, "copy");
		imp.put(KeyUtil.CUT, "cut");
		imp.put(KeyUtil.PASTE, "paste");
		imp.put(KeyUtil.DELETE, "delete");
		imp.put(KeyUtil.FIND, "find");
		imp.put(KeyUtil.FINDNEXT, "findNext");
		imp.put(KeyUtil.REPLACE, "replace");
		imp.put(KeyUtil.SELECTALL, "all");
		imp.put(KeyUtil.GOTO, "goto");
		imp.put(KeyUtil.DATE, "date");
		imp.put(KeyUtil.OPEN, "open");
		imp.put(KeyUtil.NEW, "new");
		imp.put(KeyUtil.SAVE, "save");
		imp.put(KeyUtil.SAVEAS, "saveAs");
		imp.put(KeyUtil.PAGECONFIGURE, "pageConfigure");
		imp.put(KeyUtil.PRINT, "print");
		imp.put(KeyUtil.EXIT, "exit");
		imp.put(KeyUtil.WRAP, "wrap");
		imp.put(KeyUtil.FONT, "font");
		imp.put(KeyUtil.LOOKUP_STATE, "lookUpState");
		imp.put(KeyUtil.REDO, "redo");
		imp.put(KeyUtil.UNDO, "undo");

	}
}
