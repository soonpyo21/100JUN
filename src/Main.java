// 문제
// 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
// 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//
// 제한사항
// strings는 길이 1 이상, 50이하인 배열입니다.
// strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
// strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
// 모든 strings의 원소의 길이는 n보다 큽니다.
// 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        solution(strings, n);
    }

    public static String[] solution(String[] strings, int n) {
        List<Character> cList = new ArrayList<>();

        for(int i = 0; i < strings.length; i ++) {
            cList.add(strings[i].charAt(n));
        }

        Collections.sort(cList);

        List<String> sList = new ArrayList<>();

        for(String s : strings) {
            sList.add(s);
        }

        String[] answer = new String[sList.size()];

        for(int i = 0; i < cList.size(); i ++) {
            for(int j = 0; j < sList.size(); j ++) {
                if(cList.get(i) == sList.get(j).charAt(n)) {
                    answer[i] = sList.get(j);
                    sList.remove(j);
                    break;
                }
            }
        }

        for(int i = 0; i < answer.length; i ++) {
            for(int j = 0; j < answer.length; j ++) {
                if(answer[i].charAt(n) == answer[j].charAt(n)) {
                    int comp = answer[i].compareTo(answer[j]);
                    if(comp < 0) {
                        String temp = answer[i];
                        String temp2 = answer[j];
                        answer[j] = temp;
                        answer[i] = temp2;
                    }
                }
            }
        }

        return answer;
    }
}

