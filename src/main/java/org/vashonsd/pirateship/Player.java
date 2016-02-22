package org.vashonsd.pirateship;

public class Player {

	private String name;
	private int moral = 10;
	private String mood;
	private double height;
	private String hairColor;
	private String eyeColor;

	private Location current;
	private double health = 100.00;
	
	public Player(String name) {
		this.name  = name;
	}

	public void changeLocation(Location next) {
		this.current = next;
	}
	
	public void changeHealth(double change)
	{
		health+=change;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", mood=" + mood + ", height=" + height
				+ ", hairColor=" + hairColor + ", eyeColor=" + eyeColor
				+ ", current=" + current + ", health=" + health + "]";
	}
	
	public String where()
	{
		return current.toString();
	}
	
	public Location getLocation()
	{
		return current;
	}
	
	public void setMoral(int moral)
	{
		this.moral = moral;
	}
	
	public void upMoral(int x)
	{
		while (moral < 10 && x > 0)
		{
			moral++;
			x--;
		}
	}
	
	public void downMoral(int x)
	{
		while (moral > 0 && x > 0)
		{
			moral--;
			x--;
		}
	}
}
