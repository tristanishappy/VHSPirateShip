import java.util.*;
public class Structure {
	
	/**
	 * This variables are used by the search and traverse methods to work. 
	 * They are not supposed to be viewed or modified by other classes or the user.
	 */
    private static final int undiscovered = 0;
    private static final int discovered = 1;
    private static final int processed = 2;
    boolean found;
    private HashMap<Location, Integer> state;

    //This stores the information of the path followed during the traverse.
    private HashMap<Location, Location> parent;
	
    //This is the total number of nodes of the graph, no matter if they're connected or not to other nodes.
    private int nvertices;
    
    //This is the list containing all the nodes. Not just a copy of the nodes, but the actual objects.
	private ArrayList<Location> nodes;
	
	//This variable contains the current position of the player
	private Location position;
	
	/**This is the default constructor, without any parameters. 
	 * It initialized the number of vertices to 0. 
	 * And it creates the list of nodes plus the lists required by the traverse and search algorithms.
	 */
	public Structure()
	{
		nodes = new ArrayList<Location>();
		nvertices = 0;
		state = new HashMap<Location, Integer>();
		parent = new HashMap<Location, Location>();
	}
	
	
	//This constructor also sets the original position of the player
	public Structure(Location originalPosition)
	{
		nodes = new ArrayList<Location>();
		position = originalPosition;
		nvertices = 0;
		state = new HashMap<Location, Integer>();
		parent = new HashMap<Location, Location>();
	}
	
	//This method returns the number of nodes currently in the graph, no matter if they're connected or not.
	//The nvertices variable could be removed and the number of vertices could be obtained from the size of the "nodes" ArrayList.
	public int getNumberOfVertices()
	{
		return this.nvertices;
	}
	
	/**
	 * This method could be used to manually set the number of vertices.
	 * Since the add and remove node methods already keep the nvertices variable updated, it is not necessary.
	public void setNumberOfVertices(int nvertices)
	{
		this.nvertices = nvertices;
	}
	*/
	
	
	//This method returns the node where the player is currently.
	public Location getPosition()
	{
		return position;
	}
	
	//This method changes the value of the position variable of the player
	public void changePosition(Location next)
	{
		position = next;
	}
	
	/**This method adds an already existing node to the list, and therefore to the structure.
	 * It then updates the number of vertices variable.
	 * @param node
	 */
	public void addNode(Location node)
	{
		nodes.add(node);
		this.nvertices++;
	}
	
	//This method
	public void removeNode(Location node)
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
	
	public void addEdge(Location x, Location y, int distance)
	{
		x.addEdge(y, distance);
		y.addEdge(x, distance);
	}
	
	public void addEdge(Location x, Location y)
	{
		x.addEdge(y, 0);
		y.addEdge(x, 0);
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
		for(Location v: current.getRelatedNodes().keySet())
		{
			if(state.get(v) == undiscovered)
			{
				dfs(v, searched);
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
	
	public int dijkstra(Location start, Location end)
	{
		HashMap<Location, Boolean> intree = new HashMap<Location, Boolean>();
		HashMap<Location, Integer> distance = new HashMap<Location, Integer>();
		Location v;
		int weight;
		int dist;
		
		for(Location node:nodes)
		{
			intree.put(node, false);
			distance.put(node, Integer.MAX_VALUE);
			
		}
		distance.remove(start);
		distance.put(start, 0);
		v = start;
		
		while(intree.get(v) == false)
		{
			intree.remove(v);
			intree.put(v, true);
			for(Location w: v.getRelatedNodes().keySet())
			{
				weight = v.getRelatedNodes().get(w);
				if(distance.get(w) > ((distance.get(v))+weight))
				{
					distance.remove(w);
					distance.put(w, (distance.get(v)+weight));
				}
			}
			
			v = getPointer("a");
			dist = Integer.MAX_VALUE;
			for(Location current: nodes)
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

	
	public int findShortestPath(Location x, Location y)
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
