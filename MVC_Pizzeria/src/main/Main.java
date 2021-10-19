package main;

import controllerCameriere.ControllerCameriere;
import viewCameriere.GraficaCameriere;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraficaCameriere g = new GraficaCameriere();
		g.setVisible(true);
		ControllerCameriere con = new ControllerCameriere(g);
	}

}
