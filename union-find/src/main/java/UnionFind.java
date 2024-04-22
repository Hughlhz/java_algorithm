public class UnionFind {
    private  int count;//连通分量的个数
    private int[] parent;//记录每个节点的父节点，父节点为自身的是根节点
    private int[] size;//记录每个连通分量的大小

    public UnionFind(int n){
        //初始化，每个节点的父节点是自己，每个连通分量的大小是1
        this.count=n;
        parent=new int[n];
        size=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    public int getCount(){
        return count;
    }
    public int find(int p){
        int root=p;
        while (root!=parent[root]){
            root=parent[root];
        }
        // 路径压缩
        while (p != root) {
            int next=parent[p];
            parent[p]=root;
            p=next;
        }
        return root;

    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ){
            return;
        }
        if(size[rootP]>size[rootQ]){
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }else {
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }
        count--;
    }
}
