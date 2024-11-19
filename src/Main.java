// 문제 (스타트링크)
// 강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.
// 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다.
// 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
// 보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다.
// U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
// 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
// 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
//
// 입력
// 첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
//
// 출력
// 첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력한다. 만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.

import java.util.*;

public class Main {

    private static int F, S, G, U, D;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);

        int[] visit = new int[F+1];
        int answer = bfs(visit);

        if(S == G) {
            System.out.println(0);
        } else if(answer == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int[] visit) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visit[S] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            int up = cur + U;
            int down = cur - D;

            if(up == G || down == G) {
                visit[G] = visit[cur];
                break;
            }

            if(up > 0 && up <= F && visit[up] == 0) {
                q.offer(up);
                visit[up] = visit[cur] + 1;
            }

            if(down > 0 && down <= F && visit[down] == 0) {
                q.offer(down);
                visit[down] = visit[cur] + 1;
            }
        }

        return visit[G];
    }

}