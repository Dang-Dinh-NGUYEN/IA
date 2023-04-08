import java.util.*;

public class DFS extends Algorithm{
    public DFS(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    @Override
    void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<Grid> stack = new Stack<Grid>();
        stack.add(super.initialState);
        visited.add(super.initialState.toString());
        while (!stack.isEmpty()) {
            Grid vertex = stack.pop();

            if(vertex.isEqual(super.finalState)) {
                super.finalState = vertex;
                super.hasSolution = true;
                System.out.println("explored " + visited.size() + " node.s");
                return;
            }
            Square emptySquare = vertex.findEmptySquare();

            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid clone = vertex.clone();
                    Square empty = clone.findEmptySquare();
                    clone.move(empty, cardinalDirection);
                    if (!visited.contains(clone.toString()) && !stack.contains(clone)) {
                        super.graph.addVertex(clone);
                        super.graph.addEdge(vertex, clone);
                        stack.add(clone);
                    }
                }
            }
            visited.add(vertex.toString());

        }

    }

}
