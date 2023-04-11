public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws Exception {
        Game taquin = new Game("C:\\Users\\Dang Dinh NGUYEN\\Documents\\L3_INFO\\S6\\IA\\grilles\\grilles\\taquin_5x5f.grid");

        /*PARCOURS EN LARGEUR (SANS HEURISTIQUE)*/
        /*
        BFS parcoursLargeur = new BFS((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(parcoursLargeur);
        System.out.println();
        */

        /*PARCOURS EN PROFONDEUR (SANS HEURISTIQUE)*/
        /*
        DFS parcoursProfond = new DFS((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(parcoursProfond);
        System.out.println();
        */

        /*PARCOURS EN LARGEUR (EN UTILISANT HEURISTIQUE)*/
        /*
        BFSH parcoursLargeurH = new BFSH((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(parcoursLargeurH);
        System.out.println();
        */

        /*PARCOURS EN PROFONDEUR (EN UTILISANT HEURISTIQUE)*/
        /*
        DFSH parcoursProfondH = new DFSH((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(parcoursProfondH);
        System.out.println();
        */

        /*LA RECHERCHE LE MEILLEUR D'ABORD*/

        Greedy greedy = new Greedy((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(greedy);
        System.out.println();


        /*L'ALGORITHME A ETOILE*/

        AStar aStar = new AStar((new Graph(taquin.getInitialGrid())), taquin.getInitialGrid(), taquin.getFinalGrid());
        taquin.solver(aStar);
        System.out.println();

    }
}
