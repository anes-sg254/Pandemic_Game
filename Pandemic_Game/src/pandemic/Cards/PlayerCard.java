package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

public class PlayerCard extends IntermediateCard implements PileCardPlayer{

    /**
     * Constructeur pour créer une carte joueur avec une ville et une maladie.
     * @param city la ville associée à la carte.
     * @param disease la maladie associée à la carte.
     */
    public PlayerCard(City city, Disease disease) {
        super(city, disease);
    }
    
    /**
     * Permet de gérer ce qui se passe lorsque la carte player est piochée :
     * la carte est donnée au joueur qui la pioche.
     * @param p le joueur qui pioche la carte.
     */
    public void comportement(Player player) {
        player.addPlayerCard(this);
      //Affichage
		System.out.println("The player "+ player.getName() + " has drawn a player card indicating the city of :"+ this.getCity() +",and disease : "+ this.getDisease());
    }
    
    
    public City getCity() {
    	return this.city;
    }
}
