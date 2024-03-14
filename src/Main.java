// 문제
// 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
// 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
//
// b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
// n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
// a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
// 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
//
// 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
//
// 제한사항
// 1 ≤ s의 길이 ≤ 10,000
// s은 영어 소문자로만 이루어져 있습니다.

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        String s = "banana";
//        String s = "foobar";
        String s = "baaab";

        solution(s);
    }

    public static int[] solution(String s) {

        int[] idxList = new int[s.length()];            // 결과 리스트
        Map<String, Integer> idxMap = new HashMap<>();  // 각 알파벳의 마지막 탐색 인덱스를 담을 맵

        // 각 알파벳의 탐색 인덱스를 -1 로 초기 세팅
        for(int i = 0; i < s.length(); i ++) {
            idxMap.put(String.valueOf(s.charAt(i)), -1);
        }

        for(int i = 0; i < s.length(); i ++) {
            String str = String.valueOf(s.charAt(i));        // 탐색값
            if(idxMap.get(str) > -1) {                       // 탐색값의 탐색 인덱스가 초기값보다 크다면 (이전에 탐색된 값이라면)
                int idx = s.indexOf(str, idxMap.get(str));
                idxList[i] = i - idx;                        // 탐색 중인 인덱스 - 마지막 탐색 인덱스
                idxMap.put(str, idx + 1);                    // 마지막 탐색 인덱스는 + 1 해주어 재탐색을 방지한다.
            } else {
                idxList[i] = -1;
                idxMap.put(str, 0);                          // 초기값이 들어온 경우 0으로 인덱스 재세팅
            }
        }

        for(int i : idxList) {
            System.out.println(i);
        }

        int[] answer = idxList;
        return answer;
    }
}
