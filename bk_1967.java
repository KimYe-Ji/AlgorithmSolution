import java.io.*;
import java.util.*;

public class bk_1967 {
    // 간선 정보를 저장할 클래스
    static class Node {
        int vertex; // 연결된 노드
        int weight; // 간선의 가중치

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static List<Node>[] tree;  // 인접 리스트로 트리 표현
    static boolean[] visited; // 방문 여부 확인 배열
    static int maxDistance;   // 트리 지름 저장 변수
    static int farthestNode;  // 가장 먼 노드 저장 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수
        if (n == 1) {
            System.out.println(0);
            return;
        }
        tree = new ArrayList[n + 1];

        // 트리 초기화
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        farthestNode = -1;
        // 첫 번째 DFS로 임의의 노드에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(1, 0);

        // 두 번째 DFS로 트리의 지름 계산
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    // DFS 탐색 함수
    static void dfs(int currentNode, int distance) {
        visited[currentNode] = true;

        // 현재 탐색 중 가장 먼 거리 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = currentNode;
        }

        // 연결된 노드 탐색
        for (Node neighbor : tree[currentNode]) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, distance + neighbor.weight);
            }
        }
    }
}
