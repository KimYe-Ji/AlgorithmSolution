// baekjoon 트리 순회_골드4
// 메모리 	 kb	성능  ms
// DFS, BFS

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bk_22856 {
    static int N;
    static int move = 0;
    static int[][] tree;
    static boolean[] visited;
    static int visitCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new int[N+1][3]; // 0은 left, 1은 right, 2는 parent
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u != -1) tree[u][2] = index;
            if (v != -1) tree[v][2] = index;
        }

        inOrderTraversal(1);

        System.out.println(move);
    }

    public static void inOrderTraversal(int node) {
        if (visitCnt == N) return;
        visited[node] = true;

        if (tree[node][0] != -1 && !visited[tree[node][0]]) {
            move++;
            visitCnt++;  // 방문한 노드 개수를 세기 위함
            inOrderTraversal(tree[node][0]);
        }
        else if (tree[node][1] != -1 && !visited[tree[node][1]]) {
            move++;
            visitCnt++;
            inOrderTraversal(tree[node][1]);
        }
        else {
            if (!visited[tree[node][2]]) {
                move++;
                visitCnt++;
            }
            inOrderTraversal(tree[node][2]);
        }
        // visitCnt == 0 이면 끝
        // 아니면 이동++;
        // 왼쪽 확인
            // -1 아니고 방문X면 이동. visited[]=True
        // 오른쪽 확인
            // -1 아니고 방문X면 이동. visited[]=True
        // 부모 노드로 이동
            // 부모노드로 이동. 방문X일 경우에만 visited[]=True와 방문 카운팅.
    }
}
