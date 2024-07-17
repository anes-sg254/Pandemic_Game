package pandemic.Board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class World { // this class contains all the sectors 
	private List<Sector> sectors; // the list of sectors in the map

	public World(String path) {
        initWorld(path);
	}
	
	private void initWorld(String path) {
		setWorldMap();
        
		Map<String,City> citiesMap = new HashMap<>();
		Map<String,JSONArray> neighborsMap = new HashMap<>();

		JSONObject jsonData = readJsonFile(path);

		Iterator<String> entries = jsonData.keys();
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
				if(entryKey.equals("cities")){
					
		    		createCities(citiesMap, jsonData, entryKey);
		        }
				else if(entryKey.equals("neighbors")){
					
					createNeighbors(neighborsMap, jsonData, entryKey);
					
				}
		    }
		    // add nighbors to cities
		    setCitiesWhithNeighbors(citiesMap, neighborsMap);
		    // add cities to Sector
		    setSectorsWithCities(citiesMap);
	}

	private void createNeighbors(Map<String, JSONArray> neighborsMap, JSONObject jsonData, String entryKey) {
		JSONObject entry = jsonData.getJSONObject(entryKey);
		Iterator<String> datakeys = entry.keys();
		while (datakeys.hasNext()) {
			String cityString = datakeys.next();
			JSONArray neighbors ;
			neighbors = entry.getJSONArray(cityString);
			neighborsMap.put(cityString, neighbors);
		}
	}

	private void createCities(Map<String, City> citiesMap, JSONObject jsonData, String entryKey) {
		JSONObject entry = jsonData.getJSONObject(entryKey);
		Iterator<String> datakeys = entry.keys();
		while (datakeys.hasNext()) {
			String cityString = datakeys.next();
			City city = new City(cityString, this.sectors.get(entry.getInt(cityString)));
			citiesMap.put(cityString, city);
		}
	}

	private void setWorldMap() {
		this.sectors = new ArrayList<>();
        Disease disease0 = new Disease("maladie0",0);
        Disease disease1 = new Disease("maladie1",1);
        Disease disease2 = new Disease("maladie2",2);
        Disease disease3 = new Disease("maladie3",3);
        Sector sector0 = new Sector("AFRICA",disease0,0);
        Sector sector1 = new Sector("EUROPE",disease1,1);
        Sector sector2 = new Sector("AISIA",disease2,2);
        Sector sector3 = new Sector("AMERICA",disease3,3);
        this.addSector(sector0);
        this.addSector(sector1);
        this.addSector(sector2);
        this.addSector(sector3);
	}

	private JSONObject readJsonFile(String path) {
		String filename = path;//"./src/pandemic/carte2.json";
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			
			System.out.println("fichier introuvable");
			System.exit(0);
		}
	    JSONObject jsonData = new JSONObject(new JSONTokener(reader));
		return jsonData;
	}

	private void setCitiesWhithNeighbors(Map<String, City> citiesMap, Map<String, JSONArray> neighborsMap) {
		int i=0;
		for(JSONArray neighborsArray : neighborsMap.values()) {
			i++;
			for(Object neighbor : neighborsArray) {
				citiesMap.get("ville-"+i).addNeighbor(citiesMap.get(neighbor));
			}
		}
	}

	private void setSectorsWithCities(Map<String, City> citiesMap) {
		for(City city : citiesMap.values()) {
			this.sectors.get(city.getSector().getId()).addCity(city);
		}
	}
	
	/** 
	fonction getSectors return the list of sectors
	@return  list of sectors
	
	*/
	
	public List<Sector> getSectors(){
        return this.sectors;
    }
	/** 
	fonction addSector add the sector to the  list of sectors
	@param sector
	*/
	public void addSector(Sector sector){
        this.sectors.add(sector);
    }
	
	public void worldDisplay() { 
		System.out.println("");
		for (Sector s : this.getSectors()) {
			System.out.println(s);
			System.out.println(s.getCities());
		}
		System.out.println("");
		for(Sector s : this.getSectors()) {
		System.out.println(s);
		System.out.println("");
			for(City c : s.getCities()) {
				System.out.println(c);
				System.out.println("LES VILLES VOISINES");
				System.out.println(c.getNeighborsCities());
				System.out.println("");
			}
		}
		//return null;
	}
	
	
	

}
