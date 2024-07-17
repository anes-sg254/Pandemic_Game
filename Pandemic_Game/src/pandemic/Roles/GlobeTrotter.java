package pandemic.Roles;
import pandemic.Game;
import pandemic.actions.*;
import pandemic.Board.*;

public class GlobeTrotter extends Player {

	public GlobeTrotter(String name, City city,Game game) {
		super(name, city,game);
	}

	@Override
	public Action initRoll() {
		
		return new MoveAction();
	}

	
	

}
