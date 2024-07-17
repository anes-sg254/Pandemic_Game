package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;
import org.junit.Before;
import pandemic.Game;
import java.io.FileNotFoundException;
import java.util.Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpidemicCardTest {
   	   private Game game;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }
	   
	   
		
		

      @Test
      public void comportement(){
    	City city = game.getWorld().getSectors().get(0).getCities().get(0);
        Player anes=new Doctor("ANES",city,game);
        game.getPlayers().add(anes);

        EpidemicCard epidemiccard=new EpidemicCard();
      

        Stack<InfectionCard> infectioncards=game.getDrawInfection();
        int sizeBeforeDraw = infectioncards.size();
        epidemiccard.comportement(anes);
        //vérification si on a bien retiré une carte
        assertEquals(infectioncards.size()+1,sizeBeforeDraw);
        // vérification si le taux d'infection a augmenté
       assertEquals(3,game.getTotalInfectionRate());
        



      }  
  
   
	    

}
