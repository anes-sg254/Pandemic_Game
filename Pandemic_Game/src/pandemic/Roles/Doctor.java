package pandemic.Roles;
import pandemic.Game;
import pandemic.actions.*;
import pandemic.Board.*;
public class Doctor extends Player {

	public Doctor(String name, City city, Game game) {
		super(name, city, game);
		
	}

	

	@Override
	public Action initRoll() {
		
		return new TreateDiseaseAction();
	}

}
