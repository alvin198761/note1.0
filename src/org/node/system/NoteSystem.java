package org.node.system;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * 系统类
 * 
 * @author TANG
 * 
 */
public class NoteSystem {
	/** 默认字体大小 */
	public static final int DEFAULT_FONT_SIZE = 12;
	/** 文本字体大小 */
	public static int noteFontSize = DEFAULT_FONT_SIZE;
	/** 窗体的字体大小 */
	public static int compontFontSize = DEFAULT_FONT_SIZE;
	/** 系统的根目录 */
	public static final String SYSTEM_ROOT_PATH = System
			.getProperty("user.dir");
	/** 是否保存的常量 已经保存 */
	public static final int IS_SAVE = 1;
	/** 是否保存的常量 为保存 */
	public static final int NO_SAVE = 2;
	/** 系统资源文件名称 */
	public static final String SYSTEM_RESOURCE_FILE_NAME = "SystemConfiger.properties";
	/** 系统配置资源的文件路径 */
	public static final String SYSTEM_RESOUCE_FILE_ABSPATH = SYSTEM_ROOT_PATH
			+ File.separator + SYSTEM_RESOURCE_FILE_NAME;
	/** 保存系统变量 */
	private static Map<String, Object> attribute = new HashMap<String, Object>();

	private NoteSystem() {

	}

	/**
	 * 根据一个名称得到资源的路径
	 * 
	 * @param name
	 * @return
	 */
	public static URL getURL(String name) {
		URL url = NoteSystem.class.getResource("icons/" + name);
		return url;
	}

	/**
	 * 得到一个图标
	 * 
	 * @param name
	 * @return
	 */
	public static ImageIcon loadIconByName(String name) {
		return new ImageIcon(getURL(name));
	}

	/**
	 * 得到一张图片
	 * 
	 * @param name
	 * @return
	 */
	public static Image loadImageByComponent(String name) {
		return Toolkit.getDefaultToolkit().getImage(getURL(name));
	}

	/**
	 * 设置系统变量
	 * 
	 * @param key
	 * @param value
	 */
	public static void setAttribute(String key, Object value) {
		attribute.put(key, value);
	}

	/**
	 * 获取系统变量
	 * 
	 * @param key
	 * @return
	 */
	public static Object getAttribute(String key) {
		return attribute.get(key);
	}

	/**
	 * 删除系统变量
	 * 
	 * @param key
	 * @return
	 */
	public static boolean removeAttribute(String key) {
		int size = attribute.size();
		attribute.remove(key);
		return size > attribute.size();
	}
}
