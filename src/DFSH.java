import java.util.*;

public class DFSH extends Algorithm{
    Stack<Grid> stack = new Stack<Grid>();
    PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
        @Override
        public int compare(Grid grid1, Grid grid2) {
            int h1 = Heuristic3.getValue(grid1, finalState);
            int h2 = Heuristic3.getValue(grid2, finalState);
            return Integer.compare(h2, h1);
        }
    });

    public DFSH(Graph graph, Grid initialState, Grid finalState){
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

                /*
                System.out.println("CurentState: ");
                currentState.PrintGrid();
                System.out.println(Heuristic3.getValue(currentState,finalState));
                System.out.println("Exploring states: ");
                */

                for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                    if (emptySquare.hasNeighbor(cardinalDirection)) {
                        Grid nextState = currentState.clone();
                        Square empty = nextState.findEmptySquare();
                        nextState.move(empty, cardinalDirection);
                        if (!visited.contains(nextState.toString())) {
                            super.graph.addVertex(nextState);
                            super.graph.addEdge(currentState, nextState);
                            priorityQueue.offer(nextState);

                            /*
                            nextState.PrintGrid();
                            System.out.println("Heuristique: " + Heuristic3.getValue(nextState,finalState));
                            System.out.println();
                            */

                        }
                    }
                }
                while (!priorityQueue.isEmpty())
                    stack.push(priorityQueue.poll());

                /*
                System.out.println("-------------------------------------------------------");
                */

                visited.add(currentState.toString());
            }
        }
        System.out.println("explored " + visited.size() + " node.s");
    }

}
