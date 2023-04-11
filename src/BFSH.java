import java.util.*;

public class BFSH extends Algorithm{
    Queue<Grid> queue = new LinkedList<>();
    PriorityQueue<Grid> priorityQueue = new PriorityQueue<>(new Comparator<Grid>() {
        @Override
        public int compare(Grid grid1, Grid grid2) {
            int h1 = Heuristic3.getValue(grid1, finalState);
            int h2 = Heuristic3.getValue(grid2, finalState);
            return Integer.compare(h1, h2);
        }
    });

    public BFSH(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    /*Relevez les bloques de commentaires dans la méthode suivante pour observer les étapes d'exécution sur la console*/
    public void Handler() {
        queue.offer(super.initialState);

        while (!queue.isEmpty()){
            Grid currentState = queue.poll();

            if(!visited.contains(currentState.toString())) {

                /*
                System.out.println("CurentState: ");
                currentState.PrintGrid();
                System.out.println(Heuristic3.getValue(currentState,finalState));
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
                            System.out.println("Heuristique: " + Heuristic3.getValue(nextState,finalState));
                            System.out.println();
                             */

                        }
                    }
                }

                while (!priorityQueue.isEmpty())
                    queue.offer(priorityQueue.poll());

                /*
                System.out.println("-------------------------------------------------------");
                */

                visited.add(currentState.toString());
            }
        }
        System.out.println("explored: " + visited.size() + " node.s");

    }

}
