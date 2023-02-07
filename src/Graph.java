import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Graph {
    ArrayList<String> Trace=new ArrayList<>();
    public ArrayList<String> stateGraph(Grid initialGrid,Grid finalGrid,int n){
        if (initialGrid!=null){
            String s=initialGrid.toString();
            System.out.println("n"+n+":");
            System.out.println("\t"+s.charAt(0)+s.charAt(1)+s.charAt(2));
            System.out.println("\t"+s.charAt(3)+s.charAt(4)+s.charAt(5));
            System.out.println("\t"+s.charAt(6)+s.charAt(7)+s.charAt(8));
            String s1=finalGrid.toString();
            Trace.add(s);
            if (Objects.equals(s, s1)){
                System.out.println("Solution found");
            }
            else{
                Grid rightGrid = new GridGenerator(initialGrid).moveRight();
                if (rightGrid!=null && !Trace.contains(rightGrid.toString())){
                System.out.println("Right:");
                n++;
                stateGraph(rightGrid,finalGrid,n);}
                Grid leftGrid= new GridGenerator(initialGrid).moveLeft();
                if (leftGrid!=null&& !Trace.contains(leftGrid.toString())){
                System.out.println("Left:");
                n++;
                stateGraph(leftGrid,finalGrid,n);}
                Grid UpperGrid = new GridGenerator(initialGrid).moveUp();
                if (UpperGrid!=null&& !Trace.contains(UpperGrid.toString())){
                System.out.println("Up:");
                n++;
                stateGraph(UpperGrid,finalGrid,n);}
                Grid DownGrid= new GridGenerator(initialGrid).moveDown();
                if (DownGrid!=null&& !Trace.contains(DownGrid.toString())){
                System.out.println("Down:");
                n++;
                stateGraph(DownGrid,finalGrid,n);}
        }}
        return Trace;
    }
}
