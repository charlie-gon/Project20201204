package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

//120207

public class ReduceExample {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student("Hong", 80), 
				new Student("Hong", 90), 
				new Student("Hong", 87));

		// 점수합계

//	int sum = list.stream().mapToInt(new ToIntFunction<Student>() {
//
//		@Override
//		public int applyAsInt(Student value) {
//			return value.getScore();
//		}
//	}).sum();
//	System.out.println(sum);

		// 람다식 사용
//	int sum = list.stream().mapToInt(s -> s.getScore()).sum();
//	System.out.println(sum);

		// reduce 사용_변수 한 개 사용
		int result = list.stream()//
				.mapToInt(t -> t.getScore())//
				.reduce(new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						System.out.println(left + " " + right);
						return left + right;
					}
				}).getAsInt();
		System.out.println("결과값: " + result);

		// reduce 사용_변수 두 개 사용
		result = list.stream()//
				.mapToInt(t -> t.getScore()).reduce(0, new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						System.out.println(left + " " + right);
						return left + right;
					}
				});
		System.out.println(result);

		// reduce 활용한 최대값 리턴
		result = list.stream().mapToInt(t -> t.getScore()).reduce((left, right) -> left > right ? left : right)
				.getAsInt();
		System.out.println(result);

		// reduce 활용한 평균 리턴
		result = list.stream().mapToInt(t -> t.getScore()).
				reduce((left, right) -> (left + right) / 2)
				.getAsInt();
				
		System.out.println(result);
		

	}

}
