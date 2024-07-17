package pandemic.Board;
import pandemic.Roles.*;

import java.util.*;

public class City {  
	private String name;     // the name of the city
	private Map<Disease, Integer> infectionRate;  // infectionRate of each disease
	private List <City>neighbors;  // the neighbors cities of the city
	private List<Player> players;  // the current players on this city
	private Sector sector;  // the sector which the city belongs to 
	private boolean researchStation;  //the researchStation of the city
	private boolean foyerInfection;  // is the city  a foyerInfection or not
	private boolean AlreadyInfectedDuringRound;
	
	public City(String name, Sector sector) {  // we create a city with a name and a sector
		this.name= name;	
		this.neighbors=new ArrayList<>();
		this.infectionRate= new HashMap<>();
		
		this.sector=sector;
		this.players=new ArrayList<>();
		this.researchStation=false;
		this.foyerInfection=false;
		this.AlreadyInfectedDuringRound=false;
	}
	
	

	/**
	 * return the name of the city
	 * @return a string which is the name of the city
	 */
	public String getName(){ 
		return this.name;
	}

	/**
	 * return the infectionRate of a specified disease
	 * @param disease // the disease we want to get its infectionRate
	 * @return a int (0 or 1 or 2 or 3) which represent the number of cubes of this disease in the city
	 */
	public int getinfectionRate(Disease disease){
		return this.infectionRate.get(disease);
	}
	
	public Map<Disease, Integer> getDiseases(){
		return this.infectionRate;
	}


	/**
	 * return the infectionRate of all the diseases
	 * @return a int represent the number of cubes of all the diseases in the city
	 */
	public int getTotalinfectionRate(){
		int total =0;
		for (int i : this.infectionRate.values()){
			total+=i;
		}
		return total;
	}

	/**
	 * return the list of the neighbors cities
	 * @return a List<City>
	 */
	public List <City> getNeighborsCities(){
		return this.neighbors;
	}
	
	/*
	/**
	 * return the list of the current players on this city
	 * @return a List<Player>
	
	public List<Player> getCurrentPlayers(){
		return this.players;
	}
	*/

	/**
	 * @return the sector of this city
	 */
	public Sector getSector(){
		return this.sector;
	}


	
	public void addNeighbor(City city){
		this.neighbors.add(city);
	}
	
	/**
	 *  add a player on the city
	 * @param player to add
	 */
	public void addPlayer(Player player) {
		if(!(this.players.contains(player))){
			this.players.add(player);
		}	
	}

	/**
	 * remove a player on the city
	 * @param player to remove
	 */
	public void removePlayer(Player player){
		this.players.remove(player);
	}

	/**
	 * return the list of the player on the city
	 * @return the list of the player on the city
	 */
	public List<Player> getPlayers(){
		return this.players;
	}


	/**
	 * @return True if there is at least one cube of any disease , false other ways
	 */
	public boolean isInfected(){
		for (int i : this.infectionRate.values()){
			if (i>0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return True if the city has been infected during the round , false other ways
	 */
	public boolean isAlreadyInfectedDuringRound(){
		return this.AlreadyInfectedDuringRound;
	}
	
	/**
	 * @return reset the attribute alreadyInfectedDuringRound after each round 
	 */
	public void resetAlreadyInfectedDuringRound(){
		this.AlreadyInfectedDuringRound=false;
	}
	
	

	/** add one cube of the disease given in param
	 * if the number of cubes of this disease is already 3 it will infect all the neighbors
	 * it will add a cube other ways
	 * and the city will be a foyerInfection
	 * @param disease
	 */
	public void addInfection(Disease disease){
		int previousdiseaseInfc = this.getinfectionRate(disease);
		if(!this.isAlreadyInfectedDuringRound()) {
			if(previousdiseaseInfc==3) {
				this.AlreadyInfectedDuringRound=true;
				this.infectNeighbors(disease);
				this.foyerInfection=true;
			}
			else {
				this.infectionRate.put(disease,previousdiseaseInfc+1);
			}
		}
		else {
			//
		}
		this.resetAlreadyInfectedDuringRound();
		}
		

	/**
	 * remove one cube of the disease given in param
	 * if the number of cubes was 3 the city will no longer be a foyerInfection
	 * @param disease
	 * @throws CityException 
	 */
	public void removeInfection(Disease disease) throws CityException{
		int previousdiseaseInfc = this.getinfectionRate(disease);
		if(disease.hasAntiDote()) {
			if(this.getinfectionRate(disease)!=0){
				this.infectionRate.replace(disease, 0);
		    } 
			else {
				throw new CityException("This city is not already infected by this disease!");
			}
		} 
		else {
			if(this.getinfectionRate(disease)!=0) {
				this.infectionRate.replace(disease,previousdiseaseInfc-1);
				this.foyerInfection=false;
			}
			else {
				throw new CityException("This city is not already infected by this virus!");
			}
		}
	}


	/**
	 * @return True if the city has a researchStation false if not 
	 */
	public boolean hasResearchStation(){
		return this.researchStation;
	}

	/** add new researchStation to the city
	 * @param r
	 */
	public void addResearchStation(){
		this.researchStation=true;
	}

	/**
	 * remove the researchStation of this city
	 */
	public void removeResearchStation(){
		this.researchStation=false;
	}

	/**
	 * @return True if the city is a FoyerIfection False otherways
	 */
	public boolean isFoyerInfection(){
		return this.foyerInfection;
	}

	/** it will addInfection to every nighbor city of this city
	 * @param disease
	 */
	public void infectNeighbors(Disease disease){
		for (City city : this.neighbors){
			city.addInfection(disease);
		}
	}
	
	public void initDisease(Disease d) {
		this.infectionRate.put(d, 0);
	}
	
	public String toString() {
		return this.name;
	}
	

	
	
	public boolean equals(Object o) {
		if(! (o instanceof City )) {
			return false;
		}
		 City c= (City) o;
		return (this.getName().equals(c.getName()) && this.getSector()==c.getSector());
		}
	
   
}

