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
        for(int i = 0; i < nbRows; i++)
            if(input.nextLine().length() > nbColumns)
                nbColumns = input.nextLine().length();

        input.close();

        initialGrid = new Grid(nbRows,nbColumns);
        finalGrid = new Grid(nbRows,nbColumns);
        this.blockGenerator = new BlockGenerator(filepath,nbRows,nbColumns);

        initialGrid.fill(blockGenerator.getInitialBlocks());
        finalGrid.fill(blockGenerator.getFinalBlocks());
    }

    public Grid getInitialGrid() {
        return initialGrid;
    }

    public Grid getFinalGrid() {
        return finalGrid;
    }

    public BlockGenerator getBlockGenerator(){
        return blockGenerator;
    }
}
