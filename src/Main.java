// 문제 (백준-DFS와 BFS)
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
// 정점 번호는 1번부터 N번까지이다.
//
// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
// 입력으로 주어지는 간선은 양방향이다.
//
// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);   // 정점의 개수
        int M = Integer.parseInt(str[1]);   // 간선의 개수
        int V = Integer.parseInt(str[2]);   // 탐색을 시작할 정점의 번호

        List<ArrayList<Integer>> list = new ArrayList<>();  // 간선을 입력받을 이차원 list
        for(int i = 0; i <= N; i ++) {
            // 정점의 개수만큼 기본값 입력
            list.add(i, new ArrayList<>());
        }

        for(int i = 1; i <= M; i ++) {
            String[] input = sc.nextLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            list.get(s).add(e);
            list.get(e).add(s); // 양방향 입력 고려
        }

        // list 오름차순 정렬
        for(int i = 1; i < list.size(); i ++) {
            Collections.sort(list.get(i));
        }

        /* 현재까지 list 출력
        for(int i = 0; i < list.size(); i ++) {
            for(int j = 0; j < list.get(i).size(); j ++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        */

        boolean[] visit_dfs = new boolean[N+1];
        List<Integer> answer_dfs = new ArrayList<>();
        answer_dfs = dfs(list, visit_dfs, answer_dfs, V);

        boolean[] visit_bfs = new boolean[N+1];
        List<Integer> answer_bfs = new ArrayList<>();
        answer_bfs = bfs(list, visit_bfs, answer_bfs, V);

        for(int i = 0; i < answer_dfs.size(); i ++) {
            System.out.print(answer_dfs.get(i));
            if(i != answer_dfs.size()-1) System.out.print(" ");
        }

        System.out.println();

        for(int i = 0; i < answer_bfs.size(); i ++) {
            System.out.print(answer_bfs.get(i));
            if(i != answer_bfs.size()-1) System.out.print(" ");
        }
    }

    private static List<Integer> dfs(List<ArrayList<Integer>> list, boolean[] visit_dfs, List<Integer> answer_dfs, int V) {
        answer_dfs.add(V);      // 방문 노드 추가
        visit_dfs[V] = true;    // 방문 표시

        for(int i = 0; i < list.get(V).size(); i ++) {
            if(visit_dfs[list.get(V).get(i)] != true) { // 방문하지 않은 노드인 경우
                dfs(list, visit_dfs, answer_dfs, list.get(V).get(i));
            }
        }

        return answer_dfs;
    }

    private static List<Integer> bfs(List<ArrayList<Integer>> list, boolean[] visit_bfs, List<Integer> answer_bfs, int V) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(V); // 큐에 초기데이터(들) 삽입
        answer_bfs.add(V);
        visit_bfs[V] = true;

        while(q.size() != 0) {
            int cur = q.poll();
            for(int i = 0; i < list.get(cur).size(); i ++) {
                if(visit_bfs[list.get(cur).get(i)] != true) {   // 방문하지 않은 노드 -> 큐 삽입
                    q.offer(list.get(cur).get(i));
                    answer_bfs.add(list.get(cur).get(i));
                    visit_bfs[list.get(cur).get(i)] = true;
                }
            }

        }

        return answer_bfs;
    }

}
