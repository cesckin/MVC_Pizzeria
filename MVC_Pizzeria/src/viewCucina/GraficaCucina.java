package viewCucina;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controllerCameriere.ControllerCameriere;
import controllerCucina.ControllerCucina;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GraficaCucina {

	private JFrame frame;
	private JButton btnControllo;
	private JButton btnPreparo;
	private JButton btnConsegna;
	private JLabel lblDiscorso;

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
		frame.setBounds(100, 100, 395, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnControllo = new JButton("Controllo ordinazione");
		btnControllo.setBounds(77, 100, 133, 23);
		frame.getContentPane().add(btnControllo);

		btnPreparo = new JButton("Prepara pizza");
		btnPreparo.setBounds(99, 134, 97, 23);
		frame.getContentPane().add(btnPreparo);

		btnConsegna = new JButton("Consegno pizza");
		btnConsegna.setBounds(89, 168, 107, 23);
		frame.getContentPane().add(btnConsegna);

		lblDiscorso = new JLabel("\"TEXT\"");
		lblDiscorso.setBounds(46, 202, 204, 69);
		frame.getContentPane().add(lblDiscorso);
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}

	public JLabel getLblDiscorso() {
		return lblDiscorso;
	}

	public void setLblDiscorso(JLabel lblDiscorso) {
		this.lblDiscorso = lblDiscorso;
	}

	public void registraController(ControllerCucina controller) {
		btnControllo.addActionListener(controller);
		btnPreparo.addActionListener(controller);
		btnConsegna.addActionListener(controller);
	}

}
