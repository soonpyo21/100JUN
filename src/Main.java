// 문제
// 함수 solution은 정수 n을 매개변수로 입력받습니다.
// n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
// 예를들어 n이 118372면 873211을 리턴하면 됩니다.
//
// 제한사항
// n은 1이상 8000000000 이하인 자연수입니다.

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        long n = 118372;

        solution(n);
    }

    public static long solution(long n) {

        String[] sArr = String.valueOf(n).split("");
        String str = "";

        Arrays.sort(sArr, Collections.reverseOrder());

        for(String s : sArr) {
            str += s;
        }

        long answer = Long.parseLong(str);
        return answer;
    }
}

