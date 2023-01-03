import java.io.*;
import java.util.HashSet;
import java.util.Set;

// 문제
// 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려 한다. 단, 두번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.
// 1. N에서 1을 뺀다.
// 2. N을 K로 나눈다.
// 예를 들어 N이 17, K가 4라고 가정한다. 이떄 1번의 과정을 한번 수행하면 N은 16이 된다. 이후에 2번의 과정을 두 번 수행하면 N은 1이 된다.
// 결과적으로 이 경우 전체 과정을 실행한 횟수는 3이 된다. 이는 N을 1로 만드는 최소 횟수이다.
// N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 (N<1<=N<=100,000)과 K(2<=K<=100,000)가 공백을 기준으로 하여 각각 자연수로 주어진다.
//
// 출력
// 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최솟값을 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int cnt = 0;

        while(N != 1) {
            if(N % K != 0) {
                N = N - 1;
                cnt ++;
            } else {
                N = N / K;
                cnt ++;
            }
        }

        bw.write(cnt + " ");
        br.close();
        bw.close();
    }
}
