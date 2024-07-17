package pandemic.actions;

import java.util.HashMap;
import java.util.Map;



import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.*;

public class TreateDiseaseAction implements Action {

	
	
	@Override
	public void actOn(Player p) {
		if(isPossible(p)) {
		City cp = p.getCity();
		if(cp.hasResearchStation()) {
			int cpt = 0;
			Map<Disease,Integer> d = cp.getDiseases();
			Map<Disease,Integer> tmp = new HashMap<>();
			for(Disease dise : d.keySet()) {
				tmp.put(dise, 0);
			}
			for (PlayerCard carte:p.getCards()) {
				if(tmp.keySet().contains(carte.getDisease()) )
					tmp.put(carte.getDisease(),tmp.get(carte.getDisease())+1);
			}
			for(Disease dise : tmp.keySet()) {
				if(tmp.get(dise)>=5) {
					dise.findAnAntidote();
					//Affichage 
					System.out.println("The player : " + p.getName() + " has treated the disease : " + dise + "!");
				}
			}
			
		}
		}
		else {
			System.out.println(" Impossible to treat the disease !!! the conditions are not met. ");
		}

	}

	@Override
	public boolean isPossible(Player p) {
		City cp = p.getCity();
		if(cp.hasResearchStation()) {
			int cpt = 0;
			Map<Disease,Integer> d = cp.getDiseases();
			Map<Disease,Integer> tmp = new HashMap<>();
			for(Disease dise : d.keySet()) {
				tmp.put(dise, 0);
			}
			for (PlayerCard carte:p.getCards()) {
				if(tmp.keySet().contains(carte.getDisease()) )
					tmp.put(carte.getDisease(),tmp.get(carte.getDisease())+1);
			}
			for(Disease dise : tmp.keySet()) {
				if(tmp.get(dise)>=5) {
					return true;
				}
				}
			
		}
		return false;
	}

}
