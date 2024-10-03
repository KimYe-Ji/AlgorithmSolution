// baekjoon 트리 순회_실버1
// 메모리 14112 kb	성능 112 ms
// 전위순회, 중위순회, 후위순회

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_2_1991 {

    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new int[26][2];
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int childL = st.nextToken().charAt(0) - 'A';
            int childR = st.nextToken().charAt(0) - 'A';

            tree[parent][0] = (childL == -19) ? -1 : childL;
            tree[parent][1] = (childR == -19) ? -1 : childR;
        }

        preOrderTraversal(0);
        System.out.println();
        inOrderTraversal(0);
        System.out.println();
        postOrderTraversal(0);
        System.out.println();
    }

    private static void preOrderTraversal(int val) {
        if (val == -1) return;

        System.out.print((char)(val+'A'));
        preOrderTraversal(tree[val][0]);
        preOrderTraversal(tree[val][1]);
    }

    private static void inOrderTraversal(int val) {
        if (val == -1) return;

        inOrderTraversal(tree[val][0]);
        System.out.print((char)(val+'A'));
        inOrderTraversal(tree[val][1]);
    }

    private static void postOrderTraversal(int val) {
        if (val == -1) return;

        postOrderTraversal(tree[val][0]);
        postOrderTraversal(tree[val][1]);
        System.out.print((char)(val+'A'));
    }

//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode(int val) {
//            this.val = val;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    private static void preOrderTraversal(TreeNode root) {
//        if (root == null) return;
//
//        System.out.print(root.val);
//        preOrderTraversal(root.left);
//        preOrderTraversal(root.right);
//    }
//
//    private static void inOrderTraversal(TreeNode root) {
//        if (root == null) return;
//
//        inOrderTraversal(root.left);
//        System.out.print(root.val);
//        inOrderTraversal(root.right);
//    }
//
//    private static void postOrderTraversal(TreeNode root) {
//        if (root == null) return;
//
//        postOrderTraversal(root.left);
//        postOrderTraversal(root.right);
//        System.out.print(root.val);
//    }
}