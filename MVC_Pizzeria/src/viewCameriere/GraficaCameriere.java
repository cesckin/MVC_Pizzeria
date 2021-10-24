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
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

public class GraficaCameriere {

	private JFrame frame;
	public JComboBox comboBoxOrdinazioni;
	public JComboBox comboBoxTavoli;
	private JButton btnOrdina;
	private JButton btnConsegno;
	private JButton btnAggiorna;
	private JTextArea textNotifiche;
	private JLabel lblSfondo;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.setBounds(100, 100, 319, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnOrdina = new JButton("Ordina");
		btnOrdina.setBackground(new Color(153, 204, 102));
		btnOrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdina.setBounds(115, 157, 75, 22);
		frame.getContentPane().add(btnOrdina);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setBackground(SystemColor.inactiveCaptionBorder);
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(new String[] {"Margherita", "Capricciosa", "Lin_Special", "Diavola", "Quattro_Formaggi", "Tonno", "Ingorda", "", "", ""}));
		comboBoxOrdinazioni.setBounds(83, 124, 98, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);

		comboBoxTavoli = new JComboBox();
		comboBoxTavoli.setBackground(SystemColor.inactiveCaptionBorder);
		comboBoxTavoli.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxTavoli.setBounds(186, 124, 37, 22);
		frame.getContentPane().add(comboBoxTavoli);
		
		btnConsegno = new JButton("Consegna piatto");
		btnConsegno.setBackground(SystemColor.activeCaption);
		btnConsegno.setBounds(83, 209, 140, 23);
		frame.getContentPane().add(btnConsegno);
		
		textNotifiche = new JTextArea();
		textNotifiche.setBackground(SystemColor.menu);
		textNotifiche.setLineWrap(true);
		textNotifiche.setEditable(false);
		textNotifiche.setBounds(83, 236, 140, 69);
		frame.getContentPane().add(textNotifiche);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBackground(new Color(255, 255, 153));
		btnAggiorna.setBounds(106, 183, 92, 23);
		frame.getContentPane().add(btnAggiorna);
		
		lblSfondo = new JLabel("");
		lblSfondo.setBackground(new Color(51, 51, 51));
		lblSfondo.setIcon(new ImageIcon(GraficaCameriere.class.getResource("/viewCameriere/Cameriere.png")));
		lblSfondo.setBounds(0, 0, 305, 418);
		frame.getContentPane().add(lblSfondo);
	}

	public JTextArea getTextNotifiche() {
		return textNotifiche;
	}

	public void setTextNotifiche(JTextArea textArea) {
		this.textNotifiche = textArea;
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public void registraController(ControllerCameriere controller) {
		btnOrdina.addActionListener(controller);
		btnConsegno.addActionListener(controller);
		btnAggiorna.addActionListener(controller);
	}
}
