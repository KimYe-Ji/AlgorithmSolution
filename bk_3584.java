// baekjoon 3584
// 메모리 28916kb	성능 272ms
import java.io.*;

public class bk_3584 {

    public static void main(String[] args) throws IOException {
        new bk_3584().solution();
    }

    int N, parent[];

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = {};

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            N = Integer.parseInt(br.readLine());

            // 노드간의 부모 - 자식 관계를 저장하는 배열 ex) parent[자식] = 부모
            parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                input = br.readLine().split(" ");
                int p = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                parent[c] = p;
            }

            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            System.out.println(LCA(u, v));
            T -= 1;
        }

        br.close();
    }

    // 특정 노드로부터 루트 노드까지 거슬러 올라가 깊이를 반환
    private int calDepth(int node) {
        int depth = 0;

        while (parent[node] != 0) {
            node = parent[node];
            depth++;
        }

        return depth;
    }

    private int LCA(int u, int v) {
        int u_depth = calDepth(u);
        int v_depth = calDepth(v);

        // 깊이 통일
        while (u_depth > v_depth) {
            u = parent[u];
            u_depth--;
        }

        while (u_depth < v_depth) {
            v = parent[v];
            v_depth--;
        }

        // 첫 공통 부모 찾기
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }

        return u;
    }
}