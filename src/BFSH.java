import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class BFSH extends Algorithm{
    public BFSH(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    public void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
        PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
            @Override
            public int compare(Grid grid1, Grid grid2) {
                return Heuristic1.getValue(grid1,finalState) + 3*Heuristic2.getValue(grid1,finalState) <
                        Heuristic1.getValue(grid2,finalState) + 3*Heuristic2.getValue(grid2,finalState) ? 0:1;
            }
        });

        priorityQueue.add(super.initialState);
        visited.add(super.initialState.toString());
        while (!priorityQueue.isEmpty()){
            Grid vertex = priorityQueue.poll();

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
                    if (!visited.contains(clone.toString()) && !priorityQueue.contains(clone)) {
                        super.graph.addVertex(clone);
                        super.graph.addEdge(vertex, clone);
                        priorityQueue.add(clone);
                    }
                }
            }
            visited.add(vertex.toString());

        }

    }

}
