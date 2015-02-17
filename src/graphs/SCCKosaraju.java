/**
 * SCCKosaraju.java
 */
package graphs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * 
 * @author vikky.agrawal
 *
 */
public class SCCKosaraju {

	List<Integer>[] g = new List[875714];

	public static List<List<Integer>> scc(List<Integer>[] graph) {
		int n = graph.length;
		System.out.println("Graph length : " + n);

		boolean[] used = new boolean[n];
		List<Integer> order = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (!used[i])
				dfs(graph, used, order, i);

		List<Integer>[] reverseGraph = new List[n];
		for (int i = 0; i < n; i++)
			reverseGraph[i] = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j : graph[i])
				reverseGraph[j].add(i);

		List<List<Integer>> components = new ArrayList<>();
		Arrays.fill(used, false);
		Collections.reverse(order);

		for (int u : order)
			if (!used[u]) {
				List<Integer> component = new ArrayList<>();
				dfs(reverseGraph, used, component, u);
				components.add(component);
			}

		return components;
	}

	static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res,
			int u) {
		used[u] = true;
		for (int v : graph[u])
			if (!used[v])
				dfs(graph, used, res, v);
		res.add(u);
	}

	// Usage example
	public static void main(String[] args) throws IOException {

		SCCKosaraju obj = new SCCKosaraju();
		obj.readLargerTextFile("/Users/viagrawal/learning/SCC.txt");

		List<List<Integer>> components = scc(obj.g);
		Iterator<List<Integer>> itr = components.iterator();

		/*System.out.println("Strongly connected components : ");
		System.out.println(components);*/

		ArrayList<Integer> SCCSizeList = new ArrayList<Integer>();

		while (itr.hasNext()) {
			SCCSizeList.add(itr.next().size());
		}

		Collections.sort(SCCSizeList);

		ListIterator<Integer> li = SCCSizeList.listIterator(SCCSizeList.size());
		int i = 5;
		while (li.hasPrevious() && i > 0) {
			System.out.println("Max [ " + i + " ] : " + li.previous());
			i--;
		}

	}

	void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);

		for (int i = 0; i < g.length; i++)
			g[i] = new ArrayList<Integer>();

		try (Scanner scanner = new Scanner(path)) {

			while (scanner.hasNextInt()) {
				int node = scanner.nextInt();
				int edge = scanner.nextInt();
				g[node - 1].add(edge - 1);
			}
		}
	}

}
