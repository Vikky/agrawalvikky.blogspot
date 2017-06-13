package graphs;

import graphs.util.Edge;
import graphs.util.Vertex;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Dijkstra.java
 *
 * @author vikky.agrawal
 */

public class Dijkstra
{

	Vertex[] vertices = new Vertex[200];
	static int vertex_index = 0;
	int arr[] = new int[] { 6, 36, 58, 81, 98, 114, 132, 164, 187, 196 };

	public static void main(String[] args) throws IOException
	{

		Dijkstra obj = new Dijkstra();
		obj.initialize();
		computePaths(obj.vertices[0]);
		obj.result();
	}

	public void initialize() throws IOException
	{
		for (int i = 0; i < vertices.length; i++)
		{
			vertices[i] = new Vertex(i, "" + i);
		}

		readLargerTextFile("/Users/viagrawal/learning/dijkstraData.txt");

	}

	private void result()
	{
		for (Vertex v : vertices)
		{
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
			System.out.println("Path: " + path);
		}

	}

	public static void computePaths(Vertex source)
	{
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty())
		{
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies)
			{
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance)
				{
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target)
	{
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}

	public void readLargerTextFile(String aFileName) throws IOException
	{
		Path path = Paths.get(aFileName);

		try (Scanner scanner = new Scanner(path))
		{

			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String tokens[] = line.split("\\D+");
				List<Edge> edgeList = new ArrayList<Edge>();

				for (int i = 1; i < tokens.length; i = i + 2)
				{
					Vertex vertex = vertices[Integer.parseInt(tokens[i]) - 1];
					int weight = Integer.parseInt(tokens[i + 1]);
					edgeList.add(new Edge(vertex, weight));
				}
				vertices[vertex_index++].adjacencies = edgeList.toArray(new Edge[edgeList.size()]);

			}
		}
	}
}



