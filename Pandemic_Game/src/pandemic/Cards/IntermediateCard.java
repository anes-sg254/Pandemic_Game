package pandemic.Cards;
import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Roles.*;


/*
 * j'ai crée cette classe pour joindre les informations communes entre EpidemicCard et InfectionCard et éviter les répétions
 */
public abstract class IntermediateCard implements Card{

	
	// la ville associée à la carte
	protected City city;
	// la maladie associée à la carte
	protected Disease disease;

	/**
	 * Constructeur d'une carte intermédiaire
	 * @param city la ville associée à la carte
	 * @param disease la maladie associée à la carte
	 */
	public IntermediateCard(City city, Disease disease) {
		this.city = city;
		this.disease = disease;
	}

	/**
	 * Retourne la ville associée à la carte
	 * @return la ville associée à la carte
	 */
	public City getCity() {
		return this.city;
	}

	/**
	 * Retourne la maladie associée à la carte
	 * @return la maladie associée à la carte
	 */
	public Disease getDisease() {
		return this.disease;
	}

	/**
	 * Permet de gérer ce qui se passe lorsqu'une carte intermédiaire est piochée.
	 * Cette méthode est vide car les cartes intermédiaires n'ont pas d'effet particulier lorsqu'elles sont piochées.
	 */
	public abstract void comportement(Player p);

	/**
	 * Méthode pour vérifier l'égalité entre deux cartes (d'infection et d'epidémie).
	 * @param o l'objet à comparer avec la carte actuelle
	 * @return true si les deux cartes ont la même ville et la même maladie, false sinon
	 */
	public boolean equals(Object o) {
		if(!(o instanceof IntermediateCard)) {
			return false;
		}
		IntermediateCard other = (IntermediateCard) o;
		return this.city.getName().equals(other.getCity().getName()) && this.disease.equals(other.getDisease());
	}

	
	
	
	

		
		
}
