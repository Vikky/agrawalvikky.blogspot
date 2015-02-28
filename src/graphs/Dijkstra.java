package graphs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Dijkstra.java
 * 
 * @author vikky.agrawal
 *
 */

public class Dijkstra {

	Vertex[] vertices = new Vertex[200];
	static int vertex_index = 0;
	int arr[] = new int[] { 6, 36, 58, 81, 98, 114, 132, 164, 187, 196 };

	public static void main(String[] args) throws IOException {

		Dijkstra obj = new Dijkstra();
		obj.initialize();
		computePaths(obj.vertices[0]);
		obj.result();
	}

	public void initialize() throws IOException {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i, "" + i);
		}

		readLargerTextFile("/Users/viagrawal/learning/dijkstraData.txt");

	}

	private void result() {
		for (Vertex v : vertices) {
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
			System.out.println("Path: " + path);
		}

	}

	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}

	public void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);

		try (Scanner scanner = new Scanner(path)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String tokens[] = line.split("\\D+");
				List<Edge> edgeList = new ArrayList<Edge>();

				for (int i = 1; i < tokens.length; i = i + 2) {
					Vertex vertex = vertices[Integer.parseInt(tokens[i]) - 1];
					int weight = Integer.parseInt(tokens[i + 1]);
					edgeList.add(new Edge(vertex, weight));
				}
				vertices[vertex_index++].adjacencies = (Edge[]) (edgeList
						.toArray(new Edge[edgeList.size()]));

			}
		}
	}

}

class Vertex implements Comparable<Vertex> {
	public String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	private int index;

	public Vertex(String argName) {
		name = argName;
	}

	public Vertex(int index, String argName) {
		this.index = index;
		this.name = argName;
	}

	public String toString() {
		return name;
	}

	public int getIndex() {
		return this.index;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}
}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}
