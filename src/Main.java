import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game taquin = new Game("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_3x3.grid");

        Graph graph = new Graph(taquin.getInitialGrid());
        BFS bfs = new BFS(graph, taquin.getInitialGrid(), taquin.getFinalGrid());
        bfs.BFSHandler();

        if(bfs.isSolvable())
            bfs.printSolution();
    }
}
