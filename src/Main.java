import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

        String word = br.readLine().toUpperCase();
        char[] words = word.toCharArray();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i ++) {
            int cnt = 0;
            for(int j = 0; j < words.length; j ++) {
                if(words[i] == words[j]) {
                    cnt++;
                }
            }
            map.put(String.valueOf(words[i]), cnt);
        }

        int max = 0;
        String key = "";
        for(int i = 0; i < words.length; i ++) {
            if(map.get(String.valueOf(words[i])) > max) {
                max = map.get(String.valueOf(words[i]));
                key = String.valueOf(words[i]);
            }
        }

        int overlap = 0;
        for(int i = 0; i < words.length; i ++) {
            if(!key.equals(String.valueOf(words[i]))) {
                if(max == map.get(String.valueOf(words[i]))) {
                    overlap ++;
                }
            }
        }

        if(overlap == 0) {
            bw.write(key);
        } else {
            bw.write("?");
        }

        br.close();
        bw.close();
    }
}
