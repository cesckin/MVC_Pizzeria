package viewCameriere;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import controllerCameriere.ControllerCameriere;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class GraficaCameriere {

	private JFrame frame;
	public JComboBox comboBoxOrdinazioni;
	public JComboBox comboBoxTavoli;
	private JButton btnOrdina;
	private JButton btnConsegno;
	private JLabel lblDialogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficaCameriere window = new GraficaCameriere();
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
	public GraficaCameriere() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnOrdina = new JButton("Ordina");
		btnOrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdina.setBounds(51, 99, 89, 23);
		frame.getContentPane().add(btnOrdina);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(
				new String[] { "Margherita", "Capricciosa", "Diavola", "Quattro formaggi", "Ananas" }));
		comboBoxOrdinazioni.setBounds(34, 21, 106, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);

		comboBoxTavoli = new JComboBox();
		comboBoxTavoli.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxTavoli.setBounds(32, 54, 129, 22);
		frame.getContentPane().add(comboBoxTavoli);
		
		btnConsegno = new JButton("Consegna piatto");
		btnConsegno.setBounds(51, 168, 110, 23);
		frame.getContentPane().add(btnConsegno);
		
		lblDialogo = new JLabel("\"TEXT\"");
		lblDialogo.setEnabled(false);
		lblDialogo.setBounds(10, 240, 288, 57);
		frame.getContentPane().add(lblDialogo);
	}

	public JLabel getLblDialogo() {
		return lblDialogo;
	}

	public void setLblDialogo(JLabel lblDialogo) {
		this.lblDialogo = lblDialogo;
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public void registraController(ControllerCameriere controller) {
		btnOrdina.addActionListener(controller);
		btnConsegno.addActionListener(controller);
	}
}
