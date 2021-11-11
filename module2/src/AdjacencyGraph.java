import java.util.*;

/*
  used https://www.baeldung.com/java-graphs and slightly modified it
 */
public class AdjacencyGraph {
    private Map<Vertex, ArrayList<Vertex>> verticesMap;

    public AdjacencyGraph(){
        this.verticesMap = new HashMap<Vertex, ArrayList<Vertex>>();
    };

    public AdjacencyGraph(Map<Vertex, ArrayList<Vertex>> verticesMap) {
        this.verticesMap = verticesMap;
    }

    public Map<Vertex, ArrayList<Vertex>> getVerticesMap() {
        return verticesMap;
    }

    public void setVerticesMap(Map<Vertex, ArrayList<Vertex>> verticesMap) {
        this.verticesMap = verticesMap;
    }

    public void addVertex(String label) {
        verticesMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        verticesMap.values().stream().forEach(e -> e.remove(v));
        verticesMap.remove(new Vertex(label));
    }

    public void addDirectAndReverseEdges(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        verticesMap.get(v1).add(v2);
        verticesMap.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = verticesMap.get(v1);
        List<Vertex> eV2 = verticesMap.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getAdjacentVertices(String label) {
        return verticesMap.get(new Vertex(label));
    }

    public Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : this.getAdjacentVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : this.getAdjacentVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    public int edgesCount() {
        int result = 0;
        for (Vertex vertex : verticesMap.keySet()) {
            result += verticesMap.get(vertex).size();
        }
        return result;
    }
}
