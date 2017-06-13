package graphs.util;


/**
 * Created by viagrawal on 6/11/17.
 */
public class Vertex implements Comparable<Vertex> {
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