package pandemic.Board;

public class Disease {
	private String name;//name of disease
	private int id;//id of Disease
	private boolean antiDote; 
	/**
	 * Disease constructor
	 * @param name String,the name of disease
	 * @param id int, id of disease
	 * @param sector 
	 */
	public Disease(String name, int id){
		this.name=name;
		this.id=id;
		this.antiDote=false;
	}
	/**
	 * @return the name of disease
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return the id of disease
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * we just found a antidote for this disease
	 */
	public void findAnAntidote(){
		this.antiDote=true;
	}

	/**
	 * we just found a antidote for this disease
	 */
	public boolean hasAntiDote(){
		return this.antiDote;
	}
	
	
	

	
	
	
	
		
    public boolean equals(Object o) {
		if(! (o instanceof Disease )) {
			return false;
		}
		 Disease d= (Disease) o;
		return (this.getName().equals(d.getName()) && this.getId()==d.getId());
		}
    
    public String toString() {
    	return this.getName();
    }

	


}
