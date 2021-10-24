package model;

import java.io.Serializable;

public class Ordinazione implements Serializable {

	private String numTavolo;
	private String pizza;
	private boolean segnalazioneCucina; // pizza da fare
	private boolean pizzaPreparazione; // pizza pronta
	private boolean segnalazioneCameriere; // pizza da consegnare
	private boolean pizzaConsegnata; // pizza consegnata

	public Ordinazione(String numTavolo, String pizza, boolean segnalazioneCucina, boolean pizzaPreparazione,boolean pizzaConsegnata,
			boolean segnalazioneCameriere) {
		super();
		this.numTavolo = numTavolo;
		this.pizza = pizza;
		this.segnalazioneCucina = segnalazioneCucina;
		this.pizzaPreparazione = pizzaPreparazione;
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

	public boolean isPizzaPreparazione() {
		return pizzaPreparazione;
	}

	public void setPizzaPreparazione(boolean pizzaPreparazione) {
		this.pizzaPreparazione = pizzaPreparazione;
	}

	public String toStringCibo() {
		return "Devi preparare una " + pizza + " per il tav. " + numTavolo;
	}

	public String toStringPizzaInPreparazione() {
		return "Aspetta la pizza " + pizza + " è in preparazione...";
	}

	public String toStringConsegnaPiatto() {
		return "La pizza " + pizza + " è pronta, consegnala al tavolo n. " + numTavolo;
	}

	public String toStringCameriere() {
		return "Effetuata ordinazione al tavolo " + numTavolo + " di una " + pizza;
	}

	public String toStringRicevutoPiattoCameriere() {
		return "Ricevuta l'ordinazione del tavolo " + numTavolo + " di una " + pizza;
	}

	public String toStringPreparatoPiattoCameriere() {
		return "Ho preparato la pizza " + pizza + " del tavolo " + numTavolo;
	}

	public String toStringConsegnatoPiattoCameriere() {
		return "Ho consegnato la pizza " + pizza + " al tavolo " + numTavolo;
	}

	public String toStringBenvenuto() {
		return "Benvenuto in pizza Listolante Lin...cosa vuole oldinale?";
	}

}
