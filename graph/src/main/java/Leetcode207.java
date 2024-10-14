import java.util.*;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<numCourses;++i){
            adj.add(new ArrayList<>());
        }
        //获取每个课程节点的入度生成邻接表
        for(int []cp:prerequisites){
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        //获取所有入度为0的课程，将其入队
        for(int i=0;i<numCourses;++i){
            if(indegrees[i]==0) q.add(i);
        }
        //BFS topSort
        while(!q.isEmpty()){
            int pre=q.poll();
            numCourses--;
            for(int cur:adj.get(pre)){
                if(--indegrees[cur]==0) q.add(cur);
            }
        }
        //拓扑排序出队次数等于课程个数，返回numCourses==0判断课程是否可以成功安排
        return numCourses==0;
    }
}
