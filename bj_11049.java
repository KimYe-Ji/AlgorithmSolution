import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] size = new int[N+1];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            size[i] = r;
            size[i+1] = c;
        }

        int[][] dp = new int[N][N]; // dp[i][j] = i번째부터 j번까지의 최소 연산 값
        for(int i=2; i<N+1; i++) {
            for(int j=0; j<N-i+1; j++) {
                dp[j][j+i-1] = Integer.MAX_VALUE;
                for(int k=j; k<j+i-1; k++) {
                    int value = dp[j][k] + dp[k+1][j+i-1] + (size[j]*size[k+1]*size[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}