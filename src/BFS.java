import java.util.*;

public class BFS extends Algorithm{
    public BFS(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    public void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<Grid> queue = new LinkedList<Grid>();

        queue.add(super.initialState);
        visited.add(super.initialState.toString());
        while (!queue.isEmpty()) {
            Grid vertex = queue.poll();

            if(vertex.isEqual(super.finalState)) {
                super.finalState = vertex;
                super.hasSolution = true;
                System.out.println("explored: " + visited.size() + " node.s");
                return;
            }
            Square emptySquare = vertex.findEmptySquare();

            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid clone = vertex.clone();
                    Square empty = clone.findEmptySquare();
                    clone.move(empty, cardinalDirection);
                    super.graph.addVertex(clone);
                    super.graph.addEdge(vertex,clone);
                }
            }

            for (Grid g : super.graph.getAdjVertices(vertex)) {
                if (!visited.contains(g.toString()) && !queue.contains(g)) {
                    visited.add(g.toString());
                    queue.add(g);
                }
            }
        }
    }

}