package skasaher.alg.ds;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 图(邻接表作为非稠密图的标准表示)
 */
public class Graph {
    private final int V;        //顶点数目
    private int E;              //边数目
    private Bag<Integer>[] adj; //邻接表

    /**
     * 计算v的度数
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            int degree = degree(G, v);
            if (degree > max) max = degree;
        }
        return max;
    }

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];  //创建邻接表
        for (int v = 0; v < V; v++) {       //初始化所有邻接表
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());     //读取V并将图初始化
        int E = in.readInt();   //读取E
        for (int i = 0; i < E; i++) {
            int v = in.readInt();   //读取一个顶点
            int w = in.readInt();   //读取另一个顶点
            addEdge(v, w);          //添加一条连接它们的边
        }
    }

    /**
     * 顶点数
     */
    public int V() {
        return V;
    }

    /**
     * 边数
     */
    public int E() {
        return E;
    }

    /**
     * 向图中添加一条边 v-w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);      //将w添加到v的链表中
        adj[w].add(v);      //将v添加到w的链表中
        E++;
    }

    /**
     * 和v相邻的所有顶点
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v)) s.append(w).append(" ");
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
