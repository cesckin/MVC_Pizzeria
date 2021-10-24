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

public class GraficaCucina {

	private JFrame frame;
	private JButton btnControllo;
	private JButton btnPreparo;
	private JTextArea textNotifiche;
	private JLabel lblTitolo;
	private JTextField textPizza;

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
		frame.setBounds(100, 100, 261, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnControllo = new JButton("Aggiorna");
		btnControllo.setBounds(59, 88, 97, 23);
		frame.getContentPane().add(btnControllo);

		btnPreparo = new JButton("Prepara pizza");
		btnPreparo.setBounds(59, 122, 97, 23);
		frame.getContentPane().add(btnPreparo);
		
		textNotifiche = new JTextArea();
		textNotifiche.setEditable(false);
		textNotifiche.setLineWrap(true);
		textNotifiche.setBounds(23, 211, 195, 70);
		frame.getContentPane().add(textNotifiche);
		
		lblTitolo = new JLabel("Pizzeria Lin");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.DARK_GRAY);
		lblTitolo.setBounds(23, 16, 195, 28);
		frame.getContentPane().add(lblTitolo);
		
		textPizza = new JTextField();
		textPizza.setEditable(false);
		textPizza.setBounds(10, 54, 227, 23);
		frame.getContentPane().add(textPizza);
		textPizza.setColumns(10);
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public JTextField getTextPizza() {
		return textPizza;
	}

	public void setTextPizza(JTextField textPizza) {
		this.textPizza = textPizza;
	}

	public JTextArea getTextNotifiche() {
		return textNotifiche;
	}

	public void setTextNotifiche(JTextArea textNotifiche) {
		this.textNotifiche = textNotifiche;
	}

	public void registraController(ControllerCucina controller) {
		btnControllo.addActionListener(controller);
		btnPreparo.addActionListener(controller);
	}
}
