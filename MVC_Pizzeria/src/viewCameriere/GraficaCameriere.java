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

public class GraficaCameriere {

	private JFrame frame;
	private JButton btnOrdina;
	public JComboBox comboBoxOrdinazioni;
	public JComboBox comboBoxTavoli;
	public JLabel lblCucina;
	public JLabel lblCameriere;
	public JLabel lblImg;
	public JPanel cucinaPronto;
	public JPanel cucinaPreparo;

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
		frame.setBounds(100, 100, 715, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnOrdina = new JButton("Ordina");
		btnOrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdina.setBounds(110, 352, 89, 23);
		frame.getContentPane().add(btnOrdina);

		comboBoxOrdinazioni = new JComboBox();
		comboBoxOrdinazioni.setModel(new DefaultComboBoxModel(
				new String[] { "Margherita", "Capricciosa", "Diavola", "Quattro formaggi", "Ananas" }));
		comboBoxOrdinazioni.setBounds(89, 227, 106, 22);
		frame.getContentPane().add(comboBoxOrdinazioni);

		comboBoxTavoli = new JComboBox();
		comboBoxTavoli.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxTavoli.setBounds(86, 272, 129, 22);
		frame.getContentPane().add(comboBoxTavoli);
		
		lblCucina = new JLabel(".");
		lblCucina.setEnabled(false);
		lblCucina.setHorizontalAlignment(SwingConstants.LEFT);
		lblCucina.setBounds(160, 11, 316, 57);
		frame.getContentPane().add(lblCucina);
		
		lblCameriere = new JLabel(".");
		lblCameriere.setEnabled(false);
		lblCameriere.setHorizontalAlignment(SwingConstants.LEFT);
		lblCameriere.setBounds(306, 378, 286, 51);
		frame.getContentPane().add(lblCameriere);
		
		cucinaPronto = new JPanel();
		cucinaPronto.setBackground(Color.GREEN);
		cucinaPronto.setBounds(621, 26, 10, 10);
		frame.getContentPane().add(cucinaPronto);
		
		cucinaPreparo = new JPanel();
		cucinaPreparo.setBackground(Color.RED);
		cucinaPreparo.setBounds(641, 26, 10, 10);
		frame.getContentPane().add(cucinaPreparo);
		
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(GraficaCameriere.class.getResource("/view/Lin.PNG")));
		lblImg.setBounds(0, 0, 701, 498);
		frame.getContentPane().add(lblImg);
	}

	public JLabel getLblCucina() {
		return lblCucina;
	}

	public void setLblCucina(JLabel lblCucina) {
		this.lblCucina = lblCucina;
	}

	public JLabel getLblCameriere() {
		return lblCameriere;
	}

	public void setLblCameriere(JLabel lblCameriere) {
		this.lblCameriere = lblCameriere;
	}

	public JPanel getCucinaPronto() {
		return cucinaPronto;
	}

	public void setCucinaPronto(JPanel cucinaPronto) {
		this.cucinaPronto = cucinaPronto;
	}

	public JPanel getCucinaPreparo() {
		return cucinaPreparo;
	}

	public void setCucinaPreparo(JPanel cucinaPreparo) {
		this.cucinaPreparo = cucinaPreparo;
	}

	public void registraController(ControllerCameriere controller) {
		btnOrdina.addActionListener(controller);
	}
	
	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
}
