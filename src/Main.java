// 문제 (숨바꼭질)
// 수빈이는 동생과 숨바꼭질을 하고 있다.
// 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
// 출력
// 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int N, K;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int answer = N == K ? 0 : bfs();
        System.out.println(answer);
    }

    private static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int[] visit = new int[200000];
        visit[N] = 1;

        while(!q.isEmpty()) {
            int num = q.poll();
            int[] nums = {1,-1,num};

            for(int i = 0; i < 3; i ++) {
                int tmp = num + nums[i];

                if(tmp == K) return visit[num];

                if(tmp < 0 || tmp >= 200000) continue;

                if(visit[tmp] == 0) {
                    q.add(tmp);
                    visit[tmp] = visit[num] + 1;
                }
            }
        }

        return -1;
    }
}