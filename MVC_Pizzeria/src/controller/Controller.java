package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ordinazione;
import view.Grafica;

public class Controller implements ActionListener {
	
	private Grafica grafica;
	
	public Controller(Grafica grafica) {
		
		this.grafica=grafica;
		grafica.registraController(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Invia")) {
			
			String pizza;
			
			Ordinazione ordinazione = new Ordinazione(0, null, false, false, false);
			ordinazione.setNumTavolo(1);
			ordinazione.setPizza(pizza = grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			ordinazione.setPizzaConsegnata(true);
			ordinazione.setSegnalazioneCameriere(true);
			ordinazione.setSegnalazioneCucina(true);
			
			String gigio = ordinazione.toString();
			
			System.out.println(gigio);
			
		}
		
	}

}
