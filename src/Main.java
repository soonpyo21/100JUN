// 문제
// 자연수 n이 매개변수로 주어집니다.
// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
// n은 1 이상 100,000,000 이하인 자연수입니다.

public class Main {

    public static void main(String[] args) {

        int n = 45;

        solution(n);

    }

    public static int solution(int n) {

        StringBuilder sb = new StringBuilder();
        int result = 0;
        int num = 1;

        while(n > 0) {
            sb.append(n % 3);
            n = n / 3;
        }

        for(int i = sb.length() - 1; i >= 0; i --) {
            result += (sb.charAt(i) - '0') * num;
            num *= 3;
        }

        int answer = result;
        return answer;
    }
}

