import java.util.Scanner;

// 문제
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
// 출력
// 첫째 줄에 A+B를 출력한다.

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] arr = str.split(" ");

        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);

        if(A > 0 && B < 10) {
            System.out.println(A + B);
        }
    }

    // 모범 답안
//    import java.util.*;
//
//    interface Main{
//        static void main(String[]a){
//            Scanner s=new Scanner(System.in);
//            System.out.print(s.nextInt()+s.nextInt());}
//    }

}
