import java.io.File;
import java.util.*;

public class DijkstraSPTest {
    public static void main(String[] args) throws Exception {
        int bestNode= -1;
        double bestDistance= Double.POSITIVE_INFINITY;

        File file= new File("text.txt");
        EdgeWeightedDigraph graph= new EdgeWeightedDigraph(file, 50); //pass 50 veritces and links

        //pass in the list of source nodes.
        int[] sourceNode= {7,14,25,28,40};
        DijkstraSP sp = new DijkstraSP(graph, sourceNode);

        //print the shortest path out
        for (int t = 0; t < graph.V(); t++)
        {
            StdOut.printf(t+ " (%4.2f): ", sp.distTo(t));
            //these lines are to print the order from the source node to the customers
            if (sp.hasPathTo(t))
            {
                String path= "";
                for (DirectedEdge e : sp.pathTo(t))
                {
                    path= e + " " + path + " ";
                    
                }
                StdOut.print(path);
            }        
            StdOut.println();
        }
        //On finding the best source node
        for (int i = 0; i< graph.V(); i++)
        {
            double totalDistance=0;
            DijkstraSP bestSP = new DijkstraSP(graph, i);
            for (int t = 0; t < graph.V(); t++)
            {
                totalDistance += bestSP.distTo(t);
            }    
            if (totalDistance <= bestDistance)
            {
                bestDistance= totalDistance;
                bestNode = i;
            }
        }

        System.out.println("The best source node is " + bestNode +" with the distance of " + bestDistance);
    }
}
