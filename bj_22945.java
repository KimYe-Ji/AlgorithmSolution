import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stat = new int[N];
        for (int i = 0; i < N; i++) {
            stat[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int max = 0;
        for (int i = 0; i < N-1; i++) {
            int teamStat = Math.min(stat[left], stat[right])*(right - left - 1);
            max = Math.max(max, teamStat);
            if (stat[left] > stat[right]) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(max);
    }
}
