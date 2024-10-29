// 문제 (단지번호붙이기)
// <그림 1>과 같이 정사각형 모양의 지도가 있다.
// 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
// 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
// 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
// <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
// 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
//
// 출력
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int N;
    private static List<ArrayList<Integer>> list = new ArrayList<>();
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        // 지도를 담을 list 세팅
        for(int i = 0; i < N; i ++) {
            list.add(new ArrayList<>());
            String[] arr = sc.nextLine().split("");

            for(int j = 0; j < N; j ++) {
                list.get(i).add(Integer.parseInt(arr[j]));
            }
        }

        int[][] visit = new int[N][N];            // 방문 여부를 표시할 배열
        List<Integer> answer = new ArrayList<>(); // 결과를 담을 list

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(list.get(i).get(j) == 1 && visit[i][j] == 0) {
                    answer.add(bfs(i, j, visit));
                }
            }
        }

        Collections.sort(answer);
        answer.add(0, answer.size());

        for(int i : answer) System.out.println(i);
    }

    private static int bfs(int i, int j, int[][] visit) {
        Queue<Point> q = new LinkedList<>();    // bfs 탐색을 위한 큐 생성
        q.offer(new Point(i, j));               // 초기값 세팅
        visit[i][j] = 1;                        // 방문 체크
        int cnt = 1;                            // 탐색 중인 단지 안의 집 개수

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            // 상, 하, 좌, 우 네방향 이동 체크
            for(int k = 0; k < 4; k ++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;    // 지도를 벗어났다면 무시
                if(list.get(nx).get(ny) == 0) continue;                 // 집이 없는 곳이라면 무시

                if(visit[nx][ny] == 0) {        // 방문하지 않은 집인 경우
                    q.offer(new Point(nx,ny));
                    visit[nx][ny] = 1;
                    cnt ++;
                }
            }
        }

        return cnt;
    }

}