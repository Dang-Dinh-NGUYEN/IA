import java.util.*;

public class Graph {

    private Map<Grid, List<Grid>> adjVertices;
    private Grid root;

    public Graph(Grid root) {
        this.adjVertices = new HashMap<Grid, List<Grid>>();
        this.root = root;
        this.addVertex(root);
    }

    public Map<Grid, List<Grid>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Grid, List<Grid>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    void addVertex(Grid grid) {
        adjVertices.putIfAbsent(grid, new ArrayList<>());
    }

    void removeVertex(Grid grid) {
        adjVertices.values().stream().forEach(e -> e.remove(grid));
        adjVertices.remove(grid);
    }

    void addEdge(Grid grid1, Grid grid2) {
        adjVertices.get(grid1).add(grid2);
    }


    void removeEdge(Grid grid1, Grid grid2) {
        List<Grid> eV1 = adjVertices.get(grid1);
        List<Grid> eV2 = adjVertices.get(grid2);
        if (eV1 != null)
            eV1.remove(grid2);
        if (eV2 != null)
            eV2.remove(grid1);
    }

    public List<Grid> getAdjVertices(Grid grid) {
        return adjVertices.get(grid);
    }

}