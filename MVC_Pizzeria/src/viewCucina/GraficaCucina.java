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
		btnControllo.setBounds(46, 54, 133, 23);
		frame.getContentPane().add(btnControllo);

		btnPreparo = new JButton("Prepara pizza");
		btnPreparo.setBounds(56, 89, 97, 23);
		frame.getContentPane().add(btnPreparo);

		lblDiscorso = new JLabel("\"TEXT\"");
		lblDiscorso.setBounds(46, 202, 310, 76);
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
	}

}
