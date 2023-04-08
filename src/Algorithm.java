import java.util.*;

public abstract class Algorithm {
    Grid initialState;
    Grid finalState;
    Graph graph;
    boolean hasSolution = false;
    Stack<Grid> path = new Stack<>();

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
        getSolutionPath();
        while(!path.isEmpty()) {
            Grid grid = path.pop();
            grid.PrintGrid();
            System.out.println("Heuristique: " + (Heuristic1.getValue(grid,finalState) + 3*Heuristic2.getValue(grid,finalState)));
            System.out.println();
        }
    }

    public void getSolutionPath(){
        Grid currentState = finalState;
        path.add(currentState);
        while (!currentState.isEqual(initialState)) {
            for (Map.Entry<Grid, List<Grid>> entry : graph.getAdjVertices().entrySet())
                if (entry.getValue().contains(currentState)) {
                    currentState = entry.getKey();
                    path.add(currentState);
                }
        }
        System.out.println("solution path: " + path.size());
    }

}
