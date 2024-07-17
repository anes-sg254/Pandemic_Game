package pandemic.actions;


import pandemic.*;
import pandemic.Board.*;
import pandemic.Cards.*;
import pandemic.Roles.*;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.*;


public class FindCureTest {
	private static Game game;
	private String path;

	// POUR SIMPLIFIER LE TEST, J'AI INITILISE MON MONDE
	
	// les maladies
	Disease ebola = new Disease("EBOLA",0);
	Disease covid = new Disease("COVID_19",1);
	Disease flue = new Disease("INFLUENZA",2);

	// les secteurs
	Sector afrique = new Sector("AFRIQUE",ebola,0);
	Sector asia = new Sector("ASIA", flue,2);
	Sector europe = new Sector("EUROPE",covid,1);

	// je crée un petit monde avec 10 villes
	City alger = new City("ALGER",	afrique);
	City bruxelles = new City("BRUXELLES", europe);
	City bumbai = new City("BUMBAI",asia);
	City cairo = new City("CAIRO",afrique);
	City lille = new City("LILLE",europe);
	City london = new City("LONDON",europe);
	City marrakech = new City("MARAKECH",afrique);
	City paris = new City("PARIS",europe);
	City pekin = new City("PEKIN",asia);
	City tokyo = new City("TOKYO",asia);

	// les joueurs
	Player yanis = new Doctor("Yanis GHERDANE",lille,game);
	Player manil = new Doctor("Manil DIAF",paris,game);
	Player anes = new Doctor("Anes Seghir",tokyo,game);
	Player rayane = new Doctor("Rayane SLIMANI",alger,game);


	@Before
	public void init() throws FileNotFoundException {
		this.path="./src/pandemic/carte2.json";
		this.game= new Game(path);

	}


	/////////////////////// LES TESTS ////////////////////////////////////////////////////

	/* test1: pour vérifier si un joueur possède 5 cartes de la même maladie, permet de guerrir cette maladie */
	@Test
	public void testIsPossibleWith5CardsOfSameDisease() {

		//créer une station de recherhce à lille
		lille.addResearchStation();

		// j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(london,covid));
		yanis.addPlayerCard(new PlayerCard(bruxelles,covid));   
		yanis.addPlayerCard(new PlayerCard(cairo,covid));   

		/* je teste le bon fonctionnement de la méthode isPossible, qui devrait retourner vrai car on à respecter les deux conditions
		5 cartes de la meme maladie dans la main  du player + une station de recherche dans la ville du player*/
		FindCureAction findCure = new FindCureAction();
		assertTrue(findCure.isPossible(yanis));
	}


	/*test n°2: pour vérifier que la méthode isPossible lorsqu'on n'a pas de station à la ville du player.*/
	@Test
	public void testIsPossibleWithNoResearchStation(){

		//On ne met pas de station de recherche à lille

		Player yanis = new Doctor("yanis",lille,game);

		// j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(london,covid));
		yanis.addPlayerCard(new PlayerCard(bruxelles,covid));   
		yanis.addPlayerCard(new PlayerCard(cairo,covid));  

		/* meme exemple que le précédent, sans station de recherche */

		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}

	/* Test n°3 : ce test va tester la méthode isPossible si on à moins de 5 cartes */
	@Test
	public void testIsPossibleWithLessThan5Cards() {
		
		lille.addResearchStation();

		// j'ajoute seulement 4 cartes joueur au Joueur (player) de meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(london,covid));
		yanis.addPlayerCard(new PlayerCard(bruxelles,covid));   
		  

		// je teste le bon fonctionnement de la méthode isPossible.
		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}

	/* Test n°4 : ce test va tester la méthode isPossible si on à moins de 5 cartes de la meme maladie */
	@Test
	public void testIsPossibleWithLessThan5CardsOfSameDisease() {
		
		lille.addResearchStation();             

		// alger est de maladie differente.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(london,covid));
		yanis.addPlayerCard(new PlayerCard(bruxelles,covid)); 
		yanis.addPlayerCard(new PlayerCard(alger,ebola));

		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}



	/* Test n°5 pour vérifier si la méthode actOn guérit la maladie si le joueur possède 5 cartes de la même maladie */
	@Test
	public void testActOnWith5CardsOfSameDisease() {
		

		// Je rappelle que la ville de manil est "PARIS"
		lille.addResearchStation();

		// Créer un joueur avec 5 cartes de la même maladie
		
		yanis.addPlayerCard(new PlayerCard(lille, covid));
		yanis.addPlayerCard(new PlayerCard(paris, covid));
		yanis.addPlayerCard(new PlayerCard(london, covid));
		yanis.addPlayerCard(new PlayerCard(bruxelles, covid));
		yanis.addPlayerCard(new PlayerCard(london, covid));

		// Trouver un remède
		FindCureAction action = new FindCureAction();
		action.actOn(yanis);

		// Vérifier si la maladie a été guérie
		assertTrue(covid.hasAntiDote());
	}

	/*test n°6 : tester le fonctionnement de actOn si on à pas de station de recherche */
	@Test
	public void testActOnWithoutResearchStation() {
		

		anes.addPlayerCard(new PlayerCard(lille, covid));
		anes.addPlayerCard(new PlayerCard(paris, covid));
		anes.addPlayerCard(new PlayerCard(london, covid));
		anes.addPlayerCard(new PlayerCard(tokyo, covid));
		anes.addPlayerCard(new PlayerCard(pekin, covid));

		// Trouver un remède
		FindCureAction action = new FindCureAction();
		action.actOn(anes);

		// comme on n'a pas de station de recherche dans de ville de anes, le test est false.
		assertFalse(covid.hasAntiDote());
	}
	/*test n°7 : tester acton() avec seulement 4 cartes*/
	@Test
	public void testActOnWithNotEnoughCardsOfSameDisease() {
		
		alger.addResearchStation();

		rayane.addPlayerCard(new PlayerCard(lille, covid));
		rayane.addPlayerCard(new PlayerCard(paris, covid));
		rayane.addPlayerCard(new PlayerCard(london, covid));
		rayane.addPlayerCard(new PlayerCard(pekin, covid));

		// Trouver un remède
		FindCureAction action = new FindCureAction();
		action.actOn(rayane);

		// Vérifier si la maladie n'a pas de remède
		assertFalse(covid.hasAntiDote());
	}



	/* test n°8 : teste de la fonction actOn avec d'autres players */
	@Test
	public void testActOnWithOtherPlayerCards() {
		
		anes.addPlayerCard(new PlayerCard(paris, covid));
		anes.addPlayerCard(new PlayerCard(london, covid));
		rayane.addPlayerCard(new PlayerCard(pekin, covid));
		rayane.addPlayerCard(new PlayerCard(tokyo, covid));

		// Vérifier que la maladie n'a pas encore de remède
		assertFalse(covid.hasAntiDote());

		// Essayer de trouver un remède avec les cartes des deux joueurs
		FindCureAction action = new FindCureAction();
		action.actOn(anes);

		// Vérifier que la maladie n'a pas de remède après l'action, pas assez de cartes.
		assertFalse(covid.hasAntiDote());
	}



}
