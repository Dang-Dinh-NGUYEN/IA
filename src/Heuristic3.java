public class Heuristic3 implements Heuristic {
    public static int getValue(Grid grid1, Grid grid2) {
        return Heuristic1.getValue(grid1, grid2) + 3 * Heuristic2.getValue(grid1, grid2);
    }
}
