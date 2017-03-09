package application;

import java.awt.EventQueue;

import org.node.gui.NoteFrame;

public class NoteMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				NoteFrame frame = new NoteFrame();
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});

		Thread
				.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
					public void uncaughtException(Thread t, Throwable e) {
						e.printStackTrace();
					}
				});

	}
}
