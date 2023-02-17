import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Square {
    private Block block;
    private final Square[] neighbors = new Square[CardinalDirection.NUMBER_OF_DIRECTIONS];

    public Square(){}

    public Block getBlock(){
        return this.block;
    }

    public void put(Block block){
        this.block = block;
    }

    public void setNeighbor(Square neighbor, CardinalDirection direction){
        neighbors[direction.ordinal()] = neighbor;
    }

    public boolean hasNeighbor(CardinalDirection direction){
        return getNeighbor(direction) != null;
    }

    public Square getNeighbor(CardinalDirection direction) {
        return neighbors[direction.ordinal()];
    }

    public Square[] getNeighbors() {
        return neighbors;
    }

    public boolean isEmpty() {
        return this.getBlock().toString().equals(EmptyBlock.getInstance().toString());
    }

}
