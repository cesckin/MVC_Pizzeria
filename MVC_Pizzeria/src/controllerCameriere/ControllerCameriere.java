package controllerCameriere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Ordinazione;
import viewCameriere.GraficaCameriere;

public class ControllerCameriere implements ActionListener {

	private GraficaCameriere grafica;

	public ControllerCameriere(GraficaCameriere grafica) {
		Ordinazione ordinazione = new Ordinazione("", "", false, false, false);
		this.grafica = grafica;
		grafica.registraController(this);
		grafica.getTextNotifiche().setText(ordinazione.toStringBenvenuto());
	}

	public void actionPerformed(ActionEvent e) {

		Ordinazione ordinazione = new Ordinazione("", "", false, false, false);

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {

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
			//

			grafica.getTextNotifiche().setText(ordinazione.toStringCameriere());

		}

		if (e.getActionCommand().equalsIgnoreCase("Consegna piatto")) {

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}
			//

			if ((ordinazione.isSegnalazioneCameriere() == false) && (ordinazione.isSegnalazioneCucina() == false)) {
				grafica.getTextNotifiche().setText("Mona, devi creare un'ordinazione...");
				JOptionPane.showMessageDialog(null, "Mona, crea un'ordinazione");

			} else if (ordinazione.isSegnalazioneCameriere() == false) {
				grafica.getTextNotifiche().setText(ordinazione.toStringPizzaInPreparazione());
				JOptionPane.showMessageDialog(null, "Aspetta la cucina");

			} else {

				ordinazione.setPizzaConsegnata(true);

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
				//

				grafica.getTextNotifiche().setText(ordinazione.toStringConsegnatoPiattoCameriere());

				try {
					FileWriter file = new FileWriter("Ordini.lin");
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Aggiorna")) {

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}
			//

			if (ordinazione.isSegnalazioneCucina() == false) {
				grafica.getTextNotifiche().setText("Mona, devi creare un'ordinazione...");
				JOptionPane.showMessageDialog(null, "Mona, crea un'ordinazione");

			} else {
				JOptionPane.showMessageDialog(null, "Pizza in preparazione...");
				grafica.getTextNotifiche().setText(ordinazione.toStringPizzaInPreparazione());
			}

			if (ordinazione.isSegnalazioneCameriere() == true) {
				JOptionPane.showMessageDialog(null, "Pizza pronta");
				grafica.getTextNotifiche().setText(ordinazione.toStringConsegnaPiatto());
			}

		}
	}

}
