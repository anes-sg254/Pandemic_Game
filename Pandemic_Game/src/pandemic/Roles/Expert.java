package pandemic.Roles;
import pandemic.Game;
import pandemic.actions.*;
import pandemic.Board.*;

public class Expert extends Player {

	public Expert(String name, City city, Game game) {
		super(name, city, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action initRoll() {
		// TODO Auto-generated method stub
		return new BuildAction();
	}

}
