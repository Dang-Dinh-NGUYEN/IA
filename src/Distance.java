import java.util.ArrayList;

public class Distance {
    private Grid grid1;
    private Grid grid2;
    public Distance(Grid grid1,Grid grid2){
        this.grid1=grid1;
        this.grid2=grid2;
    }
    public ArrayList<Integer> searchSquare(Square square){
        ArrayList<Integer> adress=new ArrayList<>();
        for (int i=0;i< grid2.getNbRows();i++){
            for(int j=0;j< grid2.getNbCols();j++){
                if(square.getBlock().getValue()==grid2.getSquare(i,j).getBlock().getValue()){
                    adress.add(i);
                    adress.add(j);
                }
            }
        }
        return adress;
    }
    public int ManhattanDistance(){
        int Manhattan_distance=0;
        for (int i=0;i< grid1.getNbRows();i++){
            for(int j=0;j< grid1.getNbCols();j++){
                if(!(grid1.getSquare(i,j).getBlock() instanceof EmptyBlock)) {
                    ArrayList<Integer> adress = searchSquare(grid1.getSquare(i, j));
                    int dist = Math.abs(i - adress.get(0)) + Math.abs(j - adress.get(1));
                    Manhattan_distance += dist;
                }
            }
        }
        return Manhattan_distance;
    }
    public int HammingDistance(){
        int counter=0;
        for (int i=0;i< grid1.getNbRows();i++){
            for(int j=0;j< grid1.getNbCols();j++){
                if(grid1.getSquare(i,j).getBlock().getValue()!=grid2.getSquare(i,j).getBlock().getValue()&& !(grid1.getSquare(i,j).getBlock() instanceof EmptyBlock)){
                    counter++;
                }
            }
        }
        return counter;
    }
}
