import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        List<Integer> hansu = new ArrayList<>();
        for(int i = 1; i <= N; i ++) {

            int[] nums = new int[String.valueOf(i).length()];
            for(int j = 0; j < nums.length; j ++) {
                nums[j] = Character.getNumericValue(String.valueOf(i).charAt(j));
            }

            if(isSameDiff(nums)) {
                hansu.add(i);
            }
        }
        bw.write(hansu.size() + "");

        br.close();
        bw.close();
    }

    private static boolean isSameDiff(int[] nums) {

        int su = 0;
        int saved = 0;
        boolean result = false;
        for(int i = 0; i < nums.length; i ++) {
            if(i + 1 < nums.length) {
                su = nums[i] - nums[i + 1];
            }

            if(i == 0) {
                saved = su;
                result = true;
            } else {
                if(saved == su) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;

    }

}

// 막혔던 이유와 해결
//
// 1. 문제 자체가 이해안됨
// 처음 풀 때 입력 받는 정수 N이 등차 수열인 경우 N보다 작은 한수를 가져오려고 했다.
// 왜 그랬는지는 나도 모르겠다
//
// 1. 등차 수열 개념 자체가 이해 안됨
// 공차를 구할 때 양수와 음수 상관없이 절대값으로 가져오는 줄 알았다.
// 뭔가 미심쩍은 부분이 있어 구글링으로 개념을 다시 잡았다.

