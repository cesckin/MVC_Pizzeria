package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import model.Ordinazione;
import controller.Time;
import view.Grafica;

public class Controller implements ActionListener {

	private Grafica grafica;

	public Controller(Grafica grafica) {

		this.grafica = grafica;
		grafica.registraController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {
			
			grafica.cucinaPronto.setVisible(false);
			grafica.cucinaPreparo.setVisible(false);

			boolean segnalazioneCucina = false; // per il cameriere
			boolean pizzaConsegnata = false;
			boolean segnalazioneCameriere = false; // per la cucina
			
			Ordinazione ordinazione = new Ordinazione("", "");

			ordinazione.setPizza(grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());
			
			//Scrivo
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
			
			Time.wait(1000);
			
			if (segnalazioneCucina == true) {
				grafica.lblCameriere.setText(ordinazione.toStringCameriere());
			}
			
			//Leggo
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

			Time.wait(1000);
			
			grafica.lblCucina.setText(ordinazione.toStringCucina());
			
			grafica.cucinaPreparo.setVisible(true);
			
			grafica.lblCucina.setText("Ho finito di preparare la pizza");
			
			grafica.cucinaPreparo.setVisible(false);
			grafica.cucinaPronto.setVisible(true);
			
			grafica.lblCameriere.setText("Ho consegnato il piatto");
		}

	}

}
