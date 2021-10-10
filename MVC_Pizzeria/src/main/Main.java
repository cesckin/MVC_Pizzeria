package main;

import controller.Controller;
import utility.Logger;
import model.Cameriere;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafica g = new Grafica();
		Cameriere c = new Cameriere();
		Logger l = new Logger();
		//Controller c = new Controller(g, t, l);
		g.setVisible(true);
	}

}
