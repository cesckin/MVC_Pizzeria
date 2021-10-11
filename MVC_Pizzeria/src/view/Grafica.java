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
	private JButton btnInvia;
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

		btnInvia = new JButton("Invia");
		btnInvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvia.setBounds(23, 11, 89, 23);
		frame.getContentPane().add(btnInvia);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(
				new String[] { "MENU", "Margherita", "Capricciosa", "Diavola", "Quattro formaggi", "Ananas" }));
		comboBoxOrdinazioni.setBounds(23, 44, 106, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);
	}

	public void registraController(Controller controller) {
		btnInvia.addActionListener(controller);
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
}
