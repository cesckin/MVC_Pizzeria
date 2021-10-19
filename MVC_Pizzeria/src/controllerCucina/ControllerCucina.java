package controllerCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import model.Ordinazione;
import viewCameriere.GraficaCameriere;
import viewCucina.GraficaCucina;

public class ControllerCucina implements ActionListener {

	private GraficaCucina grafica;

	public ControllerCucina(GraficaCucina grafica) {
		this.grafica = grafica;
		grafica.registraController(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Controllo ordinazione")) {

			FileInputStream fis = null;
			ObjectInputStream ois = null;
			Ordinazione ordinazione = new Ordinazione(null, null, false, false, false);

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
			} catch (IOException e1) {
			}

			try {
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}

			if (ordinazione.isSegnalazioneCucina() == false) {
				grafica.getLblDiscorso().setText("Aspetta che il cameriere crei un ordinazione...");
			} else {
				grafica.getLblDiscorso().setText(ordinazione.toStringRicevutoPiattoCameriere());
			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Prepara pizza")) {

			FileInputStream fis = null;
			ObjectInputStream ois = null;
			Ordinazione ordinazione = new Ordinazione(null, null, false, false, false);

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
			} catch (IOException e1) {
			}

			try {
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}

			if (ordinazione.isSegnalazioneCucina() == true) {
			
				ordinazione.setSegnalazioneCameriere(true);
				
				//scrivo
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
				
				grafica.getLblDiscorso().setText(ordinazione.toStringPreparatoPiattoCameriere());

			}
		}

	}

}
