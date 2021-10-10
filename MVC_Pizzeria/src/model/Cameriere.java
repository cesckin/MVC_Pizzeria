package model;

import utility.Logger;

public class Cameriere {

	private Logger logger;

	public void registraProdotto(String prodotto) {
		logger.makeLog(prodotto);
		System.out.println("Cameriere ha inserito "+prodotto+" nell'ordinazione");
	}
	
	public void riceviSegnalazione(String segnalazione) {
		if(segnalazione == "Ho preparato") {
			
		}
		
	}
	
	
	
}
