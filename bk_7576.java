// baekjoon 토마토_골드1
// 메모리 14224 kb	성능 132 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

public class bk_7576 {

    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int ans = Integer.MIN_VALUE;
    static Deque<int[]> q = new LinkedList<>();

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0 ; i < M ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            for(int j = 0 ; str.hasMoreTokens() ; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if(arr[i][j] == 1)
                    q.add(new int[] {i,j});
            }
        }

        bfs();

        loop : for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(arr[i][j] == 0) {
                    ans = 0;
                    break loop;
                }else
                    ans = Math.max(ans, arr[i][j]);
            }
        }

        System.out.println(ans-1);
    }

    public static void bfs() {

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY] || arr[nextX][nextY] < 0) {
                    continue;
                }

                q.add(new int[] {nextX, nextY});
                if(arr[nextX][nextY] == 0)
                    arr[nextX][nextY] = arr[nowX][nowY] + 1;
                else
                    arr[nextX][nextY] = Math.min(arr[nowX][nowY] + 1, arr[nextX][nextY]);

                visited[nextX][nextY] = true;
            }
        }
    }
}