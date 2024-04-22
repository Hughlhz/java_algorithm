import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode797 {
    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result=new ArrayList<>();
        path = new LinkedList<>();
        path.add(0);
        dfs(0,graph);
        return result;
    }

    private void dfs(int root,int[][] graph) {
        if (root == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int node : graph[root]) {
            path.add(node);
            dfs(node, graph);
            path.removeLast();
        }

    }
}
