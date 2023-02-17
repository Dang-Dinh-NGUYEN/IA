import java.util.*;

public abstract class Algorithm {
    Grid initialState;
    Grid finalState;
    Graph graph;

    public Algorithm(Graph graph, Grid initialState, Grid finalState){
        this.graph = graph;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public boolean isSolvable(){
        return graph.getAdjVertices().containsKey(finalState);
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
                }
        }
        while(!path.isEmpty())
            path.pop().PrintGrid();
    }

}
