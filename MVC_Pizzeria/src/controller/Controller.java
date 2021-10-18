package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
			
			boolean segnalazioneCucina = false;
			boolean pizzaConsegnata = false;
			boolean segnalazioneCameriere = false;
			
			Thread thread = new Thread();
			
			Ordinazione ordinazione = new Ordinazione("", "");

			FileOutputStream fos;
			ObjectOutputStream oos;

			ordinazione.setPizza(grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());

			try {
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
			} catch (InterruptedException e1) {
			}
			
			

		}

	}

}
