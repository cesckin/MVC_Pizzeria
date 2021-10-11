package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Grafica {

	private JFrame frame;
	public JComboBox comboBoxOrdinazioni;

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
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(457, 106, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setModel(
		new DefaultComboBoxModel(new String[] { "ORDINAZIONI","pizza margherita","pizza capricciosa","pizza alla diavola", "pizza ai quattro formaggi","pizza all'ananas" }));
		comboBoxOrdinazioni.setBounds(130, 197, 106, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);
	}
	
	public void registraController(Controller controller) {
		//btnInvia.addActionListener(controller);
	}
	
	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
}
