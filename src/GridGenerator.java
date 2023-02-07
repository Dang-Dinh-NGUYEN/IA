import java.util.ArrayList;
import java.util.Stack;

public class GridGenerator {
    int x;
    int y;
    Grid initialGrid;
    public GridGenerator(Grid initialGrid){
        ArrayList<Integer> adress=new ArrayList<>();
        this.initialGrid=initialGrid;
        for (int i=0;i<initialGrid.getNbRows();i++){
            for(int j=0;j<initialGrid.getNbCols();j++){
                if (initialGrid.getSquare(i,j).getBlock()instanceof EmptyBlock){
                    x=i;
                    y=j;
                }
            }
        }
    }
    public Grid moveRight(){
        Grid RightGrid=initialGrid;
        if (y-1>=0){
            RightGrid.getSquare(x,y-1).move(CardinalDirection.EAST);
        }
        else{return null;}
        return RightGrid;
    }
    public Grid moveLeft(){
        Grid LeftGrid=initialGrid;
        if (y+1< initialGrid.getNbCols()){
            LeftGrid.getSquare(x,y+1).move(CardinalDirection.WEST);
        }
        else {return null;}
        return LeftGrid;
    }
    public Grid moveUp(){
        Grid UpperGrid=initialGrid;
        if (x+1<initialGrid.getNbRows()){
            UpperGrid.getSquare(x+1,y).move(CardinalDirection.NORTH);
        }else{return null;}
        return UpperGrid;
    }
    public Grid moveDown(){
        Grid DownGrid=initialGrid;
        if (x-1>=0){
            DownGrid.getSquare(x-1,y).move(CardinalDirection.SOUTH);
        }else{return null;}
        return DownGrid;
    }
}
