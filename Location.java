import java.util.*;
public class Location
{
   // Name of location
   private String name;
   // Directory of travelable nodes
   private ArrayList<Location> relatedNodes;
   // Events occuring within location
   private ArrayList<Events> eventStack;
   // Number of events/structures within location
   private int size = 0;
   // Tells if player is in location
   private boolean occupied;
   // Summary of location
   private String summary;
   
   //Sets size
   public void setSize(int size)
   {
   	this.size = size;
   }
   
   // Constructor: makes new location without set size
   public Location(String name)
   {
	   this.name = name;
	   relatedNodes = new ArrayList<Location>();
   }
   
   // Constructor: makes new location with size
   public Location(String name, int size)
   {
	   this.name = name;
	   this.size = size;
	   relatedNodes = new ArrayList<Location>();
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
   
   // Returns summary
   public String getSummary()
   {
   	return summary;
   }
   
   // Sets summary
   public void setSummary(String summary)
   {
   	this.summary = summary;
   }
   
   // Returns Hashmap of travelable nodes
   public ArrayList<Location> getRelatedNodes()
   {
	   return this.relatedNodes;
   }
   
   // Returns number of events/structures within node
   public int getSize()
   {
	   return size;
   }
   
   // Adds event to list of events
   public void addEvent(Event other)
   {
   	eventStack.add(other);
   	size++;
   }
   
   // Removes event from list of events
   public void removeEvent(int index)
   {
   	eventStack.remove(index);
   	size++;
   }
   
   public void enter()
   {
   	occupied = true;
   }
   
   public void leave()
   {
   	occupied = false;
   }
   
   // Adds location to Hashmap of travelable nodes
   public void addEdge(Location next)
   {
	   relatedNodes.add(next);
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
	   toReturn += "This is node \"" + name + "\n";
	   toReturn += "Summary: " + summary + "\n";
	   toReturn += "There are " + size + " events and/or structures." + "\n";
	   toReturn += "The adjacent nodes are: " + "\n";
	   
	   for(int i=0; i<relatedNodes.size(); i++)
	   {
		   toReturn += "- Node: " + "\n" + relatedNodes[i].getName();
	   }
	   
	   return toReturn;
   }
}
