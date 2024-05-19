// 문제
// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
// 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
// 제한사항
// n은 10,000,000,000이하인 자연수입니다.

public class Main {

    public static void main(String[] args) {

        long n = 12345;

        solution(n);
    }

    public static int[] solution(long n) {

        StringBuilder sb = new StringBuilder();
        int[] answer = new int[String.valueOf(n).length()];

        for(int i = 0; i < String.valueOf(n).length(); i ++) {
            sb.append(String.valueOf(n).charAt(i));
        }

        sb.reverse();

        for(int i = 0; i < sb.length(); i ++) {
            answer[i] = sb.charAt(i) - '0';
        }

        return answer;
    }
}

