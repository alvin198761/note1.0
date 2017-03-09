package org.node.system;

import org.node.lang.NoteLanguage;

/**
 * 应用程序类
 * 
 * @author TANG
 * 
 */
public class NoteApplication {

	/** 版本号 */
	public static final String VERSION = NoteLanguage
			.getValue("system.version");
	/**
	 * 软件作者
	 */
	public static final String AUTHOR = NoteLanguage.getValue("system.author");
	/**
	 * 系统名字
	 */
	public static final String SYSTEM_NAME = NoteLanguage
			.getValue("system.name")
			+ " " + VERSION + " " + AUTHOR;

}
