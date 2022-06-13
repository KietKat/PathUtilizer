import java.util.Stack;
import java.util.Iterator;

public class DijkstraSP 
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    
    public DijkstraSP (EdgeWeightedDigraph G)
    {
        //if no sources chosen, choose 0
        int[] source = {0};
        DijkstraSP(G, source);
    }

    //1 root choose
    public DijkstraSP (EdgeWeightedDigraph G, int source)
    {
        int[] roots= {source};
        DijkstraSP (G, roots); 
    }

    //constructor handling a list of roots
    public DijkstraSP (EdgeWeightedDigraph G, int[] sources)
    {
        DijkstraSP(G, sources);
    }

    public void DijkstraSP(EdgeWeightedDigraph G, int[] s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        for (int i = 0; i< s.length; i++)
        {
            distTo[s[i]]= 0.0;
            pq.insert(s[i], 0.0); //add all roots in the list to the pq and inintialize the weight as 0
        }
        while (!pq.isEmpty()) { relax(G, pq.delMin()); }
    }

    private void relax(EdgeWeightedDigraph G, int v)
    {
        for(DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }      
        } 
    }

    public double distTo(int v) { return distTo[v]; }
    public boolean hasPathTo(int v) { return distTo[v] < Double.POSITIVE_INFINITY; }
    public Iterable<DirectedEdge> pathTo(int v) 
    {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path; 
    }

    
}