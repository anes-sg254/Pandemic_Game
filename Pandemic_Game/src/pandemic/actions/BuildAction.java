package pandemic.actions;

import java.util.List;

import pandemic.Board.City;
import pandemic.Cards.Card;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.*;

public class BuildAction implements Action {

	@Override
	public boolean isPossible(Player p) {
		
		// on récupère toutes les cartes joueur du joueur.
		List<PlayerCard> playerCards = p.getCards(); 
		// on récupère la ville où se trouve le joueur
		City city = p.getCity();
		// on vérifie si le joueur possède une carte joueur associée à la ville où il se trouve
		for (PlayerCard card : playerCards) {
			if(card.getCity().equals(city)) {
				return true;
			}
		}
		 // si aucune carte joueur n'est associée à la ville, l'action n'est pas possible
		return false;
	}
	
	@Override
	public void actOn(Player p) {
		if(isPossible(p)) {
			
		p.getCity().addResearchStation();
		//Affichage 
		System.out.println("The player : " + p.getName() + " has créated a research station in " + p.getCity()+ "!");

	}
	else {
		System.out.println(" Impossible to build a research station, the conditions are not met !!!");
	}

}
}
