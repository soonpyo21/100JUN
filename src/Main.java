// 문제
// 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
// s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
// 제한사항
// str은 길이 1 이상인 문자열입니다.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String s = "Zbcdefg";

        solution(s);
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        String answer = sb.append(arr).reverse().toString();

        return answer;
    }
}

