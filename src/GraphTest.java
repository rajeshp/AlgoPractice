/**
 * Created by prajesh on 27/01/15.
 */
public class GraphTest {

    public static void main(String[] args)
    {

        Graph graph = new Graph(4);

//        graph.addEdge(1,2);
//        graph.addEdge(1,3);
//        graph.addEdge(1,4);
//
//        graph.addEdge(2,4);
//        graph.addEdge(3,1);
//        graph.addEdge(3,2);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);

        graph.addEdge(1,3);
        graph.addEdge(2,0);
        graph.addEdge(2,1);

        graph.findPaths(2,3, new boolean[4]);


    }

}
