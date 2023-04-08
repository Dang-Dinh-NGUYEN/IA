import java.util.*;

public class DFSH extends Algorithm{
    Stack<Grid> stack = new Stack<>();

    public void push(Grid grid) {
        // While the stack is not empty and the top element is greater than the new value,
        // pop elements from the stack and push them onto a temporary stack
        Stack<Grid> tempStack = new Stack<>();
        while (!stack.isEmpty() &&
                (Heuristic1.getValue(stack.peek(),finalState) + 3*Heuristic2.getValue(stack.peek(),finalState)) <
                        Heuristic1.getValue(grid,finalState) + 3*Heuristic2.getValue(grid,finalState)) {
            tempStack.push(stack.pop());
        }
        // Push the new value onto the stack
        stack.push(grid);
        // Push the elements from the temporary stack back onto the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public Grid pop() {
        return stack.pop();
    }
    public DFSH(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }
    @Override
    void Handler() {
        Set<String> visited = new LinkedHashSet<String>();
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

            for (CardinalDirection cardinalDirection : CardinalDirection.values()) {
                if (emptySquare.hasNeighbor(cardinalDirection)) {
                    Grid clone = vertex.clone();
                    Square empty = clone.findEmptySquare();
                    clone.move(empty, cardinalDirection);
                    if (!visited.contains(clone.toString()) && !stack.contains(clone)) {
                        super.graph.addVertex(clone);
                        super.graph.addEdge(vertex, clone);
                        push(clone);
                    }
                }
            }
            visited.add(vertex.toString());

        }

    }

}
