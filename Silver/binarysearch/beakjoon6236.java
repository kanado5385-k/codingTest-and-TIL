package binarysearch;

import java.io.*;
import java.util.*;

public class beakjoon6236 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = Integer.MIN_VALUE;
        int max = 0;

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, nums[i]);
            max += nums[i];
        }

        int mid = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            int num = 1;
            int curSum = mid;

            for (int i = 0; i < N; i++) {
                if (nums[i] <= curSum) {
                    curSum -= nums[i];
                } else {
                    num++;
                    curSum = mid - nums[i];
                }
            }

            if (num <= M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(mid);
    }
}
