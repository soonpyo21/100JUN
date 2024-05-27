// 문제
// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
// 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
// (1은 소수가 아닙니다.)
//
// 제한사항
// n은 2이상 1000000이하의 자연수입니다.

public class Main {

    public static void main(String[] args) {

        int n = 10;

        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i ++) {
            if(arr[i] == true) continue;

            for(int j = i * i; j < arr.length; j = j + i) {
                arr[j] = true;
            }
        }

        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] == false) answer ++;
        }

        return answer;
    }
}

