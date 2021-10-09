package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Grafica;

public class Controller implements ActionListener {
	
	private Grafica grafica;
	
	public Controller(Grafica grafica) {
		
		this.grafica=grafica;
		
		grafica.registraController(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
