import java.io.IOException;
import java.util.Scanner;

public class s17446 {
    public static void main (String[] args) throws IOException{
    Scanner s = new Scanner(System.in); 

    long N = s.nextInt();
    long P = s.nextInt();

    long result = 1;
    for (long i = 1; i <= N; i++) {
        result = (result * i)%P;
    }

    result = result % P;
    System.out.println(result);
    s.close();

    }
}
