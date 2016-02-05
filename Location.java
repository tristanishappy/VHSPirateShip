import java.util.*;
public class Location
{
   private String name;
   private HashMap<Location, Integer> relatedNodes;
   //Info tells size, and three events (ex. island, hurricane, port)
   private int info = 000;
   private int event1 = 0;
   private int event2 = 0;
   private int event3 = 0;
   
   public void setInfo(int info)
   {
   	this.info = info;
   	event1 = info.charAt(0);
   	event2 = info.charAt(1);
   	event3 = info.charAt(2);
   }
   
   public void setEvent(int eventNum, int set)
   {
   	if(eventNum == 1)
   	{
   		event1 = set;
   		int newInfo = set + (info.charAt(1)*10) + (info.charAt(2)*100);
   		info = newInfo;
   	}
   	
   	if(eventNum == 2)
   	{
   		event2 = set;
   		int newInfo = info.charAt(0) + (set*10) + (info.charAt(2)*100);
   		info = newInfo;
   	}
   	
   	if(eventNum == 3)
   	{
   		event3 = set;
   		int newInfo = info.charAt(0) + (info.charAt(1)*10) + (set*100);
   		info = newInfo;
   	}
   }
   
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
