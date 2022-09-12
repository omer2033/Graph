package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graphs {
    //We can represent roads with graphs facebook using it for social network , amazon recomandation engine
    //Trees types of graph
    //Directed and Undirected graph
    //Facebook has undirected graph when you're connnected to friend your friend connected to you
    //You can have a information on edges
    //Cyclic when you can go one to another and come back to node you starded
    //Ayclic you cannot go back to node you started
   // Edge list graph = [[0,2] , [2,3],[2,1],[1,3]]
    //Adjacent list
    //graph =[[2],[2,3],[0,1,3],[1,2]]
    //Adjacent matrix
//    graph = [
//            [0,0,1,0],
//            [0,0,1,1],
//            [1,1,0,1],
//            [0,1,1,0]
//            ]
    private HashMap<Integer, List<Integer>> adjacentList;
    private int numberOfNodes;
    public Graphs(){
        this.adjacentList = new HashMap<>();
        this.numberOfNodes = 0;
    }
    public void addNode(int value){
        adjacentList.put(value, new ArrayList<>());
        numberOfNodes++;
    }
    public void addEdge(int value1, int value2){
        adjacentList.get(value1).add(value2);
        adjacentList.get(value2).add(value1);
    }
    public void showConnections(){
        Set<Integer> keys = adjacentList.keySet();
        for (int node : keys){
            List<Integer> nodeConnections = adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            for(int edge: nodeConnections){
                connections.append(edge).append(" ");
            }
            System.out.println(node+ "--> "+connections);
        }
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public static void main(String[] args) {
        Graphs graph  = new Graphs();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        graph.showConnections();
    }
}
