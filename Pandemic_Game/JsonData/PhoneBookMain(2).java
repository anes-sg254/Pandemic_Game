package phonebook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PhoneBookMain {
	
	public static void main(String args[]) throws FileNotFoundException {
		String filename = args[0];
		
		FileReader reader = new FileReader(filename);
		
	    JSONObject phonebook = new JSONObject(new JSONTokener(reader));
	    
	    {
		    // premier test : lecture des entrées du dictionnaire principal
		    Iterator<String> entries = phonebook.keys();
		    System.out.println("Affichage des noms du répertoire");
		    while (entries.hasNext()) {
		    	System.out.println(entries.next());
		    }
	    }
	    
	    {
		    // second test : lecture des entrées des sous-dictionnaires
		    Iterator<String> entries = phonebook.keys();
		    System.out.println("Affichage des données disponibles par entrée");
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
		    	System.out.println(entryKey);
		    	JSONObject entry = phonebook.getJSONObject(entryKey);
		    	Iterator<String> datakeys = entry.keys();
		    	while (datakeys.hasNext()) {
			    	System.out.println("\t"+datakeys.next());
			    }
		    }
	    }
	    
	    {
		    // troisieme test : lecture des entrées et des données associées aux sous-dictionnaires
	    	// a ce moment, il faut savoir quel type on lit
		    Iterator<String> entries = phonebook.keys();
		    System.out.println("Affichage des données et valeurs associées");
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
		    	System.out.println(entryKey);
		    	JSONObject entry = phonebook.getJSONObject(entryKey);
			    System.out.println("\t"+"email"+" -> "+entry.getString("email"));
			    System.out.println("\t"+"office"+" -> "+entry.getInt("office"));
			    
		    }
		}
	    
	    {
		    // quatrieme test : lecture des entrées et des données associées aux sous-dictionnaires
	    	// le cas particulier des listes
		    Iterator<String> entries = phonebook.keys();
		    System.out.println("Affichage des données et valeurs associées, avec des listes");
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
		    	System.out.println(entryKey);
		    	JSONObject entry = phonebook.getJSONObject(entryKey);
			    System.out.println("\t"+"email"+" -> "+entry.getString("email"));
			    System.out.println("\t"+"office"+" -> "+entry.getInt("office"));
			    // lecture de la liste : conversion de type explicite nécessaire
			    System.out.print("\t"+"phonenumbers"+" -> ");
			    JSONArray a = entry.getJSONArray("phonenumbers");
			    for (Object o : a) {
			    	String phonenumber = (String)o;
		    	    System.out.print(phonenumber+" ");
			    }
//			    for (int i = 0; i < a.length(); i++) {
//		    	    String phonenumber = (String) a.get(i);
//		    	    System.out.print(phonenumber+" ");
//		    	}
			    System.out.println();
		    }
		}
	    
	    
	    
	    
	}


}
