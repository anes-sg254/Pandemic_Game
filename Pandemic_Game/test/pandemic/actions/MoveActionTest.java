package pandemic.actions;
import pandemic.Board.*;
import pandemic.Roles.*;
import org.junit.Before;
import pandemic.Game;

import org.junit.Test;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;






public class MoveActionTest {
    
  	private Game game;
	private String path;
	@Before        
	public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	}
	public int getChoice() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	}
    

    ////////////////////// LES TESTS /////////////////////////////////////////



    // Test n°1 : isPossible() si la destination est une ville voisine.

    @Test

    public void testActOnIfDestinationIsNeighbor() {

        //City lille = game.getWorld().getSectors().get(0).getCities().get(0); 
        //City paris = game.getWorld().getSectors().get(0).getCities().get(1);
         City tokyo = game.getWorld().getSectors().get(0).getCities().get(2);
        //City alger = game.getWorld().getSectors().get(0).getCities().get(3);

        

        // les joueurs

        //Player yanis = new Doctor("Yanis GHERDANE",lille,game);
       //Player manil = new Doctor("Manil DIAF",paris,game);
        Player anes = new Doctor("Anes Seghir",tokyo,game);
        //Player rayane = new Doctor("Rayane SLIMANI",alger,game);

        List <City> neighbors= tokyo.getNeighborsCities();
        

   
        MoveAction action = new MoveAction();
        
        action.actOn(anes);

        assertEquals(true,action.isPossible(anes));

        



    }



 



}