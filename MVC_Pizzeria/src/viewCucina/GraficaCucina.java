package viewCucina;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllerCameriere.ControllerCameriere;
import controllerCucina.ControllerCucina;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class GraficaCucina {

	private JFrame frame;
	private JButton btnControllo;
	private JButton btnPreparo;
	private JTextArea textNotifiche;
	private JPanel panelGreen;
	private JPanel panelRed;

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
		frame.setBounds(100, 100, 431, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnControllo = new JButton("Aggiorna");
		btnControllo.setForeground(SystemColor.text);
		btnControllo.setBackground(SystemColor.textInactiveText);
		btnControllo.setBounds(227, 155, 96, 23);
		frame.getContentPane().add(btnControllo);

		btnPreparo = new JButton("Prepara pizza");
		btnPreparo.setForeground(SystemColor.text);
		btnPreparo.setBackground(SystemColor.textInactiveText);
		btnPreparo.setBounds(92, 155, 132, 23);
		frame.getContentPane().add(btnPreparo);

		textNotifiche = new JTextArea();
		textNotifiche.setBackground(SystemColor.controlHighlight);
		textNotifiche.setEditable(false);
		textNotifiche.setLineWrap(true);
		textNotifiche.setBounds(116, 29, 265, 35);
		frame.getContentPane().add(textNotifiche);

		panelGreen = new JPanel();
		panelGreen.setBackground(new Color(124, 252, 0));
		panelGreen.setBounds(42, 36, 23, 23);
		frame.getContentPane().add(panelGreen);

		panelRed = new JPanel();
		panelRed.setBackground(new Color(255, 0, 0));
		panelRed.setBounds(81, 36, 25, 24);
		frame.getContentPane().add(panelRed);

		JLabel lblSfondo = new JLabel("");
		lblSfondo.setIcon(new ImageIcon(GraficaCucina.class.getResource("/viewCucina/Cucina.png")));
		lblSfondo.setBounds(0, 0, 457, 343);
		frame.getContentPane().add(lblSfondo);
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public JTextArea getTextNotifiche() {
		return textNotifiche;
	}

	public void setTextNotifiche(JTextArea textNotifiche) {
		this.textNotifiche = textNotifiche;
	}

	public JPanel getPanelGreen() {
		return panelGreen;
	}

	public void setPanelGreen(JPanel panelGreen) {
		this.panelGreen = panelGreen;
	}

	public JPanel getPanelRed() {
		return panelRed;
	}

	public void setPanelRed(JPanel panelRed) {
		this.panelRed = panelRed;
	}

	public void registraController(ControllerCucina controller) {
		btnControllo.addActionListener(controller);
		btnPreparo.addActionListener(controller);
	}
}
