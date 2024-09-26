// 문제
//
// 철호는 수열을 가지고 놀기 좋아합니다.
// 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다.
// 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다.
// 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
// 원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
// 원형 수열의 모든 원소 elements가 순서대로 주어질 때,
// 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
//
// 제한 사항
// 3 ≤ elements의 길이 ≤ 1,000
// 1 ≤ elements의 원소 ≤ 1,000

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        solution(elements);
    }

    public static int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int len = elements.length;

        // 길이 1부터 len까지 구간별 합산 구하기
        for(int i = 1; i <= len; i ++) {

            // j : 구간합을 하는 시작점(시작 인덱스)
            for(int j = 0; j < len; j ++) {
                int num = 0;

                // 현재 구간의 길이만큼 값 합산
                for(int k = 0; k < i; k ++) {
                    num += elements[(j + k) % len]; // 인덱스 초과 오류를 모듈러 연산으로 처리
                }

                set.add(num);
            }
        }

        return set.size();
    }
}