// 문제
// 두 정수 left와 right가 매개변수로 주어집니다.
// left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
// 1 ≤ left ≤ right ≤ 1,000

public class Main {

    public static void main(String[] args) {

        int left = 13;
        int right = 17;

        solution(left, right);

    }

    public static int solution(int left, int right) {

        int result = 0;

        for(int i = left; i <= right; i ++) {
            int cnt = 0;
            int sqrt = (int) Math.sqrt(i);

            for(int j = 1; j <= sqrt; j ++) {
                if(i % j == 0) {
                    cnt ++;
                    if(i / j != j) {
                        cnt ++;
                    }
                }
            }

            if(cnt % 2 == 0) {
                result += i;
            } else {
                result -= i;
            }

        }

        int answer = result;
        return answer;
    }
}

