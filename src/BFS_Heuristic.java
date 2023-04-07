import java.util.*;

public class BFS_Heuristic extends Algorithm {
    public BFS_Heuristic(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }
    public void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<Grid> queue = new PriorityQueue<Grid>((a, b) -> (Heuristic1.getValue(a, super.finalState) + 3*Heuristic2.getValue(a, super.finalState)) -
                (Heuristic1.getValue(b, super.finalState) + 3*Heuristic2.getValue(b, super.finalState)));
        queue.add(super.initialState);
        visited.add(super.initialState.toString());

        while (!queue.isEmpty()) {
            Grid vertex = queue.poll();

            if(vertex.isEqual(super.finalState)) {
                System.out.println("visited: " + visited.size() + " nodes");
                super.finalState = vertex;
                super.hasSolution = true;
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

                    if (!visited.contains(clone.toString()) && !queue.contains(clone)) {
                        visited.add(clone.toString());
                        queue.add(clone);
                    }
                }
            }
        }
    }
}
