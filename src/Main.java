// 문제 (촌수계산)
// 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
// 이러한 촌수는 다음과 같은 방식으로 계산된다.
// 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
// 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
//
// 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
//
// 입력
// 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다.
// 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
// 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
// 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
// 각 사람의 부모는 최대 한 명만 주어진다.
//
// 출력
// 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다.
// 이때에는 -1을 출력해야 한다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<ArrayList<Integer>> list = new ArrayList<>();   // 촌수 관계를 담을 이차원 리스트
    private static int N, start, end, M;                                // 각 입력값을 담을 변수
    private static boolean relative = false;                            // start와 end의 촌수 관계 유무를 담을 변수

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        // 입력값 받기
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        start = Integer.parseInt(str[0]);
        end = Integer.parseInt(str[1]);
        M = sc.nextInt();
        sc.nextLine();

        // list에 총 인원 수 만큼 기본값 세팅
        for(int i = 0; i <= N; i ++) {
            list.add(new ArrayList<>());
        }

        // 정의된 관계 수 만큼 list에 양방향으로 담는다.
        for(int i = 0; i < M; i ++) {
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            list.get(x).add(y);
            list.get(y).add(x);
        }

        /* list에 담긴 값 확인
        for(int i = 0; i < list.size(); i ++) {
            for(int j = 0; j < list.get(i).size(); j ++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        */

        int[] visit = new int[N+1]; // 각 노드의 방문 여부 및 이동 거리를 담을 배열
        dfs(visit, start);

        int answer = relative ? visit[end] : -1;
        System.out.println(answer);

    }

    private static void dfs(int[] visit, int V) {

        visit[V]++; // 방문 처리 -> 이동 거리 1 증가

        for(int i = 0; i < list.get(V).size(); i ++) {

            if(relative) return;    // 종료 조건 : 촌수 관계를 찾았다면 탐색 종료

            if(visit[list.get(V).get(i)] == 0) {    // 방문한 적 없는 노드라면
                visit[list.get(V).get(i)] = visit[V];   // 현재까지 이동한 거리를 담는다.

                if(list.get(V).get(i) == end) {
                    // 탐색 노드가 end와 같다면 관계 여부를 담고 종료 처리
                    relative = true;
                    return;
                } else {
                    // 탐색 노드가 end와 같지 않다면 다른 노드 이어서 탐색
                    dfs(visit, list.get(V).get(i));
                }
            }
        }
    }

}