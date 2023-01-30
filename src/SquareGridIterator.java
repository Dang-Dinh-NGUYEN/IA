
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SquareGridIterator implements Iterator<Square>{
    private Grid grid;
    static int currentRow;
    static int currentColumn;

    public SquareGridIterator(Grid grid){
        this.grid = grid;
        currentRow = 0;
        currentColumn = -1;
    }

    @Override
    public boolean hasNext() {
        return ((currentRow + 1) < grid.getNbRows()) || ((currentColumn + 1) < grid.getNbCols());
    }

    @Override
    public Square next() {
        if(!hasNext()) throw new NoSuchElementException();
        if (hasNext()) {
            if (currentColumn + 1 < grid.getNbCols()) {
                currentColumn++;
            }
            else {
                currentColumn = 0;
                currentRow++;
            }
            return grid.getSquare(currentRow, currentColumn);
        }
        return grid.getSquare(currentRow, currentColumn);
    }
}


