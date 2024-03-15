// 문제
// 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
// 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
// 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.
// 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
// s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
// 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
// 문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
//
// 제한사항
// 1 ≤ s의 길이 ≤ 10,000
// s는 영어 소문자로만 이루어져 있습니다.

public class Main {

    public static void main(String[] args) {

//        String s = "banana";
//        String s = "abracadabra";
//        String s = "aaabbaccccabba";
        String s = "abaabab";

        solution(s);
    }

    public static int solution(String s) {

        int cnt1 = 0;          // x(첫글자)가 나온 횟수
        int cnt2 = 0;          // x가 아닌 글자가 나온 횟수
        int result = 0;        // 분해한 문자열의 개수
        char x = s.charAt(0);  // x

        for(int i = 0; i < s.length(); i ++) {
            // 탐색 문자가 x와 같다면 cnt1 증가, 다르다면 cnt2 증가
            if(x == s.charAt(i)) {
                cnt1 ++;
            } else {
                cnt2 ++;
            }

            // cnt1과 cnt가 같을 때 result 증가 및 cnt 초기화
            if(cnt1 == cnt2) {
                result ++;
                cnt1 = 0;
                cnt2 = 0;
                // i가 마지막이 아니라면 x값 수정
                if(i != s.length() - 1) {
                    x = s.charAt(i + 1);
                }
            }
        }

        // cnt1과 cnt2가 초기화되지 않았다면 -> 잔여 문자열에 남은 상태이므로 result 증가
        if(cnt1 != cnt2) result ++;

        System.out.println(result);

        int answer = result;
        return answer;
    }
}
