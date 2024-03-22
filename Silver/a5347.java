import java.util.Scanner;
public class a5347 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] Arr = new long[n];
        for( int i = 0; i < n; i++){
           long a = s.nextLong();
           long b = s.nextLong();

        
           long ans = Lcm(a,b);
            Arr[i] =  ans;
        }
        
        
        for(int i = 0; i < Arr.length; i++) {
            System.out.println(Arr[i]);
        }
       
    }

    public static long Lcm(long a, long b ){
        long big, small;
        if(a > b){
            big = a;
            small = b;
        }else{
            big = b;
            small = a;
        }

        long gcd = Gcd(big, small);
        long lcm = (big * small) / gcd;

        return lcm;
    }

    public static long Gcd(long big, long small){
        if (big % small == 0){
            return small;
        }
        return Gcd(small, big % small);
    }
}

