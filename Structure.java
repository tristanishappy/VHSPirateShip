import java.util.*;
public class Structure {
	
    private static final int undiscovered = 0;
    private static final int discovered = 1;
    private static final int processed = 2;
    boolean found;
    private HashMap<Location, Integer> state;
    private HashMap<Location, Location> parent;
	
    private int nvertices;
	private ArrayList<Location> nodes;
	private Location position;
	
	
	public Structure()
	{
		nodes = new ArrayList<Location>();
		nvertices = 0;
		state = new HashMap<Location, Integer>();
		parent = new HashMap<Location, Location>();
	}
	
	public Structure(Location originalPosition)
	{
		nodes = new ArrayList<Location>();
		position = originalPosition;
		nvertices = 0;
		state = new HashMap<Location, Integer>();
		parent = new HashMap<Location, Location>();
	}
	
	public int getNumberOfVertices()
	{
		return this.nvertices;
	}
	
	public void setNumberOfVertices(int nvertices)
	{
		this.nvertices = nvertices;
	}
	
	public Location getPosition()
	{
		return position;
	}
	
	public void changePosition(Location next)
	{
		position = next;
	}
	
	public void addNode(Location node)
	{
		nodes.add(node);
		this.nvertices++;
	}
	
	/*public void removeNode(Location node)
	{
		for(Location current: node.getRelatedNodes().keySet())
		{
			current.removeEdge(node);
		}
		nodes.remove(node);
		nvertices--;
	}
	
	public void removeEdge(Location x, Location y)
	{
		if(x!=null &&y!=null)
		{
			x.removeEdge(y);
			y.removeEdge(x);
		}
		
	}
	*/
	public void createNode(String name)
	{
		nodes.add(new Location(name));
		this.nvertices++;
	}
	
	public void createNode(String name, int info)
	{
		nodes.add(new Location(name, info));
		this.nvertices++;
	}
	
	public void createRoute(Location x, Location y, int distance)
	{
		x.createRoute(y, distance);
		y.createRoute(x, distance);
	}
	
	public void createRoute(Location x, Location y)
	{
		x.createRoute(y, 0);
		y.createRoute(x, 0);
	}
	
	public Location getPointer(String name)
	{
		for(Location node:nodes)
		{
			if(node.getName()==name)
			{
				return node;
			}
		}
		return null;
	}
	
	public Location getPointer(String name, int info)
	{
		for(Location node:nodes)
		{
			if(node.getName()==name && node.getInfo()==info)
			{
				return node;
			}
		}
		return null;
	}
	
	
	public void initializeSearch()
	{
		state.clear();
		parent.clear();
		for(Location node:nodes)
		{
			state.put(node, undiscovered);
			parent.put(node, null);
		}
		found = false;
	}
	
	
	public void dfs(Location current, Location searched)
	{
		state.remove(current);
		state.put(current, discovered);
		if(current.equals(searched))
		{
			found = true;
		}
		for(Route v:current.getRelatedRoutes())
		{
			if(state.get(v.getTo()) == undiscovered)
			{
				dfs(v.getTo(), searched);
			}
		}
		state.remove(current);
		state.put(current, processed);
	}
	
	public boolean isReachable(Location start, Location searched)
	{
		if(start!=null && searched != null)
		{
			initializeSearch();
			dfs(start, searched);
		}
		return found;
	}
	
	public double dijkstra(Location start, Location end)
	{
		HashMap<Location, Boolean> intree = new HashMap<Location, Boolean>();
		HashMap<Location, Double> distance = new HashMap<Location, Double>();
		Location v;
		double weight;
		double dist;
		
		for(Location node:nodes)
		{
			intree.put(node, false);
			distance.put(node, Double.MAX_VALUE);
			
		}
		distance.remove(start);
		distance.put(start, 0.0);
		v = start;
		
		while(intree.get(v) == false)
		{
			intree.remove(v);
			intree.put(v, true);
			for(Route w:v.getRelatedRoutes())
			{
				weight = w.getDistance();
				if(distance.get(w.getTo()) > ((distance.get(v))+weight))
				{
					distance.remove(w.getTo());
					distance.put(w.getTo(), (distance.get(v)+weight));
				}
			}
			
			v = getPointer("a");
			dist = Double.MAX_VALUE;
			for(Location current:nodes)
			{
				if((intree.get(current)==false) && (dist>distance.get(current)))
				{
					dist = distance.get(current);
					v = current;
				}
			}
		}
		return distance.get(end);
		
	}

	
	public double findShortestPath(Location x, Location y)
	{
		initializeSearch();
		if(isReachable(x,y))
		{
			initializeSearch();
			return dijkstra(x, y);
		}
		else
		{
			return -1;
		}
	
	}
	
	public String toString()
	{
		String toReturn = "";
		toReturn += "Graph with #" + nvertices + " vertices.\n";
		for(Location node:nodes)
		{
			toReturn += node.toString();
			toReturn += "\n";
		}
		return toReturn;
	}
	
}
