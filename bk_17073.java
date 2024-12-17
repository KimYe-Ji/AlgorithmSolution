import java.io.*;
import java.util.*;

public class bk_17073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        ArrayList<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        int leafCount = countLeafNodes(tree, N);
        System.out.println(W/(double)leafCount);
    }

    private static int countLeafNodes(ArrayList<Integer>[] tree, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int leafCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            boolean isLeaf = true;

            for (int i : tree[current]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    isLeaf = false;
                }
            }

            if (isLeaf) {
                leafCount++;
            }
        }

        return leafCount;
    }
}
