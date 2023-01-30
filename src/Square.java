import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Square {
    private Block block;
    private final Square[] neighbors = new Square[CardinalDirection.NUMBER_OF_DIRECTIONS];

    public Square(){
        //this.block = EmptyBlock.getInstance();
        //IntStream.range(0, neighbors.length).forEachOrdered(i -> neighbors[i] = EmptyBlock.getInstance());
    }

    public Block getBlock(){
        return this.block;
    }

    public void put(Block block){
        this.block = block;
    }

    public void setNeighbor(Square neighbor, CardinalDirection direction){
        neighbors[direction.ordinal()] = neighbor;
    }


    public Square getNeighbor(CardinalDirection direction) {
        return neighbors[direction.ordinal()];
    }

    public boolean movable(CardinalDirection direction) throws NullPointerException{
        return this.getNeighbor(direction).getBlock() == EmptyBlock.getInstance();
    }

    public boolean move(CardinalDirection cardinalDirection){
        if(!this.movable(cardinalDirection))
            return false;
        this.getNeighbor(cardinalDirection).put(this.getBlock());
        this.put(EmptyBlock.getInstance());
        return true;
    }

}
