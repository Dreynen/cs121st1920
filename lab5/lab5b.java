import java.util.*;

class UndirectedGraph {
    private HashMap<String, ArrayList<String>> adj;
    private int vertexCount;
    private int edgeCount;

    UndirectedGraph() {
        this.adj = new HashMap<String, ArrayList<String>>();
        this.vertexCount = 0;
        this.edgeCount = 0;
    }

    public boolean addVertex(String v) {
        if(this.adj.containsKey(v)) {
            return false;
        }
        adj.put(v, new ArrayList<String>());
        this.vertexCount++;
        return true;
    }

    public boolean addEdge(String u, String v) {
        if( !(this.adj.containsKey(u) && this.adj.containsKey(v)) ) {
            return false;
        }
        ArrayList<String> uNList = this.adj.get(u);
        ArrayList<String> vNList = this.adj.get(v);
        if(uNList.contains(v)) {
            return false;
        }
        uNList.add(v);
        vNList.add(u);
        this.edgeCount++;
        return true;
    }

    public ArrayList<String> getVertices() {
        ArrayList<String> V = new ArrayList<String>(this.adj.keySet());
        return V;
    }

    public ArrayList<String> getNeighbors(String v) {
        if(!this.adj.containsKey(v)) {
            return null;
        }
        return this.adj.get(v);
    }
}

public class lab5b {
    // breadth-first search in graph g starting from vertex s
    public static boolean BFS(UndirectedGraph g, String s) {
        ArrayList<String> V = g.getVertices();
        HashMap<String, Integer> color = new HashMap<String,Integer>();
        HashMap<String, Integer> dist = new HashMap<String,Integer>();
        HashMap<String, String> pred = new HashMap<String,String>();

        // init all vertices, assign to color 0 if starting vertex, else -1
        for(String v : V) {
            if (v.equals(s)) {
                color.put(v, 0);
            } else {
                color.put(v, -1);
            }
            dist.put(v, 0);
            pred.put(v, null);
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(s);

        while (queue.peek() != null) {
            String u = queue.poll();
            ArrayList<String> neighbors = g.getNeighbors(u);
            for (String v : neighbors) {
                if (color.get(v) == -1) {
                    color.put(v, 0);
                    dist.put(v, dist.get(u) + 1);
                    pred.put(v, u);
                    queue.add(v);
                }
            }
            color.put(u, 1);
        }

        for (int c : color.values()) {
            if (c != 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-->0) {
            UndirectedGraph graph = new UndirectedGraph();
            String[] V = sc.nextLine().split(" ");
            for (String v : V) {
                graph.addVertex(v);
            }

            int U = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < U; i++) {
                String[] edge = sc.nextLine().split(" ");
                graph.addEdge(edge[0], edge[1]);
            }

            boolean isConnected = BFS(graph, V[0]);

            if (isConnected) {
                System.out.println("CONNECTED");
            } else {
                System.out.println("DISCONNECTED");
            }
        }
    }
}