import java.io.*;
import java.util.*;

public class bj_1766 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1]; // 진입차수(= 각 문제를 풀기 위해 선행되어야 하는 문제의 개수)

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // graph[A] : 문제 A를 풀면 쉽게 풀 수 있는 문제 목록
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i); // 진입 차수가 0인 문제부터 시작
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            for (int next : graph[current]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    pq.offer(next); // 진입 차수가 0이 된 문제 추가
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}