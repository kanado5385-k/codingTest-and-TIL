import java.util.LinkedList;
import java.util.Scanner;

public class Queue1966 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            LinkedList<int[]> queue = new LinkedList<>();
            int N = sc.nextInt();
            int target = sc.nextInt();



            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{sc.nextInt(), i});
            }

            int num = 0;
            while (true) {
                int curLine[] = queue.poll();
                int curNum = curLine[0];
                int curLocation = curLine[1];
                boolean isThereMore = false;
                
                for(int i = 0; i < queue.size(); i++) {
                    if(curNum < queue.get(i)[0]) {
                        isThereMore = true;
                    }
                }

                if(isThereMore) {
                    queue.offer(curLine);
                }
                else {
                    num++;
                    if (curLocation == target) {
                        sb.append(num + "\n");
                        break;
                    }

                }
            }

        }
        System.out.println(sb.toString());
        sc.close();
    }
}
