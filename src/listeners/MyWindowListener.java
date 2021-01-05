package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import serialization.Serialization;
import view.MainFrame;

public class MyWindowListener implements WindowListener {

private static MyWindowListener instance=null;	

	private MyWindowListener() {
		
	}
	
	public static  MyWindowListener getInstance() {
		// TODO Auto-generated method stub
		if(instance==null) {
			instance= new MyWindowListener();
		}
		return instance;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		JFrame frame =MainFrame.getInstance();
		String message = MainFrame.getInstance().getResourceBundle().getString("closeMsg");
		String title = MainFrame.getInstance().getResourceBundle().getString("closeTitle");
		int code = JOptionPane.showConfirmDialog(frame, message,
				title, JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			try {
                Serialization.sacuvajObjekte("objekti.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			System.exit(0);
		}

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
