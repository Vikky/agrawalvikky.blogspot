package graphs.util;

/**
 * Created by viagrawal on 6/11/17.
 */
public class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}