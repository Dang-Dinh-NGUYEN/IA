import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private Grid initialGrid;
    private Grid finalGrid;
    private BlockGenerator blockGenerator;

    public Game(String filepath) throws FileNotFoundException {
        Scanner input = new Scanner (new File(filepath));

        // pre-read in the number of rows/columns
        int nbRows = input.nextInt();

        int nbColumns = 0;
        for(int i = 0; i < nbRows + 1; i++) {
            String str = input.nextLine();
            if ( str.length() > nbColumns)
                nbColumns = str.length();
        }
        input.close();
        initialGrid = new Grid(nbRows,nbColumns);
        finalGrid = new Grid(nbRows,nbColumns);
        this.blockGenerator = new BlockGenerator(filepath, nbRows, nbColumns);

        initialGrid.fill(blockGenerator.getInitialBlocks());
        finalGrid.fill(blockGenerator.getFinalBlocks());
    }

    public Grid getInitialGrid() {
        return initialGrid;
    }

    public Grid getFinalGrid() {
        return finalGrid;
    }

    public void solver(Algorithm algo){
        long startTime = System.nanoTime();
        algo.Handler();
        long endTime = System.nanoTime();
        System.out.println("running time: " + (endTime - startTime)/1000000000.0 + "s");
        System.out.println("grid resolvable: " + algo.hasSolution());
        //if(algo.hasSolution()) algo.printSolution();
    }
}
