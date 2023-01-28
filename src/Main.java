import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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


        // read in the data
        input = new Scanner(new File("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid"));
        input.nextLine();

        //fill the grids
        for(int i = 0; i < nbRows; ++i){
            if(input.hasNextLine()){
                String line = input.nextLine();
                for(int j = 0; j < nbColumns; j++){
                    if(line.charAt(j) == ' '){
                        initialGrid.setBlock(i,j,EmptyBlock.getInstance());
                    }else{
                        initialGrid.setBlock(i,j,new Block(line.charAt(j)));
                    }
                }
            }
        }

        for(int i = nbRows; i < nbRows*2; ++i){
            if(input.hasNextLine()){
                String line = input.nextLine();
                for(int j = 0; j < nbColumns; j++){
                    if(line.charAt(j) == ' '){
                        finalGrid.setBlock(i - nbRows,j,EmptyBlock.getInstance());
                    }else{
                        finalGrid.setBlock(i - nbRows,j,new Block(line.charAt(j)));
                    }
                }
            }
        }

        System.out.println("initial grid");
        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                System.out.print(initialGrid.getBlock(i,j).toString());
            }
            System.out.println();
        }

        System.out.println("final grid");
        for(int i = 0; i < nbRows; i++){
            for(int j = 0; j < nbColumns; j++){
                System.out.print(finalGrid.getBlock(i,j).toString());
            }
            System.out.println();
        }
    }
}
