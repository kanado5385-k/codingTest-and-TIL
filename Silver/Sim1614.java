import java.util.Scanner;

public class Sim1614 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean finish = true;
        int count = 0;
        while (finish) {
            for (int i = 1; i <= 5; i++) {
                if(i == N) {
                    if (count == M) {
                        finish = false;
                        break;
                    }
                    count++;
                }
                result++;
    
            }
            if (finish == true) {
                for (int i = 4; i >= 2; i--) {
                    if(i == N) {
                        if (count == M) {
                            finish = false;
                            break;
                        }
                        count++;
                    }
                    result++;
                } 
            }
        }

        System.out.println(result);
        sc.close();
    }
}
