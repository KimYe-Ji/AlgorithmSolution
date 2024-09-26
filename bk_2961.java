// baekjoon 도영이가 만든 맛있는 음식_실버2
//// 메모리 	14152 kb	성능 100 ms
// 백트래킹 / 브루트포스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_2961 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] ingredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ingredients = new int[N][2];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 1, 0, 0);
        System.out.println(min);
    }

    public static void backTracking(int index, int sour, int bitter, int count) {
        if (index == N) {
            if (count > 0) {
                int diff = Math.abs(sour - bitter);
                min = Math.min(min, diff);
            }
            return;
        }

        // 현재 재료 포함할 경우
        backTracking(index + 1, sour * ingredients[index][0], bitter + ingredients[index][1], count + 1);

        // 현재 재료 포함하지 않을 경우
        backTracking(index + 1, sour, bitter, count);
    }
}
