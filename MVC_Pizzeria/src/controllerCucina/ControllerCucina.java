package controllerCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.SwingUtilities;

import model.Ordinazione;
import viewCameriere.GraficaCameriere;
import viewCucina.GraficaCucina;

public class ControllerCucina implements ActionListener {

	private GraficaCucina grafica;

	public void ControllerCucina(GraficaCucina grafica) {
		this.grafica = grafica;
		grafica.registraController(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {

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
		}

	}

}
