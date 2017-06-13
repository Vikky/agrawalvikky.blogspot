package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by viagrawal on 6/11/17.
 */
public class GraphTraversals
{

	private int vertices;   // No. of vertices
	private LinkedList<Integer> adj[]; // Array  of lists for Adjacency List Representation

	public GraphTraversals(int v)
	{
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	//Function to add an edge into the graph
	public void addEdge(int v1, int v2)
	{
		adj[v1].add(v2);  // Add vertex2 to vertex1's list.
	}

	public static void main(String[] args)
	{
		GraphTraversals graph = new GraphTraversals(4);
		/*
			cyclic graph
			0->1,2
			1->2
			2->0,3
			3->3
		 */

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("DFS traversal : \n");
		graph.dfs(2);

		System.out.println(" \nBFS traversal :");
		graph.bfs(2);

	}

	private void bfs(int startVertex)
	{
		boolean[] visited = new boolean[vertices];
		System.out.println("Traversed node : " + startVertex);
		visited[startVertex] = true;

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(startVertex);

		while (!queue.isEmpty())
		{
			int vertex = queue.pop();
			Iterator<Integer> iterator = adj[vertex].listIterator();

			while (iterator.hasNext())
			{
				int nextVertex = iterator.next();
				if (!visited[nextVertex])
				{
					visited[nextVertex] = true;
					queue.add(nextVertex);
					System.out.println("Traversed node : " + nextVertex);
				}
			}
		}
	}

	private void dfs(int vertex)
	{
		//set all visited= false
		boolean[] visited = new boolean[vertices];
		DFSUtil(visited, vertex);
	}

	private void DFSUtil(boolean[] visited, int startVertex)
	{
		System.out.println("Traversed node : " + startVertex);
		visited[startVertex] = true;

		Iterator<Integer> iterator = adj[startVertex].listIterator();

		while (iterator.hasNext())
		{
			int vertex = iterator.next();
			if (!visited[vertex])
			{
				visited[vertex] = true;
				DFSUtil(visited, vertex);
			}
		}
	}

}
