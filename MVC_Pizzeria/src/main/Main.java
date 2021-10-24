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
		GraficaCucina graficaCucina = new GraficaCucina();
		graficaCucina.setVisible(true);
		ControllerCameriere controllerCameriere = new ControllerCameriere(graficaCameriere, graficaCucina);
		ControllerCucina controllerCucina = new ControllerCucina(graficaCucina);
		graficaCucina.getPanelGreen().setVisible(false);
		graficaCucina.getPanelRed().setVisible(false);
	}

}
