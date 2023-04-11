import java.util.*;

public class DFS extends Algorithm{
    Stack<Grid> stack = new Stack<Grid>();

    public DFS(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    @Override
    void Handler() {
        stack.push(super.initialState);

        while (!stack.isEmpty()) {
            Grid currentState = stack.pop();

            if(!visited.contains(currentState.toString())) {
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
                            stack.push(nextState);
                        }
                    }
                }
                visited.add(currentState.toString());
            }
        }
        System.out.println("explored " + visited.size() + " node.s");
    }

}
