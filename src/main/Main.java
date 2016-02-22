package src.main;


public class Main {

	public static void main(String[] args) 
	{
		Structure prova = new Structure();
		prova.createNode("ciaooooo", 2);
		prova.createNode("a", 2);
		prova.createNode("b", 5);
		prova.createNode("c", 7);
		prova.createNode("d", 12);
		prova.createNode("e", 1);
		prova.createNode("f", 9);
		prova.createNode("g", 0);
		prova.createNode("h", 34);
		prova.createNode("i", 5);
		prova.createNode("j", 8);
		prova.createNode("k", 35);
		prova.createNode("l", 98);
		prova.createNode("m", 36);
		prova.addEdge(prova.getPointer("a"), prova.getPointer("e"), 5);
		prova.addEdge(prova.getPointer("h"), prova.getPointer("i"), 9);
		prova.addEdge(prova.getPointer("i"), prova.getPointer("l"), 14);
		prova.addEdge(prova.getPointer("j"), prova.getPointer("i"), 50);
		prova.addEdge(prova.getPointer("j"), prova.getPointer("k"), 35);
		prova.addEdge(prova.getPointer("k"), prova.getPointer("l"), 8);
		prova.addEdge(prova.getPointer("f"), prova.getPointer("j"), 23);
		prova.addEdge(prova.getPointer("e"), prova.getPointer("f"), 11);
		prova.addEdge(prova.getPointer("f"), prova.getPointer("g"), 98);
		prova.addEdge(prova.getPointer("c"), prova.getPointer("g"), 24);
		prova.addEdge(prova.getPointer("b"), prova.getPointer("e"), 76);
		prova.addEdge(prova.getPointer("b"), prova.getPointer("c"), 23);
		prova.addEdge(prova.getPointer("c"), prova.getPointer("d"), 16);
		/*
		prova.changePosition(prova.getPointer("c"));
		
		System.out.println(prova.getNumberOfVertices());
		*/System.out.println(prova);/*
		
		
		System.out.println(prova.isReachable(prova.getPointer("a"), prova.getPointer("c")));
		System.out.println(prova.isReachable(prova.getPointer("a"), prova.getPointer("f")));
		System.out.println(prova.isReachable(prova.getPointer("l"), prova.getPointer("m")));
		System.out.println(prova.isReachable(prova.getPointer("j"), prova.getPointer("c")));
		System.out.println(prova.isReachable(prova.getPointer("d"), prova.getPointer("j")));
		
		System.out.println("Current position: " + prova.getPosition().getName());*/
		
		System.out.println(prova.findShortestPath(prova.getPointer("a"), prova.getPointer("k")));
		
		prova.removeNode(prova.getPointer("a"));
		prova.removeEdge(prova.getPointer("a"), prova.getPointer("e"));
		
		System.out.println(prova.findShortestPath(prova.getPointer("a"), prova.getPointer("k")));

	}

}
