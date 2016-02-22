import java.util.*;
public class Location
{
   private String name;
   private ArrayList<Route> relatedRoutes;
   private int info;
   
   public Location(String name)
   {
	   this.name = name;
	   relatedRoutes = new ArrayList<Route>();
   }
   
   public Location(String name, int info)
   {
	   this.name = name;
	   this.info = info;
	   relatedRoutes = new ArrayList<Route>();
   }
   
   public String getName()
   {
	   return this.name;
   }
   
   public void setName(String name)
   {
	   this.name = name;
   }
   
   public ArrayList<Route> getRelatedRoutes()
   {
	   return this.relatedRoutes;
   }
   
   public int getInfo()
   {
	   return this.info;
   }
   
   public void createRoute(Location next)
   {
	   relatedRoutes.add(new Route(next, 0.0));
   }
   
   public void createRoute(Location next, double distance)
   {
	   relatedRoutes.add(new Route(next, distance));
   }
   
   public void removeEdge(Location next)
   {
	   relatedRoutes.remove(next);
   }
   
   public boolean equals(Location other)
   {
	   return this.name == other.name && this.info == other.info && this.relatedRoutes == other.relatedRoutes;
   }
   
   public String toString()
   {
	   String toReturn = "";
	   toReturn += "This is node \"" + name + "\".\n";
	   toReturn += "The information stored is: " + info + ".\n";
	   toReturn += "The adjacent nodes are:\n";
	   for(Route current:relatedRoutes)
	   {
		   toReturn += "- Node \""+ current.getTo().getName() + "\" at a distance: " + current.getDistance() + "\n";
	   }
	   
	   return toReturn;
   }
}
