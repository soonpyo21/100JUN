// 문제
// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//
// 제한사항
// n은 0 이상 3000이하인 정수입니다.

public class Main {

    public static void main(String[] args) {

        int n = 12;

        solution(n);
    }

    public static int solution(int n) {

        int answer = 0;

        for(int i = 1; i <= Math.sqrt(n); i ++) {
            if(n % i == 0) {
                answer += i;
                if(n / i != i) answer += n / i;
            }
        }

        return answer;
    }
}

