public class Grid {
    private int nbRows;
    private int nbCols;
    private Block[][] grid;

    public Grid(int nbRows, int nbCols){
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.grid = new Block[nbRows][nbCols];
    }

    public Block getBlock(int row, int col){
        return this.grid[row][col];
    }

    public void setBlock(int row, int col, Block block){
        this.grid[row][col] = block;
    }

    public int getNbCols() {
        return nbCols;
    }

    public int getNbRows() {
        return nbRows;
    }
}
