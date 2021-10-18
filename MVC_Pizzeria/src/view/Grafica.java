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
import javax.swing.JPanel;
import java.awt.Color;

public class Grafica {

	private JFrame frame;
	private JButton btnOrdina;
	public JComboBox comboBoxOrdinazioni;
	public JComboBox comboBoxTavoli;
	public JLabel lblCucina;
	public JLabel lblCameriere;

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
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnOrdina = new JButton("Ordina");
		btnOrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdina.setBounds(40, 112, 89, 23);
		frame.getContentPane().add(btnOrdina);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(
				new String[] { "Margherita", "Capricciosa", "Diavola", "Quattro formaggi", "Ananas" }));
		comboBoxOrdinazioni.setBounds(23, 44, 106, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);

		comboBoxTavoli = new JComboBox();
		comboBoxTavoli.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxTavoli.setBounds(23, 79, 129, 22);
		frame.getContentPane().add(comboBoxTavoli);
		
		lblCucina = new JLabel("New label");
		lblCucina.setBounds(359, 28, 48, 14);
		frame.getContentPane().add(lblCucina);
		
		lblCameriere = new JLabel("New label");
		lblCameriere.setBounds(273, 200, 48, 14);
		frame.getContentPane().add(lblCameriere);
		
		JPanel cucinaPronto = new JPanel();
		cucinaPronto.setBackground(Color.GREEN);
		cucinaPronto.setBounds(374, 79, 10, 10);
		frame.getContentPane().add(cucinaPronto);
		
		JPanel cucinaPreparo = new JPanel();
		cucinaPreparo.setBackground(Color.RED);
		cucinaPreparo.setBounds(394, 79, 10, 10);
		frame.getContentPane().add(cucinaPreparo);
	}

	public void registraController(Controller controller) {
		btnOrdina.addActionListener(controller);
	}
	
	

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
}
