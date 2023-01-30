import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BlockGenerator {
    private final List<Block> initialBlocks = new ArrayList<>();
    private final List<Block> finalBlocks = new ArrayList<>();


    public BlockGenerator(String filepath, int nbRows, int nbCols) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid"));
        input.nextLine();

        for (int i = 0; i < nbRows; ++i) {
            if (input.hasNextLine()) {
                String line = input.nextLine();
                for (int j = 0; j < nbCols; j++) {
                    if (line.charAt(j) == ' ') {
                        initialBlocks.add(EmptyBlock.getInstance());
                    } else {
                        initialBlocks.add(new Block(line.charAt(j)));
                    }
                }
            }
        }

        for(int i = nbRows; i < nbRows*2; ++i){
            if(input.hasNextLine()){
                String line = input.nextLine();
                for(int j = 0; j < nbCols; j++){
                    if(line.charAt(j) == ' '){
                        finalBlocks.add(EmptyBlock.getInstance());
                    }else{
                        finalBlocks.add(new Block(line.charAt(j)));
                    }
                }
            }
        }
    }

    public List<Block> getFinalBlocks() {
        return finalBlocks;
    }

    public List<Block> getInitialBlocks() {
        return initialBlocks;
    }
}
