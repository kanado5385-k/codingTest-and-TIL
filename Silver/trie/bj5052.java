package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj5052 {
    public static class Node {

        Map<Character, Node> childrens;
        boolean isLast;

        public Node(){
            childrens = new HashMap<>();
            isLast = false;
        }
    }
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
        int N = Integer.parseInt(br.readLine());
        boolean isYes = true;
        Node root = new Node();
        for (int i = 0; i < N; i++) {
            Node node = root;
            String numbers = br.readLine();

            for (char num: numbers.toCharArray()) {
             if (node.isLast) {
                isYes = false;
                node = null;
                break;
            }

            if (!node.childrens.containsKey(num)) {
                Node childNode = new Node();
                node.childrens.put(num, childNode);
                node = childNode;
            } else {
                node = node.childrens.get(num);
            }
        }

        if (!isYes || node == null) continue;

        if (!node.childrens.isEmpty()) {
            isYes = false;
            break;
        }

        node.isLast = true;
    }
        if(isYes) {
            sb.append("YES").append("\n");
        }
        else {
            sb.append("NO").append("\n");
        }
    }

    System.out.println(sb.toString());
    }
}

// 시간복잡도: O(T*N*L)