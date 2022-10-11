import java.util.ArrayList;

public class Graph_Representation
{
    /* --- Representation of Adjacency List --- */

    /*
     * Input : vertex (n) , no. of edges (m) , 2D Array of Edges (edges[][]))
     */

    /*
     * Undirected Graph
     * 
     * n -> number of edges
     * m -> number of edges
     * edges[][] = 2-D Array having individual edges details,
     * For eg : {2,1} -> 2 is connected to 1 or 1 is connected to 2
     *          {1,3} -> 1 is connected to 3 or 3 is connected to 1
     * 
     */
    public static void buildAdjacencyListUndirectedGraph(int n,int m,int edges[][])
    {
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<ArrayList<Integer>>();
        
        /*
         * Check whether the nodes are 0-indexed or 1-indexed
         * Creating the empty individual adjacency list for each and every node.
         */

        for(int i=0 ; i<=n ; i++)
            adjacency_list.add(new ArrayList<Integer>());

        /*
         * 0 -> {}
         * 1 -> {}
         * 2 -> {}
         * 3 -> {}
         * 4 -> {}
         * 5 -> {}
         */

        /*
         * {1,2} | {2,1}
         * {1,3} | {3,1}
         * {3,4} | {4,3}
         * {2,4} | {4,2}
         * {2,5} | {5,2}
         * {4,5} | {5,4}
         */

        for(int i=0 ; i<m ; i++)
        {
            int edge[] = edges[i];
            adjacency_list.get(edge[1]).add(edge[0]);
            adjacency_list.get(edge[0]).add(edge[1]);
        }

        /*
         * 0 -> {}
         * 1 -> {2, 3, 4, }
         * 2 -> {1, 5}
         * 3 -> {1, 4, }
         * 4 -> {2, 4, 5}
         * 5 -> {2, 4}
         */

        for(int i=0 ; i<=n ; i++)
        {
            System.out.print("Vertex "+i+" -> ");
            for(int nodes : adjacency_list.get(i))
                System.out.print(" "+nodes+" ");
            System.out.println();
        }


    }

    /*
     * Directed Graph
     * 
     * n -> number of edges
     * m -> number of edges
     * edges[][] = 2-D Array having individual edges details,
     * For eg : {2,1} -> 2 is connected to 1.
     *          {1,3} -> 1 is connected to 3.
     * 
     */

    public static void buildAdjacencyListDirectedGraph(int n,int m,int edges[][])
    {
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<ArrayList<Integer>>();

        for(int i=0 ; i<=n ; i++)
            adjacency_list.add(new ArrayList<Integer>());
        
        /*
         * 0 -> {}
         * 1 -> {}
         * 2 -> {}
         * 3 -> {}
         * 4 -> {}
         * 5 -> {}
         */

         /*
          * {1,2}
          * {2,5}
          * {1,3}
          * {3,4}
          * {4,2}
          * {4,5}
          */
          
        for(int i=0 ; i<m ; i++)
        {
            int edge[] = edges[i];
            adjacency_list.get(edge[0]).add(edge[1]);
        }

        /*
         * 0 -> {}
         * 1 -> {2, 3}
         * 2 -> {5}
         * 3 -> {4}
         * 4 -> {2, 5}
         * 5 -> {}
         */

        for(int i=0 ; i<=n ; i++)
        {
            System.out.print("Vertex "+i+" -> ");
            for(int nodes : adjacency_list.get(i))
                System.out.print(" "+nodes+" ");
            System.out.println();
        }
    }

    /* --- Representation of Adjacency Matrix --- */

    /*
     * Input : vertex (n) , no. of edges (m) , 2D Array of Edges (edges[][]))
     */

    /*
     * Undirected Graph
     * 
     * n -> number of edges
     * m -> number of edges
     * edges[][] = 2-D Array having individual edges details,
     * For eg : {2,1} -> 2 is connected to 1 or 1 is connected to 2
     *          {1,3} -> 1 is connected to 3 or 3 is connected to 1
     * 
     */

    public static void buildAdjacencyMatrixUndirectedGraph(int n, int m, int edges[][])
    {
        int [][] adjacency_matrix = new int[n+1][n+1];

        for(int i=0 ; i<m ; i++)
        {
            int edge[] = edges[i];
            adjacency_matrix[edge[0]][edge[1]] = 1;
            adjacency_matrix[edge[1]][edge[0]] = 1;
        }

        for(int i=0 ; i<=n ; i++)
        {
            System.out.print("Vertex : "+i+" -> ");
            for(int j=0 ; j<=n ; j++)
                if(adjacency_matrix[i][j] == 1 && i != j)
                    System.out.print(" "+j+" ");
            System.out.println();
        }
    }

    /*
     * Directed Graph
     * 
     * n -> number of edges
     * m -> number of edges
     * edges[][] = 2-D Array having individual edges details,
     * For eg : {2,1} -> 2 is connected to 1.
     *          {1,3} -> 1 is connected to 3.
     * 
     */

    public static void buildAdjacencyMatrixDirectedGraph(int n, int m, int edges[][])
    {
        int [][] adjacency_matrix = new int[n+1][n+1];

        for(int i=0 ; i<m ; i++)
        {
            int edge[] = edges[i];
            adjacency_matrix[edge[0]][edge[1]] = 1;
        }

        /*
         * 0 -> {}
         * 1 -> {2, 3}
         * 2 -> {5}
         * 3 -> {4}
         * 4 -> {2, 5}
         * 5 -> {}
         */

        /*
         * 0 -> {}
         * 1 -> {2, 3, 4, }
         * 2 -> {1, 5}
         * 3 -> {1, 4, }
         * 4 -> {2, 4, 5}
         * 5 -> {2, 4}
         */

        for(int i=0 ; i<=n ; i++)
        {
            System.out.print("Vertex : "+i+" -> ");
            for(int j=0 ; j<=n ; j++)
                if(adjacency_matrix[i][j] == 1 && i != j)
                    System.out.print(" "+j+" ");
            System.out.println();
        }
    }







    public static void main(String Args[])
    {
        /*
         *  Undirected Graph Representation using Adjacency List 
         *  when edges between the nodes are given in the form of 2-D Matrix
         */

        /*
        int n = 5;  // no. of vertex or nodes
        int m = 6;  // no. of edges 

        int edges[][] = {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};

        buildAdjacencyListUndirectedGraph(n, m, edges);
        */

        /*
         *  Directed Graph Representation using Adjacency List 
         *  when edges between the nodes are given in the form of 2-D Matrix
        */

        /*
        int n = 5;
        int m = 6;
        int edges[][] = {{1,2},{2,5},{1,3},{3,4},{4,2},{4,5}};

        buildAdjacencyListDirectedGraph(n, m, edges);
        */

        /*
         *  Undirected Graph Representation using Adjacency Matrix 
         *  when edges between the nodes are given in the form of 2-D Matrix
        */

        /*
        int n = 5;
        int m = 6;
        int edges[][] = {{1,2},{2,5},{1,3},{3,4},{4,2},{4,5}};

        buildAdjacencyMatrixUndirectedGraph(n, m, edges);
         */

        /*
         *  Directed Graph Representation using Adjacency Matrix 
         *  when edges between the nodes are given in the form of 2-D Matrix
        */        

        int n = 5;
        int m = 6;
        int edges[][] = {{1,2},{2,5},{1,3},{3,4},{4,2},{4,5}};

        buildAdjacencyMatrixDirectedGraph(n, m, edges);
    }
}