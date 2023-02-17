import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS extends Algorithm{
    public BFS(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    public void BFSHandler() {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<Grid> queue = new LinkedList<Grid>();
        queue.add(this.initialState);
        visited.add(this.initialState.toString());
        while (!queue.isEmpty()) {
            Grid vertex = queue.poll();
            vertex.PrintGrid();
            if(vertex.isEqual(finalState)) {
                return;
            }
            Square emptySquare = vertex.findEmptySquare();

            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid clone = vertex.clone();
                    Square empty = clone.findEmptySquare();
                    clone.move(empty, cardinalDirection);
                    vertex.PrintGrid();
                    clone.PrintGrid();
                    this.graph.addVertex(clone);
                    this.graph.addEdge(vertex,clone);
                }
            }

            for (Grid g : graph.getAdjVertices(vertex)) {
                if (!visited.contains(g.toString()) && !queue.contains(g)) {
                    visited.add(g.toString());
                    queue.add(g);
                }
            }

        }
    }
}
