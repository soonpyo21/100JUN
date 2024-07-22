// 문제
// 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
//
// 예를들어
//
// F(2) = F(0) + F(1) = 0 + 1 = 1
// F(3) = F(1) + F(2) = 1 + 1 = 2
// F(4) = F(2) + F(3) = 1 + 2 = 3
// F(5) = F(3) + F(4) = 2 + 3 = 5
// 와 같이 이어집니다.
//
// 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
//
// 제한사항
// n은 2 이상 100,000 이하인 자연수입니다.

public class Main {

    public static void main(String[] args) {
        int n = 3;

        solution(n);
    }

    public static int solution(int n) {

        int prev1 = 0; //f(0)
        int prev2 = 1; //f(1)
        int answer = 0;

        for(int i = 2; i <= n; i ++) {
            answer = (prev1 % 1234567 + prev2 % 1234567) % 1234567;
            prev1 = prev2;
            prev2 = answer;
        }

        return answer;
    }

}

