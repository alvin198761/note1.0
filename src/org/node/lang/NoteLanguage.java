package org.node.lang;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化
 * 
 * @author TANG
 * 
 */
public class NoteLanguage {
	/**
	 * 当前语言配置
	 */
	private static Locale configer = Locale.getDefault();
	/**
	 * 资源路径
	 */
	private static String resoucepath = "Note";
	/**
	 * 语言环境对象
	 */
	static ResourceBundle RBOP;
	/**
	 * 加载语言环境
	 */
	static {
		loadLanguge();
	}

	/**
	 * 国际化，根据key值得到属性不同语言的值
	 * 
	 * @author 唐植超
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value = "";
		if (RBOP.containsKey(key)) {
			value = RBOP.getString(key);
		}
		return value;
	}

	/**
	 * 重新加载语言资源包
	 */
	public static void loadLanguge() {
		RBOP = ResourceBundle.getBundle(resoucepath, configer);
	}

	/**
	 * 得到程序运行的语言环境
	 * 
	 * @return
	 */
	public static Locale getConfiger() {
		return configer;
	}

	/**
	 * 设置程序环境
	 * 
	 * @param configer
	 */
	public static void setConfiger(Locale configer) {
		NoteLanguage.configer = configer;
	}
}
