package model;

public class Ordinazione {
	
	private int numTavolo;
	private String pizza;
	private boolean stato;
	
	public Ordinazione(int numTavolo, String pizza, boolean stato) {
		super();
		this.numTavolo = numTavolo;
		this.pizza = pizza;
		this.stato = stato;
	}

	public int getNumTavolo() {
		return numTavolo;
	}

	public String getPizza() {
		return pizza;
	}

	public boolean isStato() {
		return stato;
	}

	public void setNumTavolo(int numTavolo) {
		this.numTavolo = numTavolo;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

}
