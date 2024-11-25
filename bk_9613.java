// baekjoon GCD 합_실버4
// 메모리 	14176 kb	성능 100 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] num = new int[n];
            for(int j=0; j<n; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }

            // n이 최대 100, num[i]가 각각 최대 1,000,000일 경우
            // sum은 49.5억이기 때문에 int 불가능
            long sum = 0;
            for(int j=0; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if (num[j] > num[k]) sum += gcd(num[j], num[k]);
                    else sum += gcd(num[k], num[j]);
                }
            }

            System.out.println(sum);
        }
    }

    // 유클리드 호제법
    private static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}