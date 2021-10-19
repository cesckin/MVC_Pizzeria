package viewCucina;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllerCameriere.ControllerCameriere;
import controllerCucina.ControllerCucina;

public class GraficaCucina {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficaCucina window = new GraficaCucina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraficaCucina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public void registraController(ControllerCucina controller) {
		
	}

}
