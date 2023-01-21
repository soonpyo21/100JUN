import java.io.*;
import java.util.Scanner;

// 문제
// 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
//
//  1/1	1/2	1/3	1/4	1/5	…
//  2/1	2/2	2/3	2/4	…	…
//  3/1	3/2	3/3	…	…	…
//  4/1	4/2	…	…	…	…
//  5/1	…	…	…	…	…
//  …	…	…	…	…	…
//
// 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
// X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
//
// 출력
// 첫째 줄에 분수를 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1,1 1,2 2,1 3,1 2,2 1,3 1,4 2,3 3,2

        int input = Integer.parseInt(br.readLine());
        int crossCnt = 1;       // 해당 범위의 대각선 칸 개수
        int prev_cnt_sum = 0;   // 해당 대각선 직전 대각선까지의 칸의 누적 합

        while(true) {

            // 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
            if(input <= crossCnt + prev_cnt_sum) {

                if(crossCnt % 2 == 1) { // 대각선의 개수가 홀수라면
                    // 분자가 큰 수부터 시작
                    // 분자는 대각선상 내의 블럭 개수 - (X번째 - 직전 대각선까지의 블럭 개수 -1)
                    // 분모는 X번째 - 직전 대각선까지의 블럭 개수
                    bw.write((crossCnt - (input - prev_cnt_sum - 1)) + "/" + (input - prev_cnt_sum));
                    break;
                } else { // 대각선상의 블럭의 개수가 짝수라면
                    // 홀수일 때의 출력을 반대로
                    bw.write((input - prev_cnt_sum) + "/" + (crossCnt - (input - prev_cnt_sum - 1)));
                    break;
                }
            } else {
                prev_cnt_sum += crossCnt;
                crossCnt ++;
            }
        }

        br.close();
        bw.close();

    }
}

