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

        int first = 0;
        int second = 0;

        List<Integer> hansu = new ArrayList<>();
        for(int i = 1; i < String.valueOf(N).length(); i ++) {

            if(i < 10) {
                hansu.add(i);
            } else {
                int[] nums = new int[String.valueOf(N).length()];
                for(int j = 0; j < nums.length; j ++) {
                    nums[i] = Character.getNumericValue(String.valueOf(N).charAt(j));
                }

                if(isSameDiff(nums)) {
                    hansu.add(i);
                }
            }
        }

        for(int i = 0; i < hansu.size(); i ++) {
            System.out.println("한수 : " + hansu.get(i));
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
                if (nums[i] > nums[i + 1]) {
                    su = nums[i] - nums[i + 1];
                } else {
                    su = nums[i + 1] - nums[i];
                }
            }

            if(i == 0) {
                saved = su;
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
