package pandemic.Board;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiseaseTest {
	@Test
	  /**
	   * Test the getName method of the Disease class
	   */

	  public void testGetName() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals("Influenza", disease.getName());
	  }

	  @Test
	  /**
	   * Test the getId method of the Disease class
	   */

	  public void testGetId() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals(1, disease.getId());
	  }
	  
	  @Test
	  public void testEquals() {
	      Disease d1 = new Disease("Influenza", 1);
	      Disease d2 = new Disease("Influenza", 1);
	      assertTrue(d1.equals(d2));

	      Disease d3 = new Disease("Ebola", 2);
	      assertFalse(d1.equals(d3));

	      // Test with different name but same id
	      Disease d4 = new Disease("Malaria", 1);
	      assertFalse(d1.equals(d4));

	      // Test with different id but same name
	      Disease d5 = new Disease("Influenza", 2);
	      assertFalse(d1.equals(d5));

	      // Test with null object
	      assertFalse(d1.equals(null));

	      // Test with object of different class
	      Object o = new Object();
	      assertFalse(d1.equals(o));
	  }
	  
	  @Test
	  /**
	   * Test the getId method of the Disease class
	   */

	  public void testFindAntiDote() {
	    Disease disease = new Disease("Influenza", 1);
	    assertFalse(disease.hasAntiDote());
	    disease.findAnAntidote();
	    assertTrue(disease.hasAntiDote());
	  }


}