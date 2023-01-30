import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner (new File("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid"));

        // pre-read in the number of rows/columns
        int nbRows = input.nextInt();

        int nbColumns = 0;
        for(int i = 0; i < nbRows; i++)
            if(input.nextLine().length() > nbColumns)
                nbColumns = input.nextLine().length();

        input.close();

        //declare initial grid and final grid
        Grid initialGrid = new Grid(nbRows,nbColumns);
        Grid finalGrid = new Grid(nbRows,nbColumns);
        BlockGenerator blockGenerator = new BlockGenerator("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid",nbRows,nbColumns);

        /*
        //blockGenerator test
        System.out.println(blockGenerator.getFinalBlocks().toString());
        System.out.println(blockGenerator.getInitialBlocks().toString());
         */

        initialGrid.fill(blockGenerator.getInitialBlocks());
        finalGrid.fill(blockGenerator.getFinalBlocks());

        /*
        //neighbors test
        System.out.println("initial grid");
        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                System.out.print(initialGrid.getSquare(i,j).getBlock().toString());
            }
            System.out.println();
        }

        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                for(CardinalDirection direction : CardinalDirection.values())
                    try {
                        System.out.println(initialGrid.getSquare(i,j).getBlock().toString() +
                                direction.toString() + ": " + initialGrid.getSquare(i, j).getNeighbor(direction).getBlock());
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
                                direction.toString() + ": " + finalGrid.getSquare(i, j).getNeighbor(direction).getBlock());
                    }catch (Exception e){};
            }
        }
         */
    }
}
