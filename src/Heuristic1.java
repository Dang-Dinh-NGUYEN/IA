public class Heuristic1 implements Heuristic{
    //Distance de Hamming
    public static int getValue(Grid grid1, Grid grid2){
        String s1 = grid1.toString();
        String s2 = grid2.toString();
        int count = 0;
        for (int i = 0 ; i < grid1.getNbRows() ; i++) {
            for (int j = 0; j < grid1.getNbCols(); j++) {
                if(grid1.getSquare(i,j).isEmpty()) continue;
                count += grid1.getSquare(i,j).getBlock().getValue() == grid2.getSquare(i,j).getBlock().getValue() ? 1 : 0;
            }
        }
        //System.out.println(s1 + "$ " + s2 + "$");
        return grid1.getNbRows() * grid1.getNbCols() - count - 1;
    }

}
