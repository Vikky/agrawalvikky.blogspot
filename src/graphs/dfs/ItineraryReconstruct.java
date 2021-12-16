package graphs.dfs;

import java.util.*;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure
 * and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * <p>All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with
 * "JFK". If there are multiple valid itineraries, you should return the itinerary that has the
 * smallest lexical order when read as a single string.
 *
 * <p>For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. You
 * may assume all tickets form at least one valid itinerary. You must use all the tickets once and
 * only once.
 */
public class ItineraryReconstruct {

  LinkedList<String> result;

  public static void main(String[] args) {
    ItineraryReconstruct itineraryReconstruct = new ItineraryReconstruct();

    List<List<String>> tickets = new ArrayList<>();
    String[][] arr = new String[][] {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
    for (String[] strings : arr) {
      List<String> list = new ArrayList<>();
      list.add(strings[0]);
      list.add(strings[1]);
      tickets.add(list);
    }

    List<String> path = itineraryReconstruct.findItinerary(tickets);
    itineraryReconstruct.printList(path);
  }

  public List<String> findItinerary(List<List<String>> tickets) {

    result = new LinkedList();
    if (tickets == null) return result;

    int length = tickets.size();

    Map<String, LinkedList<String>> flights = new HashMap();

    for (int i = 0; i < length; i++) {
      List<String> list = tickets.get(i);
      String source = list.get(0);
      String destinations = list.get(1);

      if (flights.containsKey(source)) flights.get(source).add(destinations);
      else {
        LinkedList<String> ll = new LinkedList();
        ll.add(destinations);
        flights.put(source, ll);
      }
    }

    flights.forEach((key, value) -> Collections.sort(value));
    dfs(flights, "JFK");
    return result;
  }

  private void dfs(Map<String, LinkedList<String>> flights, String source) {
    if (flights.containsKey(source)) {
      LinkedList<String> dest = flights.get(source);
      while (!dest.isEmpty()) {
        String next = dest.pollFirst();
        dfs(flights, next);
      }
    }
    this.result.offerFirst(source);
  }

  private void printList(List<String> list) {
    list.forEach(str -> System.out.print(str + "->"));
    System.out.println();
  }
}
