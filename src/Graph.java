import java.util.*;

/**
 * Created by prajesh on 27/01/15.
 */
public class Graph {

    public int[] vertex;


    public List[] adjList;

    private List stack = new LinkedList();

    public Graph(int n)
    {

        vertex = new int[n];

        adjList = new ArrayList[n];

        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList();

    }


    public boolean addEdge(int s, int d)
    {

        List edgesList = adjList[s];


        edgesList.add(d);

        return true;
    }



    public boolean findPaths(int s, int d, boolean[] visitedList)
    {




        if(s>=0 && vertex.length > s)
        {
            visitedList[s] = true;


            stack.add(s);

            if(s==d)
            {
                //print path
                printPath();
               // visitedList[s]=false;


                return true;
            }




            while(true)
            {
                int neighbour = getNextUnvisitedNeighbour(s, visitedList);

                if(neighbour!=-1)
                {
                    boolean result = findPaths(neighbour,d,visitedList);
                    if(!result)
                       visitedList = setNeighboursUnvisited(neighbour, visitedList);
                    else
                        stack.remove(stack.size()-1);
                }
                else
                    break;
            }



        }




            return false;

    }


   boolean[] setNeighboursUnvisited(int n, boolean[] visitedList)
   {

       List edgesList = adjList[n];

       for(int i=0;i<edgesList.size();i++)
       {
          visitedList[(Integer) edgesList.get(i)] =false;

       }

       return visitedList;
   }

   int getNextUnvisitedNeighbour(int s, boolean[] visitedList)
    {
        List edgesList = adjList[s];

        for(int i=0;i<edgesList.size();i++)
        {
           if(!visitedList[(Integer) edgesList.get(i)])
            return (Integer) edgesList.get(i);

        }

        return -1;

    }


    private void printPath()
    {
//        //print stack
//       Stack newStack = (Stack) stack.clone();
//
//       List list = new ArrayList();
//
//       while(stack.size()!=0)
//       {
//           list.add(stack.pop());
//       }
//
//       Collections.reverse(list);
//
//       Iterator iterator = list.iterator();
//
//       while(iterator.hasNext())
//       {
//           System.out.print((Integer)iterator.next()+" --> ");
//       }

       Iterator iterator = stack.iterator();

       while(iterator.hasNext())
       {
           System.out.print((Integer)iterator.next()+" --> ");
       }


    }




}
