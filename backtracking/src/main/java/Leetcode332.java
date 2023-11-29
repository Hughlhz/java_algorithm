import java.lang.reflect.Constructor;
import java.util.*;

public class Leetcode332 {
    LinkedList<String> path = new LinkedList<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        TreeMap<String, LinkedList<String>> destination = new TreeMap<>();
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            destination.computeIfPresent(ticket.get(0), (k, v) -> {
                v.add(ticket.get(1));
                return v;
            });
            destination.computeIfAbsent(ticket.get(0), k -> {
                LinkedList v = new LinkedList<>(Arrays.asList(ticket.get(1)));
                return v;
            });
//            if (!destination.containsKey(ticket.get(0))) {
//                destination.put(ticket.get(0), new LinkedList<>(Arrays.asList(ticket.get(1))));
//            } else {
//                destination.get(ticket.get(0)).add(ticket.get(1));
//            }
        }
        for (String s : destination.keySet()) {
            System.out.println(s + ": " + destination.get(s).toString());
        }

        backtracking(destination, tickets.size(), "JFK");
//        Collections.sort(results,(a,b)->a.toString().compareTo(b.toString()));
        result.add(0, "JFK");

        return result;
    }

    public boolean backtracking(TreeMap<String, LinkedList<String>> destination, int len, String location) {
        if (path.size() == len) {
            result = new ArrayList<>(path);
            return true;
        }
        if (destination.get(location) == null) {
            return false;
        }
        for (int i = 0; i < destination.get(location).size(); i++) {
            String s = destination.get(location).get(i);
            path.add(s);
            destination.get(location).remove(i);
            if (backtracking(destination, len, s)) return true;
            path.removeLast();
            destination.get(location).add(i, s);
        }
        return false;
    }
}
//使用used数组
class Leetcode332_ {
    LinkedList<String> path = new LinkedList<>();
    List<String> result = new ArrayList<>();
    boolean used[];
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        used = new boolean[tickets.size()];
        path.add(0, "JFK");

        backtracking(tickets.size(), tickets);
//        Collections.sort(results,(a,b)->a.toString().compareTo(b.toString()));
        path.add(0, "JFK");

        return result;
    }

    public boolean backtracking(int len, List<List<String>> tickets) {
        if (path.size() == len+1) {
            result = new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if(path.getLast().equals(tickets.get(i).get(0)) && !used[i]) {
                path.add(tickets.get(i).get(1));
                used[i]=true;
                if (backtracking(len,tickets)) return true;
                path.removeLast();
                used[i]=false;
            }
        }
        return false;
    }
}

