public class Heuristic2 implements Heuristic{
    //Distance de Manhattan
    public static int getValue(Grid grid1, Grid grid2) {
        int numRows = grid1.getNbRows();
        int numCols = grid1.getNbCols();
        int totalDistance = 0;

        for (int row1 = 0; row1 < numRows; row1++) {
            for (int col1 = 0; col1 < numCols; col1++) {
                char value = grid1.getSquare(row1,col1).getBlock().getValue();
                if (value == ' ') continue;
                int correctRow = -1;
                int correctCol = -1;

                // Find the correct position of the value in Matrix B
                for (int row2 = 0; row2 < numRows; row2++) {
                    for (int col2 = 0; col2 < numCols; col2++) {
                        if (grid2.getSquare(row2,col2).getBlock().getValue() == value) {
                            correctRow = row2;
                            correctCol = col2;
                            break;
                        }
                    }
                }

                // Calculate the Manhattan distance between the cell in Matrix A and its correct position in Matrix B
                int distance = Math.abs(row1 - correctRow) + Math.abs(col1 - correctCol);
                totalDistance += distance;
            }
        }

        return totalDistance;
    }
}
