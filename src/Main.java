import java.io.*;

// 문제
// 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
// N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
//
// 출력
// 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int first = 0;
        int second = 0;

        for(int i = 0; i < String.valueOf(N).length(); i ++) {
            if(i == 0) {
                first = Character.getNumericValue(String.valueOf(N).charAt(i));
            } else {
                if(i + 1 < String.valueOf(N).length()) {
                    first = Character.getNumericValue(String.valueOf(N).charAt(i));
                    second = Character.getNumericValue(String.valueOf(N).charAt(i+1));

                    int distance = 0;
                    int saved = 0;

                    if(first > second) {
                        distance = first - second;
                    } else if(second > first) {
                        distance = second = first;
                    }

                    if(saved != distance) {
                        break;
                    }

                    saved = distance;
                }
            }






        }

        br.close();
        bw.close();


    }

}
