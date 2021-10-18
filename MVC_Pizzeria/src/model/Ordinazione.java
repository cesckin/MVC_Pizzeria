package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private String numTavolo;
	private String pizza;

	public Ordinazione(String numTavolo, String pizza) {
		super();
		this.numTavolo = numTavolo;
		this.pizza = pizza;
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

	public String toStringCameriere() {
		return "Effetuata ordinazione al tavolo "+ numTavolo + " di una " + pizza;
	}
	
	public String toStringCucina() {
		return "Ricevuta l'ordinazione del tavolo "+ numTavolo + " di una " + pizza;
	}
	
}
