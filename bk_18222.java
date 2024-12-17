import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bk_18222 {
    /*
    dp[2/n+k] = 1 - dp[0+k]
    a = 2/n+k
    0+k = 2/n+k-2/n = a-2/n
    dp[k] = 1 - dp[k-2/n]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        System.out.println(solution(k));
    }

    private static int solution(long k) {
        if (k == 1) return 0;
        long i;
        for (i = 1; i << 1 < k; i <<= 1);
        return 1 - solution(k-i);
    }
}
