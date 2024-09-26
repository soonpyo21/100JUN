// 문제
//
// 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
//
// (), [], {} 는 모두 올바른 괄호 문자열입니다.
// 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
// 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
// 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
// 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
// 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
//
// 제한 사항
// s의 길이는 1 이상 1,000 이하입니다.

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String str = "[](){}";

        solution(str);
    }

    public static int solution(String str) {

        int len = str.length();
        int answer = 0;

        // str의 길이만큼 회전
        for(int i = 0; i < len; i ++) {
            String s = "";  // 회전된 문자열

            // s에 회전되지 않은 문자열 채우기
            for(int j = 0; j < len - i; j ++) {
                s += String.valueOf(str.charAt(j+i));
            }

            // s에 회전된 문자열 채우기
            int num = len - s.length();
            for(int k = 0; k < num; k ++) {
                s += String.valueOf(str.charAt(k));
            }

            // s의 요소를 stack에 주입하며 올바른 괄호 문자열인지 체크
            Stack<Character> stack = new Stack<>();

            for(int l = 0; l < s.length(); l ++) {
                if(stack.size() == 0) {
                    stack.push(s.charAt(l));
                } else {
                    Character c = stack.peek();
                    if((c == '[' && s.charAt(l) == ']') ||
                            (c == '{' && s.charAt(l) == '}') ||
                            (c == '(' && s.charAt(l) == ')')) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(l));
                    }
                }
            }

            if(stack.size() == 0) answer ++;
        }

        return answer;
    }
}