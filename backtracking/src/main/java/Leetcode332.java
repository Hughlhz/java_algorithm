import java.util.*;

public class Leetcode332 {
    List<String> path = new LinkedList<>();
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> findItinerary(List<List<String>> tickets) {
        TreeMap<String, LinkedList<String>> destination = new TreeMap<>();
        for (List<String> ticket : tickets) {
            if (!ticket.contains(ticket.get(0))) {
                destination.put(ticket.get(0), new LinkedList<>(Arrays.asList(ticket.get(1))));
            } else {
                destination.get(ticket.get(0)).add(ticket.get(1));
            }
        }
        backtracking(destination,tickets,"JfK");
        return results;
    }

    public void backtracking(TreeMap<String, LinkedList<String>> destination,List<List<String>> tickets,String location) {
        if (path.size() == tickets.size()) {
            results.add(new ArrayList<>(path));
            return;
        }
        for()
    }
}
