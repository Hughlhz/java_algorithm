import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode93 {
    List<List<String>> results = new ArrayList<>();
    List<String> final_results = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        for (int i = 0; i < results.size(); i++) {
            final_results.add(results.get(i).stream().collect(Collectors.joining(".")));
        }
        return final_results;
    }

    public void backtracking(String s, int start, int depth) {
        if (depth == 4 && start >= s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isSubIP(s.substring(start, i + 1)))
                path.add(s.substring(start, i + 1));
            else continue;
            backtracking(s, i + 1, depth + 1);
            path.removeLast();
        }

    }

    public boolean isSubIP(String s) {
        if(s.length()>3) return false;
        if (s.charAt(0) != '0' && Integer.valueOf(s) >= 1 && Integer.valueOf(s) <= 255)
            return true;
        if (Integer.valueOf(s) == 0 && s.length() == 1)
            return true;
        return false;
    }
}
