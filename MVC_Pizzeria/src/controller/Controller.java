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

	public Controller(Grafica grafica) {

		this.grafica = grafica;
		grafica.registraController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Invia")) {

			String pizza = "";

			Ordinazione ordinazione = new Ordinazione(null, null, false, false, false);
			
			if ((grafica.comboBoxOrdinazioni.getSelectedIndex() == 0) || (grafica.comboBoxTavoli.getSelectedIndex() == 0)) {
				System.out.println("Devi inserire un ordinazione valida");
			} else {
				ordinazione.setPizza(pizza = grafica.comboBoxOrdinazioni.getSelectedItem().toString());
				ordinazione.setNumTavolo(grafica.comboBoxTavoli.getSelectedItem().toString());
				System.out.println("Cameriere ha inserito " + pizza + " nell'ordinazione");
				System.out.println(grafica.comboBoxTavoli.getSelectedItem().toString());
				String gigio = ordinazione.toString();
				System.out.println(gigio);
			}
			

		}

	}

}
