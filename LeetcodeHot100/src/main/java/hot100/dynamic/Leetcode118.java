package hot100.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode118 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = Arrays.asList(new Integer[]{1});
    public List<List<Integer>> generate(int numRows) {

        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>(path));
            path = f(path);
        }
        return result;
    }

    private List<Integer> f(List<Integer> path) {
        List temp=new ArrayList<>();
        temp.add(1);
        for (int i = 0; i < path.size()-1; i++) {
            temp.add(path.get(i) + path.get(i + 1));
        }
        temp.add(1);
        return temp;
    }
}
