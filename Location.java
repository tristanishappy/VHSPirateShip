import java.util.*;
public class Location
{
   private String name;
   private HashMap<Location, Integer> relatedNodes;
   private int info;
   
   public Location(String name)
   {
	   this.name = name;
	   relatedNodes = new HashMap<Location, Integer>();
   }
   
   public Location(String name, int info)
   {
	   this.name = name;
	   this.info = info;
	   relatedNodes = new HashMap<Location, Integer>();
   }
   
   public String getName()
   {
	   return this.name;
   }
   
   public void setName(String name)
   {
	   this.name = name;
   }
   
   public HashMap<Location, Integer> getRelatedNodes()
   {
	   return this.relatedNodes;
   }
   
   public int getInfo()
   {
	   return this.info;
   }
   
   public void addEdge(Location next)
   {
	   relatedNodes.put(next, 0);
   }
   
   public void addEdge(Location next, int distance)
   {
	   relatedNodes.put(next, distance);
   }
   
   public void removeEdge(Location next)
   {
	   relatedNodes.remove(next);
   }
   
   public boolean equals(Location other)
   {
	   return this.name == other.name && this.info == other.info && this.relatedNodes == other.relatedNodes;
   }
   
   public String toString()
   {
	   String toReturn = "";
	   toReturn += "This is node \"" + name + "\".\n";
	   toReturn += "The information stored is: " + info + ".\n";
	   toReturn += "The adjacent nodes are:\n";
	   for(Location current:relatedNodes.keySet())
	   {
		   toReturn += "- Node \""+ current.getName() + "\" at a distance: " + relatedNodes.get(current) + "\n";
	   }
	   
	   return toReturn;
   }
}