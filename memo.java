import java.util.*;
import java.io.*;

public class memo {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        graph = new ArrayList[100];
        for (int i = 0; i < 100; i++) graph[i] = new ArrayList<>();
        for (int i=0; i<100; i++) { Collections.sort(graph[i]); }
    }

    public static void DFS(int node) {
        visited[node] = true;
        System.out.print(node+ " ");

        for (int next: graph[node]){
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node+ " ");

            for (int next: graph[node]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
