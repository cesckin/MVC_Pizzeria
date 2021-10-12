package main;

import controller.Controller;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafica g = new Grafica();
		Controller con = new Controller(g);
		g.setVisible(true);
	}

}
