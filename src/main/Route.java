package src.main;

//WARNING: UNTESTED CLASS! TEST BEFORE MERGING! (I couldn't test it at the time that I made it.)

import java.util.*;
public class Route
{

  //I think this class should be called when someone wants to look more carefuly at the Route
  /*
  String a = this.getName() + getRelatedNodes().name(); // Or something like this
  new Route [name] = (a, <Location you are at>, <Location you want to go to>, 10, "you see a few trade ships along this route ");
  */
  
  //Will Compass directions be relevent in this game?
  private String name;
  private double distance; //Location where you can see the route to
  private Location to; // the place where you can or can't go
  public int safty; //How likely you are to make it through unharmed, 0 means safest 100 means not traversable.
  public String description; //Description of the route, ex:  description + " to " + <name of island> + " it seams " + safty + " safe."
  
  public Route(Location to)
  {
	  this.distance = 1;
	  this.to = to;
	  this.safty = 0;
	  this.description = "quite chill";
  }
  public Route(Location to, double distance)
  {
	  this.distance = distance;
	  this.to = to;
	  this.safty = 0;
	  this.description = "quite chill";
  }
  public Route(Location to, double distance, int safe, String description) //I think there should be one route from a to be and another from b to a because the safty depends on which way currents are going, and descriptons would look different
  {
    this.distance = distance;
    this.to = to;
    this.safty = safe;
    this.description = description;
  }
  
  public Location getTo()
  {
	  return to;
  }
  public double getDistance()
  {
	  return distance;
  }
  
  //we need a random class for ship damages and pirate attacks while traveling as well as a few other nesesitys for shipDamage()
  /*
  public int shipDamage(Shipname) //this will be called when someone tries to traverse the path
  {
    int howMuchRepairsWillCost = 0;
    int luck = random number between (0 and 100);
    if(<safty> == 0)
    then(you can't go this way right now);
    else if(luck <= 100-<safty>)
    then(safe travels);
    else if(luck <= (110-<safty>))
    then(minor damage);
    else if(luck <= (150-<safty>))
    then(howMuchRepairsWillCost=PirateAttack(player));
    
  *I will add the events based on the mecanics we have.*
  
    return howMuchRepairsWillCost;
  }
  */
  
  public String toString()
  {
	String dis = distance + " units";
	if (distance == 1)
	{
	dis = distance + " unit";
	}
	
    String routeString = "The route from here to " + to + "/n"
                          + " is " + description + "/n" +
                          "Traveling this route has a " + safty + "% /n" 
                          + "chance to turn out badly!" + " the destination /n"
                          + "is around " + dis + " away.";
    return routeString;
  }
  
}
