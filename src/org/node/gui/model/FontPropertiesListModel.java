package org.node.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * 字体属性的model
 * 
 * @author TANG
 * 
 */
public class FontPropertiesListModel extends AbstractListModel {

	private static final long serialVersionUID = 1L;
	/**
	 * model内容
	 */
	private List<String> content;

	public FontPropertiesListModel(List<String> content) {
		if (content == null) {
			content = new ArrayList<String>();
		}
		this.content = content;
	}

	public Object getElementAt(int index) {
		if (index == -1) {
			return null;
		}
		return content.get(index);
	}

	public int getSize() {
		return content.size();
	}

}
