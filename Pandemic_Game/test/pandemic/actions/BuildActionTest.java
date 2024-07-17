package pandemic.actions;
import pandemic.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import pandemic.Game;
import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Board.Sector;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.Doctor;
import pandemic.Roles.GlobeTrotter;
import pandemic.Roles.Player;
import pandemic.actions.BuildAction;

public class BuildActionTest {
	   private static Game game;
	   private static GlobeTrotter rayane1;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }

    // test n°1 : teste la mthode isPossible.
    @Test
    public void testIsPossibleWithMatchingPlayerCard() {
    	// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City lille = new City("Lille", europe);
        PlayerCard playerCard = new PlayerCard(lille, flue);
        
        Player yanis =new GlobeTrotter("Yanis Gherdane",lille,game);
    	
    	// Ajout d'une carte joueur associée à la ville du joueur
    	PlayerCard matchingCard = new PlayerCard(lille,grippe);
    	yanis.addPlayerCard(matchingCard);
    	
    	// Vérification que l'action est possible
    	BuildAction buildAction = new BuildAction();
    	assertTrue(buildAction.isPossible(yanis));
    }
 // test n°2 : verifier le fonctionnement de isPossible()
    @Test
    public void testIsPossibleWithoutMatchingPlayerCard(){
    	// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City lille = new City("Lille", europe);
        PlayerCard playerCard = new PlayerCard(lille, flue);
        
        Player rayane =new GlobeTrotter("Rayane Slimani",lille,game);
    	
         // Vérification que l'action n'est pas possible car aucune carte joueur n'est associée à la ville
    	BuildAction buildAction = new BuildAction();
    	assertFalse(buildAction.isPossible(rayane));
    }

    
    // test n°3 : verifie que aprés exécution de la fonction actOn, une station de recherche sera ajouté à la ville du joueur
    @Test
    public void testActOn() {
    	// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City lille = new City("Lille", europe);
        PlayerCard playerCard = new PlayerCard(lille, flue);
        
        Player manil =new GlobeTrotter("Manil Diaf",lille,game);
    	
    	// Ajout de la station de recherche à la ville
    	BuildAction buildAction = new BuildAction();
    	buildAction.actOn(manil);
    	
    	// Vérification que la ville contient maintenant une station de recherche
    	assertTrue(lille.hasResearchStation());
    }
    
    // test n°4 : verifie qu'une station de recherche se crie dans une ville, suite à l'éxécution de actOn
    @Test
    public void testActOn2() {
        // Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City berlin = new City("Berlin", europe);
        City paris = new City("Paris", europe);
        PlayerCard playerCard = new PlayerCard(berlin, flue);
        
        Player anes =new GlobeTrotter("Anes Seghir",berlin,game);
        
        // Création de l'action
        BuildAction buildAction = new BuildAction();
        
        // Appel de la méthode actOn sur le joueur
        anes.addPlayerCard(new PlayerCard(paris,flue));
        buildAction.actOn(anes);
        
        // Vérification que la ville a bien une station de recherche maintenant
        assertTrue(berlin.hasResearchStation());
        
       
    }

    

}
