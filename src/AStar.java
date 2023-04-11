import java.util.*;

public class AStar extends Algorithm{
    PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
        @Override
        public int compare(Grid grid1, Grid grid2) {
            int h1 = Heuristic2.getValue(initialState, grid1) + Heuristic3.getValue(grid1, finalState);
            int h2 = Heuristic2.getValue(initialState, grid2) + Heuristic3.getValue(grid2, finalState);
            if(h1 == h2){
                return Integer.compare(Heuristic2.getValue(initialState, grid1), Heuristic2.getValue(initialState, grid2));
            }else {
                return Integer.compare(h1,h2);
            }
        }
    });

    public AStar (Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    /*Relevez les bloques de commentaires dans la méthode suivante pour observer les étapes d'exécution sur la console*/
    public void Handler() {
        priorityQueue.offer(super.initialState);

        while (!priorityQueue.isEmpty()){
            Grid currentState = priorityQueue.poll();

            if(!visited.contains(currentState.toString())) {

                /*
                System.out.println("CurentState: ");
                currentState.PrintGrid();
                System.out.printf("f = g + h = %d + %d = %d\n",
                        Heuristic2.getValue(initialState,currentState),Heuristic3.getValue(currentState,finalState),
                        (Heuristic2.getValue(initialState,currentState) + Heuristic3.getValue(currentState,finalState)));
                System.out.println("Exploring states: ");
                 */

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

                            /*
                            nextState.PrintGrid();
                            System.out.printf("f = g + h = %d + %d = %d\n",
                                    Heuristic2.getValue(initialState,nextState),Heuristic3.getValue(nextState,finalState),
                                    (Heuristic2.getValue(initialState,nextState) + Heuristic3.getValue(nextState,finalState)));
                            System.out.println();
                             */
                        }
                    }
                }

                /*
                System.out.println("-------------------------------------------------------");
                */

                visited.add(currentState.toString());
            }
        }
        System.out.println("explored: " + visited.size() + " node.s");

    }

}
