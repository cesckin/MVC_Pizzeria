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
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.setBounds(100, 100, 230, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnOrdina = new JButton("Ordina");
		btnOrdina.setBackground(SystemColor.menu);
		btnOrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdina.setBounds(66, 116, 75, 22);
		frame.getContentPane().add(btnOrdina);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setBackground(SystemColor.inactiveCaptionBorder);
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(new String[] {"Margherita", "Capricciosa", "Lin_Special", "Diavola", "Quattro_Formaggi", "Tonno", "Ingorda", "", "", ""}));
		comboBoxOrdinazioni.setBounds(19, 72, 98, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);

		comboBoxTavoli = new JComboBox();
		comboBoxTavoli.setBackground(SystemColor.inactiveCaptionBorder);
		comboBoxTavoli.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxTavoli.setBounds(127, 72, 51, 22);
		frame.getContentPane().add(comboBoxTavoli);
		
		btnConsegno = new JButton("Consegna piatto");
		btnConsegno.setBackground(SystemColor.menu);
		btnConsegno.setBounds(38, 149, 140, 23);
		frame.getContentPane().add(btnConsegno);
		
		textNotifiche = new JTextArea();
		textNotifiche.setLineWrap(true);
		textNotifiche.setEditable(false);
		textNotifiche.setBounds(10, 230, 195, 69);
		frame.getContentPane().add(textNotifiche);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBackground(SystemColor.menu);
		btnAggiorna.setBounds(61, 202, 92, 23);
		frame.getContentPane().add(btnAggiorna);
		
		JLabel lblTitolo = new JLabel("Pizzeria Lin");
		lblTitolo.setForeground(Color.DARK_GRAY);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Microsoft Sans Serif", lblTitolo.getFont().getStyle() | Font.BOLD | Font.ITALIC, 21));
		lblTitolo.setBounds(10, 21, 195, 28);
		frame.getContentPane().add(lblTitolo);
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
