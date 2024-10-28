// 문제 (백준-바이러스)
// 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
// 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
// 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
// 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
// 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
// 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
// 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
//
// 출력
// 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다

import java.util.*;

public class Main {

    static int answer = 0;  // 1번 컴퓨터에 의해 감염된 컴퓨터의 수

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 컴퓨터의 총 갯수
        int M = sc.nextInt();   // 연결된 컴퓨터의 간선 갯수
        sc.nextLine();

        List<ArrayList<Integer>> list = new ArrayList<>();  // 각 컴퓨터의 연결 정보를 담을 list
        // 컴퓨터의 갯수만큼 list 초기화
        for(int i = 0; i <= N; i ++) {
            list.add(i, new ArrayList<>());
        }

        // 입력된 컴퓨터의 연결 정보 list에 저장
        for(int i = 1; i <= M; i ++) {
            String[] input = sc.nextLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            list.get(s).add(e);
            list.get(e).add(s);
        }

        /* list 출력
        for(int i = 0; i < list.size(); i ++) {
            for(int j = 0; j < list.get(i).size(); j ++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        */

        boolean[] visit = new boolean[list.size()]; // 방문 여부를 표시할 배열
        dfs(list, visit, 1);
        System.out.println(answer);
    }

    private static void dfs(List<ArrayList<Integer>> list, boolean[] visit, int V) {
        visit[V] = true;

        for(int i = 0; i < list.get(V).size(); i ++) {
            if(visit[list.get(V).get(i)] != true) { // 방문한 적 없는 노드라면 컴퓨터 카운팅 후 재탐색
                answer ++;
                dfs(list, visit, list.get(V).get(i));
            }
        }
    }

}
