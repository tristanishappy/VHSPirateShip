
public class World {
	
	//Initializes the world location.
	private Location world;
	
	//World Constructor
	public World() {
		//Sets the location variable world to a location with name World.
		world = new Location("World");
		//This Method needs to be added or there could be a package "pirateShip.world.generate" could be added to handle this.
		world.generateLocations();
	}
	
}
