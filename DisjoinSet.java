public class DisjoinSet {
    private int[] parent;

    public DisjoinSet(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int find(int i){
        if(i==parent[i]) return i;
        else{
            parent[i]=find(parent[i]);    //路径压缩，指向根
            return parent[i];
        }
    }

    public void union(int i, int j){
        int parent1 = find(i);
        int parent2 = find(j);
        parent[parent1]=parent2;
    }

    public boolean isSame(int i, int j){
        return (find(i)==find(j));
    }
    public static  void main(String[] args) {
            int n = 5; // 假设有5个元素
            DisjoinSet dsu = new DisjoinSet(n);
            // 合并一些集合
            dsu.union(0, 1);
            dsu.union(2, 3);
            dsu.union(0, 4);

            // 查找元素所在集合的根节点
            System.out.println("Root of 1: " + dsu.find(1)); // 应该打印 0
            System.out.println("Root of 3: " + dsu.find(3)); // 应该打印 2
            System.out.println("Root of 4: " + dsu.find(4)); // 应该打印 0
            System.out.println(dsu.isSame(1,4));
        }

}
