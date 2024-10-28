package src.main.java.dsaSchool;

import java.util.ArrayList;

//Useful to start a vertex or a specific path
public class GraphTraverser {

    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        System.out.println(start.getData());

        for(Edge edge : start.getEdges()){
            Vertex neighbor = edge.getEnd();

            if(!visitedVertices.contains(neighbor)){
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

  public static void breadthFirstSearch(Vertex start, ArrayList<Vertex> visitedVertices){
      Queue visitQueue = new Queue();
      visitQueue.enqueue(start);
      while(!visitQueue.isEmpty()){
         Vertex current = visitQueue.dequeue();
         System.out.println(current.getData());

         for(Edge edge : current.getEdges()){
             Vertex neighbor = edge.getEnd();

             if(!visitedVertices.contains(neighbor)){
                 visitedVertices.add(neighbor);
                 visitQueue.enqueue(neighbor);
             }
         }
      }
  }


    public static void main(String[] args){
        TestGraph testGraph = new TestGraph();
        Vertex startingVertex = testGraph.getStartingVertex();
        ArrayList<Vertex> visitedVertices1 = new ArrayList<Vertex>();
        ArrayList<Vertex> visitedVertices2 = new ArrayList<Vertex>();
        visitedVertices1.add(startingVertex);
        visitedVertices2.add(startingVertex);
        System.out.println("DFS");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices1);
        System.out.println("BFS");
        GraphTraverser.breadthFirstSearch(startingVertex, visitedVertices2);

    }
}
