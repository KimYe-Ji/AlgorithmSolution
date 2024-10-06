// baekjoon 호석이 두 마리 치킨_골드5
// 메모리 16940 kb	성능 224 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import static java.lang.Math.*;

public class bk_21278 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 100007;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int[] row : map)
            Arrays.fill(row, INF);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = map[b][a] = 1;
        }

        floydWarshall(n, map);

        System.out.println(answer(n, map));
    }


    private static void floydWarshall(final int n, int[][] map) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    map[i][j] = map[j][i] = min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    private static String answer(final int n, final int[][] map) {
        int min = INF;
        int ansA = 0;
        int ansB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;

                    sum += min(map[i][k], map[j][k]);
                }

                if (min > sum) {
                    min = sum;
                    ansA = i;
                    ansB = j;
                }

            }
        }

        return String.format("%d %d %d", ansA+1, ansB+1, min*2);
    }
}