
//201204

package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {

		// 1~100까지 숫자 배열 생성

		// 짝수만 결과 출력
		IntStream is = IntStream.rangeClosed(1, 100);
		is.filter(t -> t % 2 == 0).forEach(t -> System.out.print(t));
		System.out.println(); 

		// 홀수만 결과 출력
		is = IntStream.rangeClosed(1, 100);
		is.filter((t) -> t % 2 != 0).forEach((t) -> System.out.print(t));
		System.out.println();

		// 짝수 합계
		int sumEven = IntStream.range(1, 101).filter(t -> t % 2 == 0).sum();
		System.out.println("짝수 합계: " + sumEven);

		int sumOdd = IntStream.rangeClosed(1, 100).filter(t -> t % 2 != 0).sum();
		System.out.println("홀수 합계: " + sumOdd);

		// 최고값 가져오기
		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream Kim = Arrays.stream(intAry);
		int max = Kim.max().getAsInt(); // 제일 마지막 메소드가(getAsInt) 최종 값
		System.out.println(max); // 최대값이 나오지만 한 단계 더 남았음

		// 평균
		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println(avg);

		// 조건(filter)
		Arrays.stream(intAry).filter(a -> a % 2 == 0)
		.forEach(a -> System.out.println(a));

	}// end of main
}// end of class
