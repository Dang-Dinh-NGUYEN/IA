import java.util.*;

public class DFSH extends Algorithm{
    public DFSH(Graph graph, Grid initialState, Grid finalState){
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

            PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
                @Override
                public int compare(Grid grid1, Grid grid2) {
                    return Heuristic1.getValue(grid1,finalState) + 3*Heuristic2.getValue(grid1,finalState) <=
                            Heuristic1.getValue(grid2,finalState) + 3*Heuristic2.getValue(grid2,finalState) ? 1:0;
                }
            });

            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid clone = vertex.clone();
                    Square empty = clone.findEmptySquare();
                    clone.move(empty, cardinalDirection);
                    super.graph.addVertex(clone);
                    super.graph.addEdge(vertex,clone);
                    priorityQueue.add(clone);
                }
            }

            while (!priorityQueue.isEmpty()){
                Grid g = priorityQueue.poll();
                if (!visited.contains(g.toString())) {
                    visited.add(g.toString());
                    stack.add(g);
                }
            }
        }
    }

}
