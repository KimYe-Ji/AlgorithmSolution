import java.io.*;
import java.util.*;

public class bj_21923 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] scores = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] up = new int[N][M];
        int[][] down = new int[N][M];
        // up
        up[N-1][0] = scores[N-1][0];
        for (int i=N-1; i>=0; i--) {
            if (i != N-1) up[i][0] = scores[i][0] + up[i+1][0];
            for (int j=1; j<M; j++) {
                if (i != N-1) up[i][j] = scores[i][j] + Math.max(up[i+1][j], up[i][j-1]);
                else up[i][j] = scores[i][j] + up[i][j-1];
            }
        }

        //down
        down[N-1][M-1] = scores[N-1][M-1];
        for (int i=N-1; i>=0; i--) {
            if (i != N-1) down[i][M-1] = scores[i][M-1] + down[i+1][M-1];
            for (int j=M-2; j>=0; j--) {
                if (i != N-1) down[i][j] = scores[i][j] + Math.max(down[i+1][j], down[i][j+1]);
                else down[i][j] = scores[i][j] + down[i][j+1];
            }
        }

        int max = -100000000;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                max = Math.max(up[i][j] + down[i][j], max);
            }
        }
        System.out.println(max);
    }
}
