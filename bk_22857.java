// baekjoon 가장 긴 짝수 연속한 부분 수열 (small)_실버2
// 메모리 21548 kb	성능 236 ms
// 윈도우 슬라이싱

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 21548 kb 236 ms
public class bk_22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int cntEven = 0;
        int cntOdd = 0;
        int max = 0;

        for (int R = 0; R < N; R++) {
            if (sequence[R]%2 == 0) cntEven++;
            else cntOdd++;

            while (cntOdd > K) {
                if (sequence[L]%2 == 0) cntEven--;
                else cntOdd--;
                L++;
            }
            max = Math.max(max, cntEven);
        }
        System.out.println(max);
    }
}

// 2. 21616 kb	748 ms

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[] sequence = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            sequence[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int cntEven = 0;
//        int cntOdd = 0;
//        int max = 0;
//        for (int L = 0; L < N; L++) {
//            cntOdd = 0;
//            if (sequence[L]%2 == 0) {
//                cntEven = 1;
//                for (int R = L + 1; R < N; R++) {
//                    if (sequence[R]%2 == 0) cntEven++;
//                    else if (++cntOdd > K) {
//                        break;
//                    }
//                }
//                max = Math.max(max, cntEven);
//            }
//        }
//
//        System.out.println(max);
//    }
//}
