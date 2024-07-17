package pandemic.Roles;
import pandemic.Board.*;
import pandemic.actions.*;
import pandemic.Cards.*;
import java.util.ArrayList;
import java.util.List;
import pandemic.Game;


public abstract class Player{
    protected String name; // name for player
    protected City city ; // id for player
    protected List<PlayerCard> cartes; // les cartes du joueurs 
    protected List<Action> actions;// list des actions 
    protected Action actionWithRelation;//action avec laquelle est en relation
    protected Game game;

    public Player(String name,City city, Game game  ){
        this.name=name;
        this.city=city;
        this.cartes = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.initAllActions();
        this.actionWithRelation=this.initRoll();
        this.game=game;
    }
    
    public void initAllActions() {
    	this.actions.add(new MoveAction());
    	this.actions.add(new FindCureAction());
    	this.actions.add(new TreateDiseaseAction());
    	this.actions.add(new BuildAction());
    }
    public  void  role() {
    	this.actionWithRelation.actOn(this);
    };
    
    public abstract Action initRoll();
  
    /**
    * @return city of player
     */
    public List<PlayerCard> getCards() {
    	return this.cartes;
    }
    
    public City getCity(){
        return this.city;
    }
    /**
    * @return name of player 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * @return name of player 
      */
     public Game getGame(){
         return this.game;
     }
    /**
	 *  add a Card on the list of carte 
	 * @param card to add
	 */
    public void addPlayerCard(PlayerCard c) {
    	this.cartes.add(c);
    }
    /**
	 * change the city to the  player on the city
	 * @param city to change 
	 */
    public void setCity(City c) {
    	this.city = c;
    }
    /**
    * @param object de type player
    * @return true or false  
     */
    public boolean equals(Object o) {
	   if(! (o instanceof Player )) {
			return false;
		}
		 Player p= (Player) o;
		return (this.getName().equals(p.getName()) && this.getCity()==p.getCity());
	}

    public String toString(){
        return "name of player is "+this.getName()+"and his city is"+this.getCity();
    }
    
    public List<Action> getActions(){
        return this.actions;
    }
    
    public Action  getMoveAction() {
    	return  this.getActions().get(0);
    }
    
    public Action  getFindCureAction() {
    	return this.getActions().get(1);
    }
    
    public Action  getTreatDiseaseAction() {
    	return this.getActions().get(2);
    }
    
    public Action  getBuildAction() {
    	return this.getActions().get(3);
    }

    
    
    
    


	
	// cette fonction permet au joueur de deffausser les cartes d'une maladie guerrie.
	// Je completerai plutard aprés discussion avec mes camarades.
	public void discardFiveCardsOfDisease(Disease disease) {
		// TODO Auto-generated method stub
		int count = 0;
	    List<PlayerCard> cardsToRemove = new ArrayList<>();
	    for (PlayerCard card : this.getCards()) {
	        if (card.getDisease().equals(disease)) {
	            cardsToRemove.add(card);
	            count++;
	            if (count == 5) {
	                break;
	            }
	        }
	    }
	    for (PlayerCard card : cardsToRemove) {
	    	this.getGame().discardPlayerCard(card);
	    }
	    this.getCards().removeAll(cardsToRemove);
	}
	
	}


	
		
	
		
    
    
   
    
    
    






