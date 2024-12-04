import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] parents = new int[N+1];
        boolean[] visited = new boolean[N+1];
        dfs(1, tree, parents, visited);

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int current, ArrayList<Integer>[] tree, int[] parents, boolean[] visited) {
        visited[current] = true;
        for (int i : tree[current]) {
            if (!visited[i]) {
                parents[i] = current;
                dfs(i, tree, parents, visited);
            }
        }
    }
}
