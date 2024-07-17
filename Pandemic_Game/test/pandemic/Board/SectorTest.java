package pandemic.Board;

import static org.junit.Assert.*;

import org.junit.Test;

public class SectorTest {

	    // the class that test the class "Sector"
		
		@Test
	    public void getSectorNameTest() {
	        Disease disease = new Disease("Influenza", 1);    // we create a disease
	        Sector sector = new Sector("Europe", disease,1);  // we create a sector 
	        assertEquals("Europe", sector.getSectorName());   // they should be equals
	    }

	    @Test
	    public void getSectorDiseaseTest() {
	        Disease disease2 = new Disease("Ebola", 0);          // we create a disease 
	        Sector sector = new Sector("America", disease2,2);   // we create a sector 
	        assertEquals(disease2, sector.getSectorDisease());   // should be equals
	    }

	    @Test
	    public void getCitiesTest() {
	        Disease disease3 = new Disease("covid19", 3);    // we create a  disease 
	        Sector sector = new Sector("Asia", disease3, 3); // we create a sector
	        assertNotNull(sector.getCities());               // the List<City> should not be empty  
	    }


	    @Test
	    public void addCityTest() {
	        Disease disease1 = new Disease("Influenza", 1);    // we create a disease
	        Sector sector = new Sector("Europe", disease1,1);  // we create a sector
	        City city = new City("Lille",sector);              // we create a city 
	        sector.addCity(city);                              // we add the city to the sector 
	        City city2 = new City("Paris", sector);            // we create a second city
	        sector.addCity(city2);                             // we add it to the same sector
	        assertEquals(2, sector.getCities().size());        // since the sector contains only 2 cities.
	    }

}
