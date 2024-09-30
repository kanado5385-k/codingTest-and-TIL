import java.util.Scanner;

public class Main {
    public static class Result {
        int index;
        String modifiedStr;

        public Result(int index, String modifiedStr) {
            this.index = index;
            this.modifiedStr = modifiedStr;
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String result = "";
        
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '<'){
                Result result1 = function1(i, str);
                result = result + "<" + result1.modifiedStr + ">";
                i = result1.index;
            } else if (str.charAt(i) == ' '){
                result = result + " ";
            } else {
                Result result2 = function2(i, str);
                result = result + result2.modifiedStr;
                i = result2.index;
            }
        }

        System.out.println(result);  // 결과를 정상 출력
    }

    public static Result function1(int i, String str){
        String str1 = "";
        while (true) {
            i++;
            if (i >= str.length()) {  // 범위 초과 방지
                break;
            }
            if (str.charAt(i) == '>'){
                break;
            }
            str1 = str1 + str.charAt(i);
        }
        return new Result(i, str1);  // '>'의 인덱스 반환
    }

    public static Result function2(int i, String str) {
        String str1 = "";
        String reversedStr = "";
        while (true) {  // 범위 체크를 추가하여 예외 방지
            if (i >= str.length()){
                reversedStr = new StringBuilder(str1).reverse().toString();
                str1 = reversedStr;
                break;    
            }
            else if (str.charAt(i) == '<') {
                i--;
                reversedStr = new StringBuilder(str1).reverse().toString();
                str1 = reversedStr;
                break;    
            }
            else if (str.charAt(i)==' ') {
                reversedStr = new StringBuilder(str1).reverse().toString();
                str1 = reversedStr;
                str1 = str1 + " ";
                break;  
            } else {
                str1 = str1 + str.charAt(i);
            }
            i++;
        }
        return new Result(i, str1);
    }
}
