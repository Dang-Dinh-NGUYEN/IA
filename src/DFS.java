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
            //vertex.PrintGrid();
            //System.out.println(stack.size());
            if(vertex.isEqual(super.finalState)) {
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
                }
            }

            for (Grid g : super.graph.getAdjVertices(vertex)) {
                if (!visited.contains(g.toString()) && !stack.contains(g)) {
                    visited.add(g.toString());
                    stack.add(g);
                }
            }

        }
    }
}
