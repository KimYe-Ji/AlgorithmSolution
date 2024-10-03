// baekjoon 단절점과 단절선_실버1
// 메모리 		84568 kb	성능 1288 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bk_14675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i=0; i<q; i++) {
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            if (t == 1) {
                if (tree.get(k).size() < 2) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            } else if (t == 2) {
                System.out.println("yes");
            }
        }
    }
}
