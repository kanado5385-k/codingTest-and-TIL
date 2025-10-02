package gold.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon5639 {
    public static void main(String[] args) throws IOException {
        List<Integer> pre = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            int num = Integer.parseInt(line);
            pre.add(num);
        }

        Tree root = new Tree(pre.get(0));

        for (int i = 1; i < pre.size(); i++) {
            root.insert(pre.get(i));
        }

        findAfter(root);

    }

    static void findAfter(Tree tree) {
        if (tree.left != null) findAfter(tree.left);
        if (tree.right != null) findAfter(tree.right);
        System.out.println(tree.node);
    }

    static public class Tree {
        public Tree left;
        public Tree right;
        public int node;

        public Tree(int node) {
            this.node = node;
        };

        public void insert(int node) {
            if (node > this.node) {
                if (right == null) {
                    right = new Tree(node);
                } else {
                    right.insert(node);
                }
            } else if (node < this.node) {
                if (left == null) {
                    left = new Tree(node);
                } else {
                    left.insert(node);
                }
            }
        }
    }
}
