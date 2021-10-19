package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private String numTavolo;
	private String pizza;
	private boolean segnalazioneCucina;
	private boolean pizzaConsegnata;
	private boolean segnalazioneCameriere;

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

	public String toStringCucina() {
		return "Ricevuta l'ordinazione del tavolo " + numTavolo + " di una " + pizza;
	}

}
