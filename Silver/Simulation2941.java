import java.util.Scanner;

public class Simulation2941 {

    //특정 문자가 문자배열에 있는지 확인하는 함수
    public static boolean isCharInArray(String c, String[] array) {
        for (String element : array) {
            if (element.equals(c)){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result = 0;

        //각 문자가 두개의 알파뱃으로 구성되어있기 때문에 char 아닌 string 배열 사용
        String[] kroa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String word = sc.nextLine();
        char[] charWord = word.toCharArray();

        for(int a=0; a < charWord.length; a++){
            if(a < word.length() - 1){
                char num = charWord[a];
                char num2 = charWord[a+1];

                String num3 = Character.toString(num)+ Character.toString(num2);
                if (num3.equals("dz")){
                    if(a + 2 < charWord.length && charWord[a + 2] == '='){
                        num3 = "dz=";
                        result ++;
                        a ++;
                        a ++;
                        continue;
                    }
                }
                boolean i = isCharInArray(num3, kroa);
                if(i == true){
                    result ++;
                    a ++;
                }
                else{
                    result ++;
                }
            }
            else{
                result ++;
            }
        }

        System.out.println(result);
        sc.close();
    }

}
