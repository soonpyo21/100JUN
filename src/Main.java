import java.util.*;

// 문제
// 셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자.
// 예를 들어, d(75) = 75+7+5 = 87이다.
// 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다.
// 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다.
// 이런식으로 다음과 같은 수열을 만들 수 있다.
// 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
// n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다.
// 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다.
// 생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다.
// 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
// 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
//
// 입력
// 입력은 없다.
//
// 출력
// 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.

public class Main {

    public static void main(String[] args) {

        Set<Integer> notSelfNumber = new HashSet<>();
        List<Integer> selfNumber = new ArrayList<>();

        for(int i = 0; i <= 10000; i++) {
            int num = sum(i);
            notSelfNumber.add(num);
        }


        for(int i = 0; i <= 10000; i++) {

            Iterator<Integer> iter = notSelfNumber.iterator();
            int cnt = 0;
            while (iter.hasNext()) {
                if(i == iter.next()) {
                    cnt++;
                }
            }

            if(cnt == 0) {
                selfNumber.add(i);
            }
        }

        for(int i = 0; i < selfNumber.size(); i ++) {
            System.out.println(selfNumber.get(i));
        }

    }

    private static int sum(int num) {

        int length = String.valueOf(num).length();

        int[] numbers = new int[length];
        for(int i = 0; i < length; i ++) {
            numbers[i] = Character.getNumericValue(String.valueOf(num).charAt(i));
        }

        int result = num;
        for(int n : numbers) {
            result += n;
        }

        return result;
    }
}

// 어제 막혔던 이유와 해결
// 1. char 형을 int로 강제 형변환하니 ascii code로 변환됨
// - Character.getNumericValue를 이용해 인수가 나타내는 데이터 자체를 int로 변환
// 2. sum 함수의 반환값에 전달 인자로 넘어온 num을 더해주지 않아 리턴값 오류
// - result에 num + 각 자릿수를 알맞게 더해준 후 리턴
