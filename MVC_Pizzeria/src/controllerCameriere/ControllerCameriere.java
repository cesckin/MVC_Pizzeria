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
import viewCucina.GraficaCucina;

public class ControllerCameriere implements ActionListener {

	private GraficaCameriere graficaCameriere;
	private GraficaCucina graficaCucina;

	public ControllerCameriere(GraficaCameriere graficaCameriere, GraficaCucina graficaCucina) {
		super();
		this.graficaCameriere = graficaCameriere;
		this.graficaCucina = graficaCucina;
		graficaCameriere.registraController(this);
		Ordinazione ordinazione = new Ordinazione("", "", false, false, false, false);
		graficaCameriere.getTextNotifiche().setText(ordinazione.toStringBenvenuto());
	}

	public void actionPerformed(ActionEvent e) {

		Ordinazione ordinazione = new Ordinazione("", "", false, false, false, false);

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}
			//

			if (ordinazione.isSegnalazioneCucina() == true) {
				graficaCameriere.getTextNotifiche().setText("Stanno già elaborando un'altra ordinazione...");
				JOptionPane.showMessageDialog(null, "Stanno già elaborando un'altra ordinazione...");
			} else {
				ordinazione.setPizza(graficaCameriere.comboBoxOrdinazioni.getSelectedItem().toString());
				ordinazione.setNumTavolo(graficaCameriere.comboBoxTavoli.getSelectedItem().toString());
				ordinazione.setSegnalazioneCucina(true);
				ordinazione.setPizzaPreparazione(true);

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
				graficaCucina.getPanelGreen().setVisible(false);
				graficaCucina.getPanelRed().setVisible(true);
				graficaCameriere.getTextNotifiche().setText(ordinazione.toStringCameriere());
			}
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
				graficaCameriere.getTextNotifiche().setText("Mona, devi creare un'ordinazione...");
				JOptionPane.showMessageDialog(null, "Mona, crea un'ordinazione");

			} else if (ordinazione.isSegnalazioneCameriere() == false) {
				graficaCameriere.getTextNotifiche().setText(ordinazione.toStringPizzaInPreparazione());
				JOptionPane.showMessageDialog(null, "Pizza in preparazione...");

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
				JOptionPane.showMessageDialog(null, ordinazione.toStringConsegnatoPiattoCameriere());
				graficaCameriere.getTextNotifiche().setText(ordinazione.toStringConsegnatoPiattoCameriere());

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
				graficaCameriere.getTextNotifiche().setText("Mona, devi creare un'ordinazione...");
				JOptionPane.showMessageDialog(null, "Mona, crea un'ordinazione");
			}

			if (ordinazione.isPizzaPreparazione() == true) {
				JOptionPane.showMessageDialog(null, "Pizza in preparazione...");
				graficaCameriere.getTextNotifiche().setText(ordinazione.toStringPizzaInPreparazione());
			}

			if (ordinazione.isSegnalazioneCameriere() == true) {
				JOptionPane.showMessageDialog(null, "Pizza pronta per essere consegnata");
				graficaCameriere.getTextNotifiche().setText(ordinazione.toStringConsegnaPiatto());
			}

		}
	}

}
