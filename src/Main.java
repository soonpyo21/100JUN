// 문제
// 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//
// 제한사항
// s는 길이가 1 이상, 100이하인 스트링입니다.

public class Main {

    public static void main(String[] args) {
        String s = "abcde";
        solution(s);
    }

    public static String solution(String s) {
        int len = s.length();
        String answer = len % 2 == 0 ? s.substring(len/2-1, len/2+1) : s.substring(len/2, len/2+1);

        return answer;
    }
}

