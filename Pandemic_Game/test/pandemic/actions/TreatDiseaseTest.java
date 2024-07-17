package pandemic.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import pandemic.Game;
import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Board.Sector;
import pandemic.Roles.GlobeTrotter;
import pandemic.Roles.Player;

public class TreatDiseaseTest {
	
	private static Game game;
	// test n°1 : teste de actOn
	@Test
	public void testActOnPlayerWithoutResearchStation() {
		// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Sector europe = new Sector("Europe", flue,1);
        City berlin = new City("Berlin", europe);
        //creation du player 
        Player manil =new GlobeTrotter("Manil Diaf",berlin,game);
        
	    TreateDiseaseAction action = new TreateDiseaseAction();
	    action.actOn(manil);
	    // Vérifier que la méthode n'a pas eu d'effet sur la ville
	    assertEquals(0, berlin.getDiseases().size());
	}
	
	// test n°2 : test de isPossible
	@Test
	public void testIsPossiblePlayerWithoutResearchStation() {
		// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Sector europe = new Sector("Europe", flue,1);
        City berlin = new City("Berlin", europe);
        // creation du player
        Player yanis =new GlobeTrotter("Yanis Gherdane",berlin,game);
	    TreateDiseaseAction action = new TreateDiseaseAction();
	    assertFalse(action.isPossible(yanis));
	}
	
	// test n°3 : teste de isPossible sans assez de cartes
	@Test
	public void testIsPossiblePlayerWithoutEnoughCards() {
		// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Sector europe = new Sector("Europe", flue,1);
        City berlin = new City("Berlin", europe);
        // creation du player
        Player yanis =new GlobeTrotter("Yanis Gherdane",berlin,game);
        
	 
	    TreateDiseaseAction action = new TreateDiseaseAction();
	    assertFalse(action.isPossible(yanis));
	}


	


	
	


}
