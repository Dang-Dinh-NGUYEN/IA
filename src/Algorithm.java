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
    public void printSolution(){
        for(Grid state : graph.getAdjVertices(finalState))
            state.PrintGrid();
    }
}
