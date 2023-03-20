import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game taquin = new Game("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_2x4b.grid");
        taquin.solver(new DFSH((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid()));
    }
}
