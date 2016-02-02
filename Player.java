

public class Player {

	private String name;
	private Location current;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Player(String name) {
		this.name  = name;
	}

	public void changeLocation(Location next) {
		this.current = next;
	}
	
	public String toString() {
		return "This player is named " + name + ".";
	}
	
	public String where()
	{
		return current.toString();
	}
	
	public Location getLocation()
	{
		return current;
	}
}
