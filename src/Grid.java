import java.util.Iterator;
import java.util.List;

public class Grid implements Iterable<Square> {
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

    public void setSquares(int row, int col, Square square){
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

    @Override
    public Iterator<Square> iterator() {
        return new SquareGridIterator(this);
    }
}
