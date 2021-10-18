package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Ordinazione;
import view.Grafica;

public class Controller implements ActionListener {

	private Grafica grafica;
	private Object object;

	public Controller(Grafica grafica) {

		this.grafica = grafica;
		grafica.registraController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Ordina")) {
			
			boolean segnalazioneCucina = false; //per il cameriere
			boolean pizzaConsegnata = false;
			boolean segnalazioneCameriere = false; //per la cucina
			
			Thread thread = new Thread();
			
			Ordinazione ordinazione = new Ordinazione("", "");

			

			ordinazione.setPizza(grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());

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
			
			try {
				thread.wait(2000);
			} catch (InterruptedException e1) {}
			
			segnalazioneCucina = true;
			if(segnalazione == true) {
				grafica.lblCameriere.
			}
			
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream("Elenco.dat");
				ois = new ObjectInputStream(fis);
			} catch (IOException e1) {}
			int i = 0;
			boolean continua = true;
			while (continua) {
				try {
					Ordinazione ordinazione1 = (Ordinazione) ois.readObject();
					System.out.println(i);
					System.out.println(ordinazione1);
				} catch (ClassNotFoundException | IOException e1) {
					continua = false;
				}
				i++;
			}

		}

	}

}
