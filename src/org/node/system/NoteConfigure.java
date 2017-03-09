package org.node.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置
 * 
 * @author TANG
 * 
 */
public class NoteConfigure {

	private NoteConfigure() {
		load(NoteSystem.SYSTEM_RESOUCE_FILE_ABSPATH);
	}

	private static NoteConfigure instance;

	private Properties evl = new Properties();

	/**
	 * 单例实例
	 * 
	 * @return
	 */
	public synchronized static NoteConfigure getInstace() {
		if (instance == null) {
			instance = new NoteConfigure();
		}
		return instance;
	}

	/**
	 * 加载属性文件
	 */
	private void load(String path) {
		try {
			evl.load(new FileReader(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到资源的内容
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		String result = "";
		if (evl.containsKey(key)) {
			return evl.getProperty(key);
		}
		return result;
	}

	/**
	 * 得到资源的内容 (默认值)
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key, String defaultValue) {
		if (evl.containsKey(key)) {
			return evl.getProperty(key);
		}
		return defaultValue;
	}
}
