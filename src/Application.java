import java.io.*;
import java.util.Arrays;

// 문제
// N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
// 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
//
// 출력
// 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

public class Application {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] arr = new int[Integer.parseInt(N)];

        String su = br.readLine();
        String[] sArr = su.split(" ");

        for(int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        Arrays.sort(arr);
        bw.write(arr[0] + " " + arr[Integer.parseInt(N) - 1]);

        br.close();
        bw.close();
    }
}
