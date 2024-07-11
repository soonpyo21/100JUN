// 문제
// 각 칸마다 색이 칠해진 2차원 격자 보드판이 있습니다.
// 그중 한 칸을 골랐을 때, 위, 아래, 왼쪽, 오른쪽 칸 중 같은 색깔로 칠해진 칸의 개수를 구하려고 합니다.
//
// 보드의 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board와 고른 칸의 위치를 나타내는 두 정수 h, w가 주어질 때
// board[h][w]와 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 return 하도록 solution 함수를 완성해 주세요.
//
// 이웃한 칸들 중 몇 개의 칸이 같은 색으로 색칠되어 있는지 확인하는 과정은 다음과 같습니다.
//
// 1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
// 2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
// 3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
// 4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
//    4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를 저장합니다.
//    4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.
//        4-2-a. board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가시킵니다.
// 5. count의 값을 return합니다.
// 위의 의사코드와 작동방식이 다른 코드를 작성해도 상관없습니다.
//
// 제한사항
// 1 ≤ board의 길이 ≤ 7
// board의 길이와 board[n]의 길이는 동일합니다.
// 0 ≤ h, w < board의 길이
// 1 ≤ board[h][w]의 길이 ≤ 10
// board[h][w]는 영어 소문자로만 이루어져 있습니다.

public class Main {

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"} , {"red", "red", "blue", "orange"} , {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;

        solution(board, h, w);
    }

    public static int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for(int i = 0; i < 4; i ++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if(board[h][w].equals(board[h_check][w_check])) count ++;
            }
        }

        int answer = count;
        return answer;
    }

}

