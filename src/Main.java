// 문제 (알파벳)
// 세로 R칸, 가로C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행1열) 에는 말이 놓여 있다.
// 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
// 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
// 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
//
// 입력
// 첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.
//
// 출력
// 첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

import java.util.*;

public class Main {

    private static int R, C;                // 세로칸 수, 가로칸 수
    private static int[] dx = {-1,1,0,0};   // 상,하 움직임 좌표
    private static int[] dy = {0,0,-1,1};   // 좌,우 움직임 좌표
    private static List<ArrayList<String>> list = new ArrayList<>();    // 알파벳을 담을 2차원 리스트
    private static Set<String> set = new HashSet<>();   // 중복 여부를 체크할 set
    private static int answer = 1;  // 최대 이동 거리

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        for(int i = 0; i < R; i ++) {
            list.add(new ArrayList<>());
            String[] arr = sc.nextLine().split("");
            for(int j = 0; j < C; j ++) {
                list.get(i).add(arr[j]);
            }
        }

        int[][] visit = new int[R][C];  // 이동 거리를 체크할 이차원 배열
        visit[0][0] = 1;                // 시작점 거리 세팅
        set.add(list.get(0).get(0));    // 시작점 중복 여부 세팅
        dfs(0,0, visit);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int[][] visit) {

        answer = Math.max(answer, visit[x][y]); // 이동 거리에 최대값 세팅

        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 바깥으로 이동했다면 continue
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            // set에 이미 포함된 요소라면 continue
            if(set.contains(list.get(nx).get(ny))) continue;

            set.add(list.get(nx).get(ny));      // 중복값 세팅
            visit[nx][ny] = visit[x][y] + 1;    // 이동거리 1 증가
            dfs(nx, ny, visit);                 // 재귀 호출
            set.remove(list.get(nx).get(ny));   // 다른 방향으로 다시 이동할 경우를 대비하여 중복 세팅 해제
        }
    }

}