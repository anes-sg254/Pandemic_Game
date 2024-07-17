package pandemic;
import java.io.FileNotFoundException;
import java.io.File;
public class PandemicMain {

	
	private static String argumentsVerification(String args[]) {
		// Vérification de la présence d'arguments
        if (args.length !=1) {
            System.err.println("Aucun argument spécifié");
            System.exit(1);
        }

        // Vérification  argument
            File file = new File(args[0]);
            if (!file.isFile()) {
                throw new IllegalArgumentException("L'argument '" + args[0] + "' n'est pas un chemin valide vers un fichier");
            }
            
        return args[0];
	}		
	
	public static void main(String[] args) {
		
		try {
			Game game = new Game("./src/pandemic/carte2.json");
			
			game.play();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

    }

	
	}


