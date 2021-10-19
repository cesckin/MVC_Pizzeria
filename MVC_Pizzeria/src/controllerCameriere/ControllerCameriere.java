package controllerCameriere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
import model.Ordinazione;
import viewCameriere.GraficaCameriere;

public class ControllerCameriere implements ActionListener {

	private GraficaCameriere grafica;

	public ControllerCameriere(GraficaCameriere grafica) {
		this.grafica = grafica;
		grafica.registraController(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {

			Ordinazione ordinazione = new Ordinazione("", "", false, false, false);

			ordinazione.setPizza(grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());
			ordinazione.setSegnalazioneCucina(true);

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

		}

	}

}
