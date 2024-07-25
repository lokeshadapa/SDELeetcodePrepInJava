package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Implementing graph-1.png
public class BasicAdjMatrix {
    public static void main(String[] args) {
        int v = 5;
        int sourceVertex = 0;
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>(v); // if you actual names for nodes, we will use hashmap to store integer to string reference
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<Integer>());
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 0);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 0);
        addEdge(graph, 2, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 1);
        addEdge(graph, 3, 2);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 1);
        addEdge(graph, 4, 2);
        addEdge(graph, 4, 3);

        for(int i = 0; i < v; i++){
            System.out.println(i + " - " + graph.get(i).toString());
        }
        System.out.println("Degree of vertex 2 is " + findDegree(graph, 0));
        System.out.println("BFS nodes from source vertex " + sourceVertex + " is\n");
        printBfs(graph, sourceVertex);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int v1, int v2) {
        graph.get(v1).add(v2);
    }

    private static int findDegree(ArrayList<ArrayList<Integer>> graph, int v1) {
        return graph.get(v1).size();
    }

    private static void printBfs(ArrayList<ArrayList<Integer>> graph, int sourceVertex){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> degree = new LinkedList<>();

        degree.add(0);
        q.add(sourceVertex);
        visited[sourceVertex] = true;


        while(!q.isEmpty()){
            int v = q.poll();
            int d = degree.poll();
            System.out.print(v + " / " + d + " - ");
            for(int i: graph.get(v)){
                if(!visited[i]){
                    q.add(i);
                    degree.add(d + 1);
                    visited[i] = true;
                }
            }
        }
    }
}
