// 문제
// 수포자는 수학을 포기한 사람의 준말입니다.
// 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
// 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
// 제한사항
// 시험은 최대 10,000 문제로 구성되어있습니다.
// 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5};
        solution(answers);
    }

    public static int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

        int point1 = 0;
        int point2 = 0;
        int point3 = 0;

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        for(int i = 0; i < answers.length; i ++) {

            if(answers[i] == supo1[idx1]) point1 ++;
            if(answers[i] == supo2[idx2]) point2 ++;
            if(answers[i] == supo3[idx3]) point3 ++;

            if(idx1 == supo1.length-1) idx1 = -1;
            if(idx2 == supo2.length-1) idx2 = -1;
            if(idx3 == supo3.length-1) idx3 = -1;

            idx1 ++;
            idx2 ++;
            idx3 ++;
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(point1, point2);
        max = Math.max(max, point3);

        if(point1 == max) list.add(1);
        if(point2 == max) list.add(2);
        if(point3 == max) list.add(3);

        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i ++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

