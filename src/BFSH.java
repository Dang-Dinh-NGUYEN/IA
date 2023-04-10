import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class BFSH extends Algorithm{
    public BFSH(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    public void Handler() {
        PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
            @Override
            public int compare(Grid grid1, Grid grid2) {
                return Heuristic3.getValue(grid1,finalState) < Heuristic3.getValue(grid2,finalState) ? 0:1;
            }
        });

        priorityQueue.offer(super.initialState);

        while (!priorityQueue.isEmpty()){
            Grid currentState = priorityQueue.poll();

            if(!visited.contains(currentState.toString())) {
                System.out.println("CurentState: ");
                currentState.PrintGrid();
                System.out.println(Heuristic3.getValue(currentState,finalState));
                System.out.println("Exploring states: ");
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
                            priorityQueue.offer(nextState);
                            nextState.PrintGrid();
                            System.out.println(Heuristic3.getValue(nextState,finalState));
                            System.out.println();
                        }
                    }
                }
                System.out.println("-------------------------------------------------------");
                visited.add(currentState.toString());
            }
        }
        System.out.println("explored: " + visited.size() + " node.s");

    }

}
