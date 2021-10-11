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
		
		this.grafica=grafica;
		grafica.registraController(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Invia")) {
			
			String pizza;
			
			Ordinazione ordinazione = new Ordinazione(0, null, false, false, false);
			ordinazione.setNumTavolo(1);
			if(grafica.comboBoxOrdinazioni.getSelectedIndex() == 0) {
				System.out.println("Devi inserire un ordinazione valida");
			}
			else {
				ordinazione.setPizza(pizza = grafica.comboBoxOrdinazioni.getSelectedItem().toString());
			}
			ordinazione.setPizzaConsegnata(true);
			ordinazione.setSegnalazioneCameriere(true);
			ordinazione.setSegnalazioneCucina(true);
			
			String gigio = ordinazione.toString();
			System.out.println(gigio);
			
			FileOutputStream fos;
			ObjectOutputStream oos;
			
			try {
				fos = new FileOutputStream("elenco.dat");
				oos = new ObjectOutputStream(fos);
				fos.close();
			} catch (IOException e2 ) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				
			}
		
		}
		
	}

}
