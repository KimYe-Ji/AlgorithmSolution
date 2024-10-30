// baekjoon 큰 수 구성하기_실버5
// 메모리 14344 kb	성능 124 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk_18511 {

    private static int N, K;
    private static int[] set;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set = new int[K];
        
        for (int i = 0; i < K; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set);
        search(0);

        System.out.println(num);
    }

    private static void search(int now) {
        if(now>N) return;

        if(num<now) num=now;

        for (int i = K-1; i > -1; i--) {
            search(now*10+set[i]);
        }
    }
}
