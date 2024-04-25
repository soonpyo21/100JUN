// 문제
// 정수 배열 numbers가 주어집니다.
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
// 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
// numbers의 길이는 2 이상 100 이하입니다.
// numbers의 모든 수는 0 이상 100 이하입니다.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {2,1,3,4,1};

        solution(numbers);
    }

    public static int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i ++) {
            for(int j = 0; j < numbers.length; j ++) {
                if(i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        Iterator<Integer> iterSet = set.iterator();
        while(iterSet.hasNext()) {
            result[idx] = iterSet.next();
            idx ++;
        }

        Arrays.sort(result);

        int[] answer = result;
        return answer;
    }
}

