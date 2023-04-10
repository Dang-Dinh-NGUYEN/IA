import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Grid implements Iterable<Square>{
    private int nbRows;
    private int nbCols;
    private final Square[][] squares;

    public Grid(int nbRows, int nbCols){
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.squares = new Square[nbRows][nbCols];
        for(int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                squares[r][c] = new Square();
            }
        }
        this.setNeighbors();
    }

    public void setNeighbors(){
        for(int r = 0; r < this.getNbRows(); r++) {
            for (int c = 0; c < this.getNbCols(); c++) {
                if (r > 0) getSquare(r, c).setNeighbor(getSquare(r - 1, c), CardinalDirection.NORTH); //has NORTH
                if (r < nbRows - 1) getSquare(r, c).setNeighbor(getSquare(r + 1, c), CardinalDirection.SOUTH); //has SOUTH
                if (c > 0) getSquare(r, c).setNeighbor(getSquare(r, c - 1), CardinalDirection.WEST); //has WEST
                if (c < nbCols - 1) getSquare(r, c).setNeighbor(getSquare(r, c + 1), CardinalDirection.EAST); //has EAST
            }
        }
    }

    public Square getSquare(int row, int col){
        return this.squares[row][col];
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquare(int row, int col, Square square){
        this.squares[row][col] = square;
    }

    public int getNbCols() {
        return nbCols;
    }

    public int getNbRows() {
        return nbRows;
    }

    public void fill(List<Block> blockList){
        int i = 0;
        for(Square square : this) {
            Block block = blockList.get(i);
            square.put(block);
            i++;
        }
    }

    public void fill(String str){
        List<Block> blockList = new ArrayList<>();

        List<Character> chars = str.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        for(Character c : chars){
            blockList.add(new Block(c));
        }

        fill(blockList);
    }

    @Override
    public Iterator<Square> iterator() {
        return new SquareGridIterator(this);
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < this.getNbRows(); i++) {
            for (int j = 0; j < this.getNbCols(); j++) {
                string += this.getSquare(i, j).getBlock().toString();
            }
        }
        return string;
    }

    public void PrintGrid(){
        for(int i = 0; i < this.getNbRows(); i++){
            for(int j = 0; j < this.getNbCols(); j++){
                System.out.print(this.getSquare(i,j).getBlock().toString());
            }
            System.out.println();
        }
    }


    public boolean isEqual(Grid o) {
        for (int i = 0; i < this.getNbRows(); i++) {
            for (int j = 0; j < this.getNbCols(); j++) {
                if (this.getSquare(i, j).getBlock().getValue() != o.getSquare(i, j).getBlock().getValue())
                    return false;
            }
        }
        return true;
    }

    public boolean isEqual(String gridID) {
        return this.toString().equals(gridID);
    }

    public Square findEmptySquare(){
        for (int i = 0; i < this.getNbRows(); i++) {
            for (int j = 0; j < this.getNbCols(); j++) {
                if(this.getSquare(i,j).isEmpty()) {
                    return this.getSquare(i,j);
                }
            }
        }
        return null;
    }


    public void move(Square square, CardinalDirection cardinalDirection) {
        if(!square.isEmpty() || square.getNeighbor(cardinalDirection) == null)
            return;
        square.put(square.getNeighbor(cardinalDirection).getBlock());
        square.getNeighbor(cardinalDirection).put(EmptyBlock.getInstance());
    }

    public Grid clone(){
        Grid clone = new Grid(this.getNbRows(), this.getNbCols());
        for (int i = 0; i < this.getNbRows(); i++) {
            for (int j = 0; j < this.getNbCols(); j++) {
                clone.getSquare(i,j).put(this.getSquare(i,j).getBlock());
                }
            }
        return clone;
    }
}
