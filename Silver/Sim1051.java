import java.util.Scanner;

public class Sim1051 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MIN_VALUE;
        int result = 1;

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 한 줄 입력받기
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j) - '0'; // 각 숫자를 배열에 저장
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k = j + 1; k < M; k++) {
                    if(matrix[i][j] == matrix[i][k]) {
                        int length = k - j;
                        if (i + length < N) {
                            int ni = i + length;
                            if (matrix[ni][j] == matrix[i][k]) {
                                if (matrix[ni][k] == matrix[i][k]) {
                                    int sum = (length + 1) * (length + 1);
                                    result = Math.max(min, sum);
                                    min = result;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
        sc.close();

    }
}
