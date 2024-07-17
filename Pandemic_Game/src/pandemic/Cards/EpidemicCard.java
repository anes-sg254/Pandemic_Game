package pandemic.Cards;
import pandemic.Roles.*;

import pandemic.Game;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card, PileCardPlayer{

	public void comportement(Player p) {
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections
			Game game=p.getGame();
			game.DrawAInfectionCardWhenEpidemic(p);
			game.IncreasedInfectionRate();
			game.shuffleInfectionCards(game.getDrawInfection());
			
			//Affichage
			System.out.println("The player "+ p.getName() + " has drawn an epidemic card.");




			
			
	}


} 
