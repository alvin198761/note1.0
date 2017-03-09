package org.node.action;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

/**
 * action 管理
 * 
 * @author TANG
 * 
 */
public class ActionManager {
	/**
	 * 所有的action
	 */
	private static Map<Class<? extends Action>, Action> actionMap = new HashMap<Class<? extends Action>, Action>();

	/**
	 * 根据传入的class 得到或者创建一个action 实例 返回出来
	 * 
	 * @param clazz
	 * @return
	 */
	public static Action getAction(Class<? extends Action> clazz) {
		Action action = actionMap.get(clazz);
		if (action == null) {
			try {
				action = clazz.newInstance();
				actionMap.put(clazz, action);
			} catch (InstantiationException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return action;
	}

}
