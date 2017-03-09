package org.node.io;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件操作类
 * 
 * @author TANG
 * 
 */
public class FileOperate {
	/**
	 * 得到文件的全部内容
	 * 
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public String getFileContent(File f) throws IOException {
		StringBuffer content = new StringBuffer();
		if (f.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\r\n");
			}
			reader.close();
		}
		return content.toString();
	}

	/**
	 * 写入文件内容
	 * 
	 * @param f
	 * @param content
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean writeFileContent(File f, String content)
			throws FileNotFoundException {
		boolean result = false;
		if (f.exists()) {
			PrintWriter out = new PrintWriter(f);
			out.write(content);
			out.flush();
			out.close();
		}
		return result;
	}

	/**
	 * 保存度对象
	 * 
	 * @param obj
	 * @param f
	 * @throws FileNotFoundException
	 */
	public void saveObject(Object obj, File f) throws FileNotFoundException {
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream(f.getAbsolutePath())));
		e.writeObject(obj);
		e.flush();
		e.close();
	}

	/**
	 * 读取对象
	 * 
	 * @param f
	 * @return
	 * @throws FileNotFoundException
	 */
	public Object readObject(File f) throws FileNotFoundException {
		Object obj = null;
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(
				new FileInputStream(f.getAbsolutePath())));
		obj = d.readObject();
		d.close();
		return obj;
	}
}
