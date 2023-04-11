import java.util.*;

public class Greedy extends Algorithm{
    Stack<Grid> stack = new Stack<>();

    public void push(Grid grid) {
        // While the stack is not empty and the top element is greater than the new value,
        // pop elements from the stack and push them onto a temporary stack
        Stack<Grid> tempStack = new Stack<>();
        while (!stack.isEmpty() &&
                (Heuristic3.getValue(stack.peek(),finalState) < Heuristic3.getValue(grid,finalState))) {
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

    public Greedy(Graph graph, Grid initialState, Grid finalState){
        super(graph,initialState,finalState);
    }

    @Override
    void Handler() {
        stack.add(super.initialState);

        while (!stack.isEmpty()) {
            Grid currentState = stack.pop();

            if (!visited.contains(currentState.toString())) {
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
                            push(nextState);

                            /*
                            nextState.PrintGrid();
                            System.out.println("Heuristique: " + Heuristic3.getValue(nextState,finalState));
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
        System.out.println("explored " + visited.size() + " node.s");
    }

}
