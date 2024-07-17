package pandemic.actions;

import pandemic.Roles.*;

public interface Action {
	public void actOn(Player p);
	public boolean isPossible(Player p);
}
