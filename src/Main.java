import java.io.*;
import java.util.Scanner;

// 문제
// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
//
// 출력
// 주어진 수들 중 소수의 개수를 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        
        for(int i = 0; i < N; i ++) {
            int num = Integer.parseInt(input[i]);
            boolean isSosu = true;
            
            if(num == 2 || num == 3 || num == 5 || num == 7) {
                cnt ++;
            } else {
                for(int j = num - 1; j > 1; j --) {
                    if(num % j == 0) {
                        isSosu = false;
                    }
                }
                
                if(isSosu && num != 1) cnt ++;
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
