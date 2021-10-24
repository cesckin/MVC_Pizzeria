package controllerCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Ordinazione;
import viewCameriere.GraficaCameriere;
import viewCucina.GraficaCucina;

public class ControllerCucina implements ActionListener {

	private GraficaCucina grafica;

	public ControllerCucina(GraficaCucina grafica) {
		this.grafica = grafica;
		grafica.registraController(this);
		try {
			FileWriter file = new FileWriter("Ordini.lin");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {

		Ordinazione ordinazione = new Ordinazione(null, null, false, false, false, false);

		FileInputStream fis = null;
		ObjectInputStream ois = null;

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
				grafica.getTextNotifiche().setText("Aspetta che il cameriere crei un ordinazione...");
				JOptionPane.showMessageDialog(null, "Aspetta un'ordinazione");
			} else {
				grafica.getTextNotifiche().setText(ordinazione.toStringRicevutoPiattoCameriere());
				grafica.getTextPizza().setText(ordinazione.toStringCibo());
				
			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Prepara pizza")) {

			// Leggo
			try {
				fis = new FileInputStream("Ordini.lin");
				ois = new ObjectInputStream(fis);
				ordinazione = (Ordinazione) ois.readObject();
			} catch (ClassNotFoundException | IOException e1) {
			}
			//

			if (ordinazione.isSegnalazioneCucina() == true) {

				ordinazione.setSegnalazioneCameriere(true);
				ordinazione.setPizzaPreparazione(false);
				grafica.getPanelGreen().setVisible(true);
				grafica.getPanelRed().setVisible(false);

				// scrivo
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

				grafica.getTextNotifiche().setText(ordinazione.toStringPreparatoPiattoCameriere());
				JOptionPane.showMessageDialog(null, "Pizza pronta, TRUE");
			} else {
				grafica.getTextNotifiche().setText("Aspetta che il cameriere crei un ordinazione...");
				JOptionPane.showMessageDialog(null, "Aspetta un'ordinazione");
			}
		}

	}

}
