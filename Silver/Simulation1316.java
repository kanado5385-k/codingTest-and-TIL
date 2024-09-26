import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation1316{
    //그룹 단어인지 확인 함수
    public static boolean word_group(String word){
        char[] charWord = word.toCharArray();

        List<Character> check = new ArrayList<>();

        for (int a = 0; a < word.length(); a++){
            // 마지막 인덱스가 아닐 때만 다음 문자와 비교
            if (a < word.length() - 1 && charWord[a] == charWord[a + 1]){
                continue;
            }
            else{
                if(isCharInArray(charWord[a], check)){
                    return false;
                }
                else{
                    check.add(charWord[a]);
                }
            }
        }
        return true;
    }

    //특정 문자가 문자배열에 있는지 확인하는 함수
    public static boolean isCharInArray(char c, List<Character> array) {
        for (char element : array) {
            if (element == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        //단어의 개수 입력
        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];

        for (int i = 0; i < N; i++){
            words[i] = sc.nextLine();
        }

        for (int i = 0; i < N; i++){
            boolean a = word_group(words[i]);
            if (a == true){
                result ++;
            }
        }
        System.out.println(result);
    }
}