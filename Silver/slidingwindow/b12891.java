package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b12891 {
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = {'A', 'C', 'G', 'T'};
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s = br.readLine().trim();

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 4; i++) {
            char cur = arr[i];
            map.put(cur, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            char curCh = s.charAt(i);
            map.put(curCh, map.get(curCh) - 1);
        }
        if(isPasswordComplite()) count++;

        int left = 0;
        for (int i = m; i < n; i++) {
            char deleteCh = s.charAt(left);
            char addCh = s.charAt(i);

            map.put(deleteCh, map.get(deleteCh) + 1);
            map.put(addCh, map.get(addCh) - 1);

            if(isPasswordComplite()) count++;

            left++;
        }

        System.out.println(count);
    }

    static public boolean isPasswordComplite() {
        for (char ch: map.keySet()) {
            int count = map.get(ch);
            if (count > 0) return false;
        }

        return true;
    }
}
