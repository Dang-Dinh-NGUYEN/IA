import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game taquin = new Game("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_2x4d.grid");
        taquin.solver(new DFSH((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid()));
        //System.out.println();
        //taquin.solver(new DFS((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid()));
        //System.out.println();
        //taquin.solver(new BFSH((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid()));
        //System.out.println();
        //taquin.solver(new BFS((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid()));
        //System.out.println();
    }
}
