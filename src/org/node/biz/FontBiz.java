package org.node.biz;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.node.lang.NoteLanguage;

/**
 * 字体业务类
 * 
 * @author TANG
 * 
 */
public class FontBiz {
	/**
	 * 得到当前平台支持的字体
	 * 
	 * @return
	 */
	public List<String> getSystemFontNames() {
		String[] fontName = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		return Arrays.asList(fontName);
	}

	/**
	 * 字体类型
	 * 
	 * @return
	 */
	public List<String> getFontType() {
		List<String> typeList = new ArrayList<String>();
		typeList.add(NoteLanguage.getValue("fontdialog.font.type.rule"));
		typeList.add(NoteLanguage.getValue("fontdialog.font.type.itailic"));
		typeList.add(NoteLanguage.getValue("fontdialog.font.type.bold"));
		typeList.add(NoteLanguage.getValue("fontdialog.font.type.i_b"));
		return typeList;
	}

	/**
	 * 字体大小
	 * 
	 * @return
	 */
	public List<String> getFontSize() {
		List<String> fontSizeList = new ArrayList<String>();
		int i = 0;
		for (i = 8; i < 24; i++) {
			fontSizeList.add(i + "");
		}
		for (; i <= 72; i += 12) {
			fontSizeList.add(i + "");
		}
		return fontSizeList;
	}

	/**
	 * 得到字体
	 * 
	 * @param name
	 * @param type
	 * @param size
	 * @return
	 */
	public Font getFont(String name, String type, String size) {
		Font font = null;
		int style = Font.PLAIN;
		if (type.equals(NoteLanguage.getValue("fontdialog.font.type.rule"))) {
			style = Font.PLAIN;
		} else if (type.equals(NoteLanguage
				.getValue("fontdialog.font.type.itailic"))) {
			style = Font.ITALIC;
		} else if (type.equals(NoteLanguage
				.getValue("fontdialog.font.type.bold"))) {
			style = Font.BOLD;
		} else if (type.equals(NoteLanguage
				.getValue("fontdialog.font.type.i_b"))) {
			style = Font.BOLD + Font.ITALIC;
		}
		font = new Font(name, style, Integer.parseInt(size));
		return font;
	}
}
