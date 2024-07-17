package pandemic.Cards;
import pandemic.Game;
import pandemic.Board.*;
import pandemic.Roles.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import pandemic.Roles.*;
public class InfectionCardTest {
	
	   private Game game;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }

		/*
         * pour tester la méthode getCity on doit :
         * - comparer deux villes identiques avec la méthode assertEquals(), celle définit seule , et celle définit dans card
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
            InfectionCard card1=new InfectionCard(lille ,covid);
            assertEquals(lille,card1.getCity());
  
	    }

        /*
         * pour tester la méthode getDisease on doit :
         * - comparer deux maladies identiques avec la méthode assertEquals()
         * - on définit la Première maladie "ebola"
         * - on crée une carte card en respectant les elements de son constructeur
         * - pour que le test soit correct, il faut la methode assertEquals() renvoie true
         */
	    @Test
	    public void getDiseaseTest() {
            Disease ebola=new Disease("Ebola",3);		
		    Sector europe= new Sector("EUROPE",ebola,3);
            City lille=new City("LILLE",europe);
            InfectionCard card2=new InfectionCard(lille,ebola);
            assertEquals(ebola, card2.getDisease());
	    }



        /*
         * pour tester la méthode comportement() on doit :
         * - ajouter une infection à une ville donné. ici grippe
         * - nous avons initialisé le taux d'infection a 2 pour paris
         * - la méthode getInfectionRate() doit renvoyer 3, car nous avons ajouté une infection supplementaire avec la carte.
         * - pour que le test soit correct, la méthode assertEquals doit renvoyer "true"
         */
	    @Test
        public void comportementTest(){
            Disease grippe=new Disease("Grippe",2);		
		    Sector europe= new Sector("EUROPE",grippe,2);
            City paris =new City("PARIS",europe);
            Player p1 = new Doctor("p1",paris,game);
            paris.initDisease(grippe);
            InfectionCard card3=new InfectionCard(paris,grippe);
            card3.comportement(p1);
            assertEquals(1,paris.getinfectionRate(grippe));


        } 


}
