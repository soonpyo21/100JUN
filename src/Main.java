import java.io.*;

// 문제
// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
// 단, 대문자와 소문자를 구분하지 않는다.
//
// 입력
// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
// 출력
// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
// 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] words = br.readLine().toUpperCase().toCharArray();
        int[] arr = new int[26];

        int max = 0;
        String key = "";
        for(int i = 0; i < words.length; i ++) {
            arr[words[i] - 65] ++;
            if(arr[words[i] - 65] > max) {
                max = arr[words[i] - 65];
                key = String.valueOf(words[i]);
            } else if (arr[words[i] - 65] == max) {
                key = "?";
            }
        }

        bw.write(key);
        br.close();
        bw.close();
    }
}

// 막혔던 이유와 해결

// 1. 순수한 자바 실력 부족, 뇌역량 부족
// 배열의 크기를 영문자 수만큼 선언해놓고 ++ 처리를 하면 굳이 문자를 하나씩 비교하면서 카운트를 세지 않아도 된다.
// 라는 사실을 인지 못했다. 사실 처음부터 생각을 못했다. 너무 의식의 흐름대로 단순히만 생각했던 것 같다.
// 위처럼 처리를 하면 반복문 안에서 cnt를 만드는 비용을 줄일 수 있고,
// 무엇보다 문자를 하나씩 비교해가면서 이중 반복을 돌릴 필요가 없다.
// 2. 쓸데 없는 반복문 남용으로 인한 시간 초과
// 자꾸만 시간 초과가 걸리는 데도 줄일 수 있는 만큼 줄였다고 생각했다.
// 반복문 덩어리 하나가 'arr[words[i] - 65] ++;' 라는 코드 한줄로 요약이 되는데도 말이다.
// 3. 구글링
// 끝이 보이질 않아 구글링 후 다른 사람의 코드를 보고 도움을 얻었다.
// 백준을 풀면서 처음 해 본 검색이었다.
// 문제를 풀었음에도, 사실 이게 최선의 코드가 맞는지 의문이 든다.
// 당장 내 코드가 더 깔끔해보여도 성능은 구글링한 코드가 더 좋은 게 아닌지
// 현재로서는 정확히 분간이 가질 않는다.
// 앞으로 더 열심히 해야겠다 ..