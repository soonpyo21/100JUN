import java.io.*;
import java.util.Scanner;

// 문제
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
//
// 출력
// 첫째 줄에 A+B를 출력한다.

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String[] Aarr = input[0].split("");
        String[] Barr = input[1].split("");
        
        int gap = 0;
        int plus = 0;
        String first = "";
        
        if(Aarr.length == Barr.length) {
            gap = 0;
        } else {
            gap = Math.abs(Aarr.length - Barr.length);
        }
        
        String[] newAarr, newBarr, result;
        
        if(Aarr.length > Barr.length) {
            newAarr = Aarr;
            newBarr = new String[Aarr.length];
            
            for(int i = 0; i < gap; i ++) {
                newBarr[i] = "0";
            }
            for(int i = 0; i < Barr.length; i ++) {
                newBarr[gap + i] = Barr[i];
            }
        } else if (Barr.length > Aarr.length) {
            newAarr = new String[Barr.length];
            newBarr = Barr;

            for(int i = 0; i < gap; i ++) {
                newAarr[i] = "0";
            }
            for(int i = 0; i < Aarr.length; i ++) {
                newAarr[gap + i] = Aarr[i];
            }
        } else {
            newAarr = Aarr;
            newBarr = Barr;
        }
        
        result = new String[newAarr.length];
        
        for(int i = newAarr.length - 1; i >= 0; i --) {
            int num = Integer.parseInt(newAarr[i]) + Integer.parseInt(newBarr[i]) + plus;
            
            if(num >= 10) {
                if(i == 0) {
                    first = "1";
                }
                result[i] = String.valueOf(String.valueOf(num).charAt(1));
                plus = 1;
            } else {
                result[i] = String.valueOf(num);
                plus = 0;
            }
        }    
        
        bw.write(first);
        for(int i = 0; i < result.length; i ++) {
            bw.write(result[i] + "");
        }
        
        br.close();
        bw.close();
    }
}
