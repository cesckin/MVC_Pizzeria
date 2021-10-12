package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private String numTavolo;
	private Object pizza;
	private boolean segnalazioneCucina;
	private boolean pizzaConsegnata;
	private boolean segnalazioneCameriere;

	public Ordinazione(String numTavolo, String pizza, boolean segnalazioneCucina, boolean pizzaConsegnata, boolean segnalazioneCameriere) {
		super();
		this.numTavolo = numTavolo;
		this.pizza = pizza;
		this.segnalazioneCucina = false;
		this.pizzaConsegnata = false;
		this.segnalazioneCameriere = false;
	}

	public String getNumTavolo() {
		return numTavolo;
	}

	public void setNumTavolo(String numTavolo) {
		this.numTavolo = numTavolo;
	}

	public Object getPizza() {
		return pizza;
	}

	public void setPizza(Object object) {
		this.pizza = object;
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

}
