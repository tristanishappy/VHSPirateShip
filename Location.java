import java.util.*;
public class Location
{
   // Name of location
   private String name;
   // Directory of travelable nodes
   private HashMap<Location, Integer> relatedNodes;
   // Events occuring within location
   private ArrayList<Events> eventStack;
   // Number of events/structures within location
   private int size;
   
   //Sets size
   public void setSize(int size)
   {
   	this.size = size;
   }
   
   // Constructor: makes new location without set size
   public Location(String name)
   {
	   this.name = name;
	   relatedNodes = new HashMap<Location, Integer>();
   }
   
   // Constructor: makes new location with size
   public Location(String name, int size)
   {
	   this.name = name;
	   this.size = size;
	   relatedNodes = new HashMap<Location, Integer>();
   }
   
   // Returns name
   public String getName()
   {
	   return this.name;
   }
   
   // Sets name
   public void setName(String name)
   {
	   this.name = name;
   }
   
   // Returns Hashmap of travelable nodes
   public HashMap<Location, Integer> getRelatedNodes()
   {
	   return this.relatedNodes;
   }
   
   // Returns number of events/structures within node
   public int getSize()
   {
	   return size;
   }
   
   public void addEvent(Event other)
   {
   	eventStack.add(other);
   }
   
   public void removeEvent(int index)
   {
   	eventStack.remove(index);
   }
   
   // Adds location to Hashmap of travelable nodes
   public void addEdge(Location next)
   {
	   relatedNodes.put(next, 0);
   }
   
   // Adds location at distance to Hashmap of travelable nodes
   public void addEdge(Location next, int distance)
   {
	   relatedNodes.put(next, distance);
   }
   
   // Removes location from list of travelable nodes
   public void removeEdge(Location next)
   {
	   relatedNodes.remove(next);
   }
   
   // Returns true if two nodes have the same name, size, and related nodes
   public boolean equals(Location other)
   {
	   return this.name == other.name && this.size == other.size && this.relatedNodes == other.relatedNodes;
   }
   
   // Returns a String describing node
   public String toString()
   {
	   String toReturn = "";
	   toReturn += "This is node \"" + name + "\".\n";
	   toReturn += "The sizermation stored is: " + size + ".\n";
	   toReturn += "The adjacent nodes are:\n";
	   for(Location current:relatedNodes.keySet())
	   {
		   toReturn += "- Node \""+ current.getName() + "\" at a distance: " + relatedNodes.get(current) + "\n";
	   }
	   
	   return toReturn;
   }
}
