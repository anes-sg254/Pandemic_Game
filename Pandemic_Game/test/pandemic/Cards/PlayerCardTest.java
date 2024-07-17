package pandemic.Cards;
import pandemic.Game;
import pandemic.Board.*;
import static org.junit.Assert.*;
import pandemic.Roles.*;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class PlayerCardTest {

	   private Game game;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }
        /*
         * pour tester la méthode getCity on doit :
         * - comparer deux villes identiques avec la méthode assertEquals(), celle définit seule , et celle définit dans la carte player
         * - on définit la ville (lille). pour cela, il faut d'abord définir un secteur afin respecter les éléments du constructeur de City
         * - idem : pour définir un secteur il nous faut au préalable une maladie.
         * - on compare cette ville (lille) avec celle de la carte (ici card) qui doit etre lille
         * - la creation de card nécessite egalement une ville (lille) et une maladie(covid)
         * - pour que le test soit juste, il faut que la fonction renvoie "True"
         */
		@Test  
	    public void getCityTest() {
            Disease covid =new Disease("covid19",2);		
		    Sector europe = new Sector("EUROPE",covid,2);
            City lille =new City("LILLE",europe);
            PlayerCard card1 = new PlayerCard(lille ,covid);
            assertEquals(lille,card1.getCity());
  
	    }

        /*
         * pour tester la méthode getDisease on doit :
         * - comparer deux maladies identiques avec la méthode assertEquals()
         * - on définit la Première maladie "ebola"
         * - on crée une carte joueur card2 en respectant les elements de son constructeur
         * - pour que le test soit correct, il faut la methode assertEquals() renvoie True
         */
	    @Test
	    public void getDiseaseTest() {
            Disease ebola=new Disease("Ebola",3);		
		    Sector europe= new Sector("EUROPE",ebola,3);
            City lille=new City("LILLE",europe);
            PlayerCard card2= new PlayerCard(lille,ebola);
            assertEquals(ebola, card2.getDisease());
	    }
       /**
       ce test est effectué pour vérifier le comportement de la méthode comportement()
       */
       @Test 
       public void ComportementTest(){
            Disease ebola=new Disease("Ebola",2);		
		    Sector europe= new Sector("EUROPE",ebola,2);
            City lille=new City("LILLE",europe);
            Player anes=new Doctor("ANES",lille,game);
            PlayerCard card2= new PlayerCard(lille,ebola);
            card2.comportement(anes);
            assertTrue(anes.getCards().contains(card2));         

       }   
	    
}