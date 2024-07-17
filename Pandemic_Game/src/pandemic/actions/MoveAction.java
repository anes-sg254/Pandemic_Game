package pandemic.actions;
import pandemic.Roles.*;
import pandemic.Board.*;

import java.util.List;
import java.util.Scanner;



public class MoveAction implements Action {
	
	
	
	
	/**
	 *@param p  
	 *  return true si laction est possible 
	 *  false sinon 
	 */
	@Override
	public boolean isPossible(Player p) {
		City currentCity = p.getCity();
		List<City> neighbors = currentCity.getNeighborsCities();
		City destination = neighbors.get(this.getChoice()-1);;
		if (!neighbors.contains(destination)) {
			System.out.println("The player could not move \n !");
			return false;
		}
		return true;

}
	
	
	/**
	 * deplacement du joueur apres choisir ca ville voisine 
	 * @param player 
	 */
	@Override
	public void actOn(Player p) {
		City currentCity = p.getCity();
		List <City> neighbors = currentCity.getNeighborsCities();
		displayNeighbors(neighbors);
		int choice = getChoice();
		City destination =neighbors.get(choice-1); 
		p.setCity(destination);
		destination.addPlayer(p);
		//Affichage 
		System.out.println("The player : " + p.getName() + " moved from " + currentCity.getName()+ " to "  + destination.getName() +"\n");

	}
    
	
	/**
	 * return the number of the choice of the player 
	 */
	public int getChoice() {
		System.out.println("veuillez choisir la city ou aller selon le chiffre");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	}
    
	
	
	/**
	 *  elle affiche dans le terminal les ville a choisir 
	 * @param list de neighbors 
	 */
	public void displayNeighbors(List<City> neighbors) {
		int idx = 1;
		for(City n :neighbors ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}
     
	
	

}
