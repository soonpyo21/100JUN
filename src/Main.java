// 문제
// 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
//
// 제한사항
// s의 길이는 1 이상 5이하입니다.
// s의 맨앞에는 부호(+, -)가 올 수 있습니다.
// s는 부호와 숫자로만 이루어져있습니다.
// s는 "0"으로 시작하지 않습니다.

public class Main {

    public static void main(String[] args) {

        String s = "-1234";

        solution(s);
    }

    public static int solution(String s) {

        int answer = 0;
        String[] arr = s.split("");
        boolean sign = true;
        int x = (int) Math.pow(10, s.length()-1);

        for(String str : arr) {
            if(str.equals("-")) {
                sign = false;
                x = x / 10;
                continue;
            } else if (str.equals("+")) {
                x = x / 10;
                continue;
            }

            answer += Integer.parseInt(str) * x;
            x = x / 10;
        }

        return answer = sign ? answer : answer * -1;
    }
}

