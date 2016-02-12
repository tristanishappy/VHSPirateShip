import java.util.*;

public class Player 
{
	private String name;
	private int moral = 10;
	private ArrayList<Item> inventory;

	private Location current;
	private double health = 100.00;
	
	public Player(String name) 
	{
		this.name  = name;
		inventory = new ArrayList<Item>;
	}
	
	public String toString() 
	{
		return "Player - [Name: " + name + "\n" 
		+ "Moral: " + moralToString() + "\n"
		+ "Location: " + current.getName() + "\n"
		+ "Health: " + health + " ]";
	}
	
	public void addItem(Item other)
	{
		inventory.add(other);
	}
	
	public void removeItem(int index)
	{
		inventory.remove(index);
	}
	
	public void dumpInventory()
	{
		inventory.clear();
	}
	
	public String inventoryToString()
	{
		String toReturn;
		
		for(Item n: inventory)
			toReturn += n.getName() + "\n";
			
		return toReturn;
	}
	
	public ArrayList getInventory()
	{
		return inventory;
	}

	public void changeLocation(Location next) 
	{
		current.leave();
		this.current = next;
		next.enter();
	}
	
	public void changeHealth(double change)
	{
		health+=change;
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
	
	public String moralToString()
	{
		if(moral>=7)
			return "Moral is high!";
		
		if(moral<7 && moral>=4)
			return "Moral is okay.";
		
		if(moral<4)
			return "Moral is low :(";
	}
	
}
