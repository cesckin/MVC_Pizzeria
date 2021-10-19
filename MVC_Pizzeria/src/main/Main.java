package main;

import controllerCameriere.ControllerCameriere;
import controllerCucina.ControllerCucina;
import viewCameriere.GraficaCameriere;
import viewCucina.GraficaCucina;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraficaCameriere graficaCameriere = new GraficaCameriere();
		graficaCameriere.setVisible(true);
		ControllerCameriere controllerCameriere = new ControllerCameriere(graficaCameriere);
		GraficaCucina graficaCucina = new GraficaCucina();
		graficaCucina.setVisible(true);
		ControllerCucina controllerCucina = new ControllerCucina(graficaCucina);
	}

}
