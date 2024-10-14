import java.util.*;

public class SocialNetworkInfluence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取N, M, K
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // 读取剩余的换行符

        // 创建邻接列表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            graph.add(new ArrayList<>());
        }

        // 读取边
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x); // 无向图
        }
        scanner.close();

        // BFS计算影响力
        int influence = bfs(graph, M, K)-1;
        System.out.println(influence);
    }

    private static int bfs(List<List<Integer>> graph, int start, int k) {
        // 记录访问过的用户
        Set<Integer> visited = new HashSet<>();
        // 记录每个跳数的用户数量
        Map<Integer, Integer> levelCounts = new HashMap<>();
        levelCounts.put(0, 1); // 起始用户自己算作0跳

        // 队列用于BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int currentLevel = 0;
        while (!queue.isEmpty() && currentLevel <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                // 遍历所有邻接节点
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        // 更新级别计数
                        int currentLevelCount = levelCounts.getOrDefault(currentLevel + 1, 0);
                        levelCounts.put(currentLevel + 1, currentLevelCount + 1);
                    }
                }
            }
            currentLevel++;
        }

        // 计算总影响力
        int influence = 0;
        for (int i = 0; i <= k; i++) {
            influence += levelCounts.getOrDefault(i, 0);
        }
        return influence;
    }
}
