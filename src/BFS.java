import java.util.*;

public class BFS extends Algorithm{
    Queue<Grid> queue = new LinkedList<>();

    public BFS(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    public void Handler() {
        queue.add(super.initialState);

        while (!queue.isEmpty()) {
            Grid currentState = queue.poll();

            if (!visited.contains(currentState.toString())) {
                if (currentState.isEqual(super.finalState)) {
                    super.finalState = currentState;
                    super.hasSolution = true;
                    break;
                }
                Square emptySquare = currentState.findEmptySquare();

                for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                    if (emptySquare.hasNeighbor(cardinalDirection)) {
                        Grid nextState = currentState.clone();
                        Square empty = nextState.findEmptySquare();
                        nextState.move(empty, cardinalDirection);

                        if (!visited.contains(nextState.toString())) {
                            super.graph.addVertex(nextState);
                            super.graph.addEdge(currentState, nextState);
                            queue.add(nextState);
                        }
                    }
                }
                visited.add(currentState.toString());
            }

        }
        System.out.println("explored: " + visited.size() + " node.s");

    }

}
