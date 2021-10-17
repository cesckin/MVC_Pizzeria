package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Ordinazione;
import view.Grafica;
import utility.Object;

public class Controller implements ActionListener {

	private Grafica grafica;
	private Object object;

	public Controller(Grafica grafica) {

		this.grafica = grafica;
		grafica.registraController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Invia")) {

			String pizza = "";

			Ordinazione ordinazione = new Ordinazione("", "");

			if ((grafica.comboBoxOrdinazioni.getSelectedIndex() == 0) || (grafica.comboBoxTavoli.getSelectedIndex() == 0)) {
				System.out.println("Devi inserire un ordinazione valida");
			} else {

				boolean segnalazioneCucina;
				boolean pizzaConsegnata;
				boolean segnalazioneCameriere;

				FileOutputStream fos;
				ObjectOutputStream oos;

				ordinazione.setPizza(pizza = grafica.comboBoxOrdinazioni.getSelectedItem().toString());
				ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());
				
				//INUTILE
				System.out.println("Cameriere ha inserito " + pizza + " nell'ordinazione");
				System.out.println(grafica.comboBoxTavoli.getSelectedItem().toString());
				String gigio = ordinazione.toString();
				System.out.println(gigio);
				//INUTILE
				
				try {
					fos = new FileOutputStream("Comande.dat");
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

}
