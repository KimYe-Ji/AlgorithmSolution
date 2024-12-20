import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] endTime = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int tmpMax = 0;
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int workCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < workCount; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (endTime[tmp] > tmpMax) { tmpMax = endTime[tmp]; }
            }
            endTime[i] = time + tmpMax;
            if (endTime[i] > max) { max = endTime[i]; }
//            System.out.println(i + "번째 작업 종료 시간 : " + endTime[i]);
        }

        System.out.println(max);
    }
}
