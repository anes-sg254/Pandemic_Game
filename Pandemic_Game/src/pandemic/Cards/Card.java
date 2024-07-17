package pandemic.Cards;
import pandemic.Roles.*;
/**
 * L'interface Card représente une carte du jeu Pandemic.
 */
public interface Card {
	
	/**
	 * La méthode comportement() permet de gérer ce qui se passe quand la carte est piochée.
	 */
	public void comportement(Player p);

	
}



