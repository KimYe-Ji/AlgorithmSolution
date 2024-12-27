import java.io.*;
import java.util.*;

public class bj_15661 {

    static int N, min;
    static int[][] stat;
    static boolean[] visit; // 부분집합을 구하기 위한 방문처리 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        visit = new boolean[N];
        solve(0);

        System.out.println(min);
    }

    static void solve(int cnt) {
        // 부분집합 뽑았을 때,
        if(cnt == N) {
            int start = 0;
            int link = 0;

            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    if(visit[i] != visit[j]) continue;
                    if(visit[i])
                        start += stat[i][j] + stat[j][i];
                    else
                        link += stat[i][j] + stat[j][i];
                }
            }

            int diff = Math.abs(start - link);
            if(diff < min) min = diff;

            return;
        }

        visit[cnt] = true;
        solve(cnt + 1);
        visit[cnt] = false;
        solve(cnt + 1);
    }
}
