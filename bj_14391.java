import java.io.*;
import java.util.*;

public class bj_14391 {
    public static int N, M;
    public static int[][] paper;
    public static boolean[][] isHorizontal;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        isHorizontal = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        if (x == N) {
            int result = calculateSum();
            max = Math.max(max, result);
            return;
        }

        if (y == M) {  // 행의 끝에 도달하면 다음 행으로 이동
            dfs(x + 1, 0);
            return;
        }

        isHorizontal[x][y] = true;
        dfs(x, y + 1);

        isHorizontal[x][y] = false;
        dfs(x, y + 1);
    }

    public static int calculateSum() {
        int result = 0;

        // 가로 방향 계산
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                if (isHorizontal[i][j]) {
                    temp = temp * 10 + paper[i][j];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        // 세로 방향 계산
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (!isHorizontal[j][i]) {
                    temp = temp * 10 + paper[j][i];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        return result;
    }
}
