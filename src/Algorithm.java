import java.util.*;

public abstract class Algorithm {
    Grid initialState;
    Grid finalState;
    Graph graph;
    boolean hasSolution = false;

    public Algorithm(Graph graph, Grid initialState, Grid finalState){
        this.graph = graph;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    abstract void Handler();

    public boolean hasSolution(){
        return hasSolution;
    }

    public void printSolution() {
        Stack<Grid> path = new Stack<>();
        Grid currentState = finalState;
        path.add(currentState);
        while (!currentState.isEqual(initialState)) {
            for (Map.Entry<Grid, List<Grid>> entry : graph.getAdjVertices().entrySet())
                if (entry.getValue().contains(currentState)) {
                    currentState = entry.getKey();
                    path.add(currentState);
                    currentState.PrintGrid();
                }
        }
        System.out.println("solution path: ");
        while(!path.isEmpty())
            path.pop().PrintGrid();
    }

}
