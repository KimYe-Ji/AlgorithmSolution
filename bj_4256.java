import java.io.*;
import java.util.*;

public class bj_4256 {
    static StringBuilder sb = new StringBuilder();
    static int[] preorder, inorder, inorderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            preorder = new int[n];
            inorder = new int[n];
            inorderIndex = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                preorder[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inorder[j] = Integer.parseInt(st.nextToken());
                inorderIndex[inorder[j]] = j;
            }

            postOrder(0, n - 1, 0, n - 1);
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void postOrder(int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return;

        int root = preorder[preStart];
        int rootIdx = inorderIndex[root];
        int leftSize = rootIdx - inStart;

        postOrder(inStart, rootIdx - 1, preStart + 1, preStart + leftSize);
        postOrder(rootIdx + 1, inEnd, preStart + leftSize + 1, preEnd);

        sb.append(root).append(" ");
    }
}
