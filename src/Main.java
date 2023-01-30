import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game taquin = new Game("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid");

        /*
        //blockGenerator test
        System.out.println(taquin.getBlockGenerator().getInitialBlocks().toString());
        System.out.println(taquin.getBlockGenerator().getFinalBlocks().toString());
         */


        //neighbors test
        System.out.println("initial grid");
        for(int i = 0; i <taquin.getInitialGrid().getNbRows(); i++){
            for(int j = 0; j < taquin.getInitialGrid().getNbCols(); j++){
                System.out.print(taquin.getInitialGrid().getSquare(i,j).getBlock().toString());
            }
            System.out.println();
        }

        taquin.getInitialGrid().getSquare(1,1).move(CardinalDirection.SOUTH);

        System.out.println("initial grid");
        for(int i = 0; i <taquin.getInitialGrid().getNbRows(); i++){
            for(int j = 0; j < taquin.getInitialGrid().getNbCols(); j++){
                System.out.print(taquin.getInitialGrid().getSquare(i,j).getBlock().toString());
            }
            System.out.println();
        }

        /*
        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                for(CardinalDirection direction : CardinalDirection.values())
                    try {
                        System.out.println(initialGrid.getSquare(i,j).getBlock().toString() +
                                direction.toString() + ": " + initialGrid.getSquare(i, j).getNeighbor(direction).getBlock() +
                                " >> " + initialGrid.getSquare(i, j).movable(direction));

                    }catch (Exception e){};
            }
        }

        System.out.println("final grid");
        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                System.out.print(finalGrid.getSquare(i,j).getBlock().toString());
            }
            System.out.println();
        }

        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                for(CardinalDirection direction : CardinalDirection.values())
                    try {
                        System.out.println(finalGrid.getSquare(i,j).getBlock().toString() +
                                direction.toString() + ": " + finalGrid.getSquare(i, j).getNeighbor(direction).getBlock() +
                                " >> " + initialGrid.getSquare(i, j).movable(direction));
                    }catch (Exception e){};
            }
        }
         */
    }
}
