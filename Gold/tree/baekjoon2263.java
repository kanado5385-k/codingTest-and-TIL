package gold.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2263 {
    static int N;
    static int[] inorder, postorder;
    static int[] idx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        inorder = new int[N + 1];
        postorder = new int[N + 1];
        idx = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idx[inorder[i]] = i;
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preorder(1, N, 1, N);
        System.out.println(sb);
    }

    public static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");
        int rootIndex = idx[root];

        int leftSize = rootIndex - inStart;

        preorder(inStart, inStart + rootIndex - 1, postStart, postStart + leftSize - 1);
        preorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

}
