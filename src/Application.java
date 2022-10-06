import java.io.*;

// 문제
// 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
//
// 입력
// 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
// 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
// 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
//
// 출력
// 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

public class Application {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] C = new int[Integer.parseInt(br.readLine())];
        double[] averages = new double[C.length];

        for(int i = 0; i < C.length; i ++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);

            int sum = 0;
            for(int j = 1; j < input.length; j ++) {
                sum += Integer.parseInt(input[j]);
            }

            int cnt = 0;
            for(int k = 1; k < input.length; k ++) {
                if(Integer.parseInt(input[k]) > sum/N) {
                    cnt ++;
                }
            }

            averages[i] = (cnt+0.0)/N *100;
        }

        for(double a : averages) {
            bw.write(String.format("%.3f", a) + "%" + "\n");
        }

        br.close();
        bw.close();
    }
}

