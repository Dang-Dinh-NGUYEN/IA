import java.util.*;

public class AStar extends Algorithm {
    public AStar(Graph graph, Grid initialState, Grid finalState) {
        super(graph, initialState, finalState);
    }

    @Override
    void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
        PriorityQueue<Grid> queue = new PriorityQueue<>((grid1, grid2) -> {
            int value1 = Heuristic3.getValue(grid1, finalState);
            int value2 = Heuristic3.getValue(grid2, finalState);
            return Integer.compare(value1, value2);
        });
        queue.add(super.initialState);
        visited.add(super.initialState.toString());
        while (!queue.isEmpty()) {
            Grid currentState = queue.poll();
            if (currentState.isEqual(super.finalState)) {
                super.finalState = currentState;
                super.hasSolution = true;
                System.out.println("explored " + visited.size() + " node.s");
                return;
            }
            Square emptySquare = currentState.findEmptySquare();
            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid nextState = currentState.clone();
                    Square empty = nextState.findEmptySquare();
                    nextState.move(empty, cardinalDirection);
                    super.graph.addVertex(nextState);
                    super.graph.addEdge(currentState, nextState);
                    if (!visited.contains(nextState.toString())) {
                        visited.add(nextState.toString());
                        queue.add(nextState);
                    }
                }
            }
        }
    }
}