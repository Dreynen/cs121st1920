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

public class lab5a {
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

            ArrayList<String> vertices = graph.getVertices();
            Collections.sort(vertices);
            for (String v : vertices) {
                ArrayList<String> neighbors = graph.getNeighbors(v);
                Collections.sort(neighbors);
                System.out.print(v + ":");
                for (String n : neighbors) {
                    System.out.print(" " + n);
                }
                System.out.println();
            }
        }
    }
}