package pandemic.actions;

import java.util.*;

import pandemic.Board.*;
import pandemic.Cards.*;
import pandemic.Roles.*;



public class FindCureAction implements Action {
	
	
	
	
    @Override
    public boolean isPossible(Player player) {
    	
        // Condition 1 : vérifier si le joueur est dans une ville qui a une station de recherche.
        if (!player.getCity().hasResearchStation()) {
        	return false;
        }        
        //Condition 2: vérifier si le joueur dispose de 5 cartes joueur de la meme maladie.        
        // Récupère toutes les cartes joueur de la main du joueur
        List<PlayerCard> playerCards = player.getCards();        
        // Compte le nombre de cartes joueur pour chaque maladie
        Map<Disease, Integer> cardCounts = new HashMap<>();
        for (PlayerCard card : playerCards) {
            if (card instanceof PlayerCard) {
                Disease disease = card.getDisease(); 
                if (!cardCounts.containsKey(disease)) {
                    cardCounts.put(disease, 0);
                    // si la maladie jamais rencontré avant, initialise la valeur de la maladie à 0.
                }
                int count = cardCounts.get(disease);
                cardCounts.put(disease, count + 1);
                // incrémenter le nombre de cartes joueur pour cette maladie
            }
        }        
        // Vérifie si le joueur possède au moins 5 cartes joueur pour une même maladie
        for (int count : cardCounts.values()) {
            if (count >= 5) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void actOn(Player player) {
        // Si le joueur dispose de 5 cartes de la même maladie,le remede cette maladie est trouvé
        if (isPossible(player)) {
        	
        	
            List<PlayerCard> playerCards = player.getCards();
            Map<Disease, Integer> CardCounts = new HashMap<>();
            for (PlayerCard card : playerCards) {
                if (card instanceof PlayerCard) {
                    Disease disease = card.getDisease();
                    if (!CardCounts.containsKey(disease)) {
                        CardCounts.put(disease, 0);
                    }
                    int count = CardCounts.get(disease);
                    CardCounts.put(disease, count + 1);
                }
            }
            // Trouver la maladie pour laquelle le joueur a 5 cartes.
            for (Map.Entry<Disease, Integer> entry : CardCounts.entrySet()) {
                if (entry.getValue() >= 5) {
                    Disease disease = entry.getKey();
                    // Défausser les 5 cartes de cette maladie.
                  //Affichage console
                	System.out.println("The player " + player.getName() + " has cured the disease " + disease + " ^_^");
                    for (int i = 0; i < 5; i++) {
                        player.discardFiveCardsOfDisease(disease);
                    }
                    // Ajouter le remède pour cette maladie.
                    disease.findAnAntidote();
                   
                }
            }
        }
        else {
        	System.out.println(" Impossible to cure the disease, the conditions are not met !!! ");
        }
    }

}
