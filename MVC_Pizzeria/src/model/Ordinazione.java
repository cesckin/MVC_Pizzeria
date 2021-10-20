package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private String numTavolo;
	private String pizza;
	private boolean segnalazioneCucina; //pizza da fare
	private boolean pizzaConsegnata;	//pizza consegnata
	private boolean segnalazioneCameriere;	//pizza da consegnare

	public Ordinazione(String numTavolo, String pizza, boolean segnalazioneCucina, boolean pizzaConsegnata,
			boolean segnalazioneCameriere) {
		super();
		this.numTavolo = numTavolo;
		this.pizza = pizza;
		this.segnalazioneCucina = segnalazioneCucina; 
		this.pizzaConsegnata = pizzaConsegnata;
		this.segnalazioneCameriere = segnalazioneCameriere;
	}

	public String getNumTavolo() {
		return numTavolo;
	}

	public void setNumTavolo(String numTavolo) {
		this.numTavolo = numTavolo;
	}

	public String getPizza() {
		return pizza;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}

	public boolean isSegnalazioneCucina() {
		return segnalazioneCucina;
	}

	public void setSegnalazioneCucina(boolean segnalazioneCucina) {
		this.segnalazioneCucina = segnalazioneCucina;
	}

	public boolean isPizzaConsegnata() {
		return pizzaConsegnata;
	}

	public void setPizzaConsegnata(boolean pizzaConsegnata) {
		this.pizzaConsegnata = pizzaConsegnata;
	}

	public boolean isSegnalazioneCameriere() {
		return segnalazioneCameriere;
	}

	public void setSegnalazioneCameriere(boolean segnalazioneCameriere) {
		this.segnalazioneCameriere = segnalazioneCameriere;
	}

	public String toStringCameriere() {
		return "Effetuata ordinazione al tavolo " + numTavolo + " di una " + pizza;
	}

	public String toStringRicevutoPiattoCameriere() {
		return "Ricevuta l'ordinazione del tavolo " + numTavolo + " di una " + pizza;
	}
	
	public String toStringPreparatoPiattoCameriere() {
		return "Ok, ho preparato la pizza " + pizza + " del tavolo " + numTavolo;
	}
	
	public String toStringConsegnatoPiattoCameriere() {
		return "Ok, ho consegnato la pizza " + pizza + " al tavolo " + numTavolo;
	}
	public String toStringArrList() {
		return "tavolo n: " + numTavolo + " pizza: " + pizza;
	}
}
