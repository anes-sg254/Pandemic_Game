package pandemic.Board;
import java.util.*;

public class Sector {     // the class of the sectors, the world contains 4 sectors
	private String name;          // the name of the sector
	private Disease disease;    //the initial disease of the sector
	private int id;
	private List<City> cities;     // the list of the cities in that sector
	
	
	// the constructor of the Sector Class
	public Sector(String name,Disease disease, int id) {
		this.disease = disease;
		this.name = name;
		this.id=id;
		this.cities=new ArrayList<>();
	}

	/**
	 * get the name of the current sector
	 * @return name
	 */
	public String getSectorName() {
		return this.name;
	}
	
	/**
	 * get the initial principal disease
	 * @return disease
	 */
	public Disease getSectorDisease() {
		return this.disease;
	}
	
	/**
	 * get the cities of the current sector 
	 * @return the cities of the current sector
	 */
	public List<City> getCities(){
		return this.cities;
	}
	
	/**
	 * add a city to the list of cities
	 * @param city to add to cities list
	 */
	public void addCity(City city) {
		this.cities.add(city);
	}
	/**
	* @return id of Sector 
	*/
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return this.name;
	}

	
	
	

}
