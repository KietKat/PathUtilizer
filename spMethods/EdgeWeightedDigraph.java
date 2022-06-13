import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class EdgeWeightedDigraph
{
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<DirectedEdge>[] adj; // adjacency lists
    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) 
            adj[v] = new Bag<DirectedEdge>();
    }
    public EdgeWeightedDigraph(File file, int V) throws FileNotFoundException
    {
        this.V= V;
        this.E= 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v= 0; v< V; v++) { adj[v]= new Bag<DirectedEdge>(); }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight= scanner.nextDouble();
            addEdge(new DirectedEdge(v,w,weight));
        }
        scanner.close();
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(DirectedEdge e)
    {
        adj[e.from()].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v) { return adj[v]; }
    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj[v])
                bag.add(e);
        return bag;
    }

    //method to print the digraph out
    public void print()
    {
        System.out.println("Print Original Digraph:");
        Iterator<DirectedEdge> e = edges().iterator();
        while (e.hasNext())
        {
            DirectedEdge DirectedEdge = e.next();
            System.out.println(DirectedEdge.toString());
        }
    }
}
