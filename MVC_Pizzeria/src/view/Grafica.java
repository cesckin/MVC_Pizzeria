package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Grafica {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
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
	public Grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Grafica.class.getResource("/view/CameriereCliente.jpg")));
		lblNewLabel.setBounds(0, 0, 649, 503);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void registraController(Controller controller) {
		//btnInvia.addActionListener(controller);
	}
	
	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
	
}
