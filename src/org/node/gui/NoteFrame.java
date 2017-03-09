package org.node.gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

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
import org.node.action.SaveAsAction;
import org.node.action.SelectAllAction;
import org.node.action.UndoActioin;
import org.node.action.WarpAction;
import org.node.lang.NoteLanguage;
import org.node.system.NoteApplication;
import org.node.system.NoteSystem;

/**
 * 记事本窗体
 * 
 * @author TANG
 * 
 */
public class NoteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel stateInfoLabel;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu formartMenu;
	private JMenu lookUpmenu;
	private JMenu helpMenu;
	/** 是否保存 */
	private boolean save = false;
	private JNoteEditor editorMain;

	/**
	 * Create the frame.
	 */
	public NoteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 534);
		setTitle(NoteApplication.SYSTEM_NAME);
		setIconImage(NoteSystem.loadImageByComponent(NoteLanguage
				.getValue("icon.main")));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ActionManager.getAction(ExitAction.class).actionPerformed(null);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		fileMenu = new JMenu(NoteLanguage.getValue("menu.file"));
		menuBar.add(fileMenu);

		editMenu = new JMenu(NoteLanguage.getValue("menu.edit"));
		menuBar.add(editMenu);

		formartMenu = new JMenu(NoteLanguage.getValue("menu.format"));
		menuBar.add(formartMenu);

		lookUpmenu = new JMenu(NoteLanguage.getValue("menu.lookup"));
		menuBar.add(lookUpmenu);

		helpMenu = new JMenu(NoteLanguage.getValue("menu.help"));
		menuBar.add(helpMenu);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar stateToolBar = new JToolBar();
		stateToolBar.setFloatable(false);
		contentPane.add(stateToolBar, BorderLayout.SOUTH);

		stateInfoLabel = new JLabel(getTitle());
		stateToolBar.add(stateInfoLabel);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		editorMain = new JNoteEditor();
		scrollPane.setViewportView(editorMain);
		// 将窗体保存到系统变量中去
		NoteSystem.setAttribute("domain", this);
		// 默认保存属性为 已经保存
		NoteSystem.setAttribute("save", NoteSystem.IS_SAVE);
		// 注册action
		addAction();
		// 加载其他
		new NoteFrameHelper(this);

	}

	/**
	 * 控件注册事件
	 */
	private void addAction() {
		// fileMenu
		fileMenu.add(ActionManager.getAction(NewNoteAction.class));
		fileMenu.add(ActionManager.getAction(OpenFileAction.class));
		fileMenu.add(new JMenuItem(ActionManager.getAction(SaveAction.class)));
		fileMenu.add(ActionManager.getAction(SaveAsAction.class));
		fileMenu.add(ActionManager.getAction(PageConfigureAction.class));
		fileMenu.add(ActionManager.getAction(PrintAction.class));
		fileMenu.add(ActionManager.getAction(ExitAction.class));

		// edit
		editMenu.add(ActionManager.getAction(UndoActioin.class));
		editMenu.add(ActionManager.getAction(RedoAction.class));
		editMenu.add(ActionManager.getAction(CutAction.class));
		editMenu.add(ActionManager.getAction(CopyAction.class));
		editMenu.add(ActionManager.getAction(PasteAction.class));
		editMenu.add(ActionManager.getAction(DeleteAction.class));
		editMenu.add(ActionManager.getAction(FindAction.class));
		editMenu.add(ActionManager.getAction(FindNextAction.class));
		editMenu.add(ActionManager.getAction(ReplaceAction.class));
		editMenu.add(ActionManager.getAction(GotoAction.class));
		editMenu.add(ActionManager.getAction(SelectAllAction.class));
		editMenu.add(ActionManager.getAction(DateAction.class));

		// format
		formartMenu.add(ActionManager.getAction(WarpAction.class));
		formartMenu.add(ActionManager.getAction(FontAction.class));

		// look up
		lookUpmenu.add(ActionManager.getAction(LookUpStateInfoAction.class));

		// help
		helpMenu.add(ActionManager.getAction(HelpAction.class));
		helpMenu.add(ActionManager.getAction(AboutAction.class));

	}

	public JLabel getStateInfoLabel() {
		return stateInfoLabel;
	}

	public void setStateInfoLabel(JLabel stateInfoLabel) {
		this.stateInfoLabel = stateInfoLabel;
	}

	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}

	public JNoteEditor getEditorMain() {
		return editorMain;
	}
}
