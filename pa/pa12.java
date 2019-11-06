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

    public int getVertexCount() {
        return this.vertexCount;
    }
}

public class pa12 {
    private static UndirectedGraph getGraph(Scanner sc) {
        UndirectedGraph graph = new UndirectedGraph();
        String[] vertices = sc.nextLine().split(" ");
        for (String v : vertices) {
            graph.addVertex(v);
        }
        int numEdges = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numEdges; i++) {
            String[] edge = sc.nextLine().split(" ");
            graph.addEdge(edge[0], edge[1]);
        }

        return graph;
    }

    private static boolean Hamiltonian(UndirectedGraph graph, String path, String current) {
        if (path.startsWith(current) && path.length() == graph.getVertexCount()) {
            return true;
        }

        if (path.contains(current)) {
            return false;
        }

        for (String v : graph.getNeighbors(current)) {
            if (Hamiltonian(graph, path + current, v)) { return true; }
        }
        return false;
    }

    private static boolean isHamiltonian(UndirectedGraph graph) {
        if (graph.getVertexCount() == 1 || Hamiltonian(graph, "", graph.getVertices().get(0))) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-->0) {
            UndirectedGraph graph = getGraph(sc);
            System.out.println(isHamiltonian(graph) ? "YES" : "NO");
        }
    }
}