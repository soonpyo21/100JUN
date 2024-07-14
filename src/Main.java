// 문제
// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
// 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
//
// 제한사항
// s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

public class Main {

    public static void main(String[] args) {
        String s = "1 2 3 4";

        solution(s);
    }

    public static String solution(String s) {

        String[] arr = s.split(" ");
        int num = Integer.parseInt(arr[0]);
        int max = num;
        int min = num;

        for(int i = 1; i < arr.length; i ++) {
            num = Integer.parseInt(arr[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        String answer = min + " " + max;
        return answer;
    }

}

