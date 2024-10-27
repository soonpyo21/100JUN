// 문제 (백준-미로 탐색)
// N×M크기의 배열로 표현되는 미로가 있다.
//
// 1	0	1	1	1	1
// 1	0	1	0	1	0
// 1	0	1	0	1	1
// 1	1	1	0	1	1
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
// 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
// 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
// 입력
// 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
// 각각의 수들은 붙어서 입력으로 주어진다.
//
// 출력
// 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

import java.util.*;
import java.awt.Point;

public class Main {

    // 이동할 네가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static int N,M;                                              // 입력값 N(행), M(열)
    public static List<ArrayList<Integer>> list = new ArrayList<>();    // 미로를 표현할 2차원 list

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        // 행의 크기만큼 기본값 입력
        for(int i = 0; i < N; i ++) {
            list.add(i, new ArrayList<>());
        }

        // 미로를 list에 입력
        for(int i = 0; i < N; i ++) {
            String[] input = sc.nextLine().split("");
            for(int j = 0; j < M; j ++) {
                list.get(i).add(Integer.parseInt(input[j]));
            }
        }

        int answer = bfs(0,0);
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();    // bfs 구현을 위해 Queue 자료형 사용
        q.offer(new Point(x, y));               // 초기값 (0,0) 입력

        while(!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            if(x == N-1 && y == M-1) return list.get(x).get(y); // 현재 좌표가 최우측 하단일 경우 탐색하지 않고 return

            // 현재 위치에서 4가지 방향으로 위치 이동 (상, 하, 좌, 우)
            for(int i = 0; i < 4; i ++) {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;    // 현재 좌표가 정해진 미로의 공간을 벗어난 경우 무시
                if(list.get(ni).get(nj) == 0) continue;                 // 통과할 수 없는 공간(0)인 경우 무시
                if(list.get(ni).get(nj) == 1) {                         // 해당 노드를 처음 방문하는 경우 최단 거리 + 1 기록
                    list.get(ni).set(nj, list.get(x).get(y) + 1);
                    q.offer(new Point(ni, nj));

                    /* 바뀐 미로 형태 확인
                    for(int k = 0; k < N; k ++) {
                        for(int l = 0; l < M; l ++) {
                            System.out.print(list.get(k).get(l) + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    */
                }
            }
        }
        // 최우측 하단까지의 최단 거리 반환
        return list.get(x).get(y);
    }

}
