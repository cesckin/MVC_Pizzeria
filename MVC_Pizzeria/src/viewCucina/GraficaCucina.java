package viewCucina;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.Ordinazione;
import viewCameriere.GraficaCameriere;

public class GraficaCucina {

	private GraficaCameriere grafica;

	public ControllerCameriere(GraficaCameriere grafica) {
		this.grafica = grafica;
		grafica.registraController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					grafica.cucinaPronto.setVisible(false);
					grafica.cucinaPreparo.setVisible(false);

					boolean segnalazioneCucina = false; // per il cameriere
					boolean pizzaConsegnata = false;
					boolean segnalazioneCameriere = false; // per la cucina

					Ordinazione ordinazione = new Ordinazione("", "");

					ordinazione.setPizza(grafica.comboBoxOrdinazioni.getSelectedItem().toString());
					ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());

					// Scrivo
					try {
						FileOutputStream fos = null;
						ObjectOutputStream oos = null;
						fos = new FileOutputStream("Ordini.lin");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(ordinazione);
						oos.flush();
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					segnalazioneCucina = true;

					waitTime(1000);

					if (segnalazioneCucina == true) {
						grafica.lblCameriere.setText(ordinazione.toStringCameriere());
					}

					waitTime(1000);

					// Leggo
					FileInputStream fis = null;
					ObjectInputStream ois = null;
					try {
						fis = new FileInputStream("Ordini.lin");
						ois = new ObjectInputStream(fis);
					} catch (IOException e1) {
					}
					
					try {
						Ordinazione ordinazione1 = (Ordinazione) ois.readObject();
					} catch (ClassNotFoundException | IOException e1) {
					}

					grafica.lblCucina.setText(ordinazione.toStringCucina());
					waitTime(1000);
					grafica.cucinaPreparo.setVisible(true);

					waitTime(1000);

					grafica.lblCucina.setText("Ho finito di preparare la pizza");

					grafica.cucinaPreparo.setVisible(false);
					grafica.cucinaPronto.setVisible(true);

					grafica.lblCameriere.setText("Ho consegnato il piatto");
				}
			});

		}

	}

	private void waitTime(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

}
