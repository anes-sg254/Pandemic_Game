package pandemic.Roles;
import pandemic.Game;
import pandemic.actions.*;
import pandemic.Board.*;

public class Scientist extends Player {

	public Scientist(String name, City city, Game game) {
		super(name, city, game);
	}

	@Override
	public Action initRoll() {
		
		return new FindCureAction();
	}

	

}
