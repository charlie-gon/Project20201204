
//201204
//Student class

package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70), new Student("Hwang", "FEMALE", 80),
				new Student("Park", "MALE", 90), new Student("Choi", "FEMALE", 85));

		// 여학생 정보(이름, 점수)
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println("여학생 정보: " + student.getName() + " " + student.getScore());
			}
		}

		// 전체학생(점수 80점 초과하는 학생)
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println("80점 초과하는 학생: " + student.getName() + " " + student.getScore());
			}
		}

		// 남학생의 총점
		int sum = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생의 총점: " + sum);

		// 여학생의 평균
		int count = 0;
		double femaleSum = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				count++;
				femaleSum += student.getScore();
			}
		}
		System.out.println("여학생 평균: " + femaleSum / count);

		// 반복문(반복자) : 스트림(반복자)
		// 스트림 생성 -> 소진
		
		
		// Stream - // 여학생 정보(이름, 점수)
		Stream<Student> stream = list.stream();
		stream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getSex().equals("MALE");
			}

		}); // filter 메소드로 조건 추가
		stream = list.stream(); //stream은 한 번 사용하면 소진되기 때문에 재사용시 다시 선언해야 함
		
		stream.filter(new Predicate<Student>() { 

			@Override
			public boolean test(Student t) {
				return t.getScore() > 80;
			}
			
		}).forEach(new Consumer<Student>() {// stream 요소 각각에 대해 forEach 실행

			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + " " + t.getScore());
			}

		});
		
		// Stream - 전체학생(점수 80점 초과하는 학생)
		stream = list.stream(); //stream은 한 번 사용하면 다시 생성해야 한다
		stream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getScore() > 80;
			}
			
		}).forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + " " + t.getScore());
				
			}
			
		});
		
		// Stream - 전체학생(점수 80점 초과하는 학생) / 간결하게
		stream.filter((t) -> t.getScore() > 80)//
		.forEach((t) -> System.out.println(t.getName() + " " + t.getScore()));
		
		int sum1 = list.stream().filter(t-> t.getSex().equals("MALE"))//
		.mapToInt((value) -> value.getScore()) //Student의 score값만(int 타입)만 가져오겠음
		.sum();
		
		double avg = list.stream().filter(t -> t.getSex().equals("FEMALE"))
		.mapToInt(s -> s.getScore())
		.average()
		.getAsDouble();
		System.out.println("평균: " + avg);
			
			

	
			
	
		
	}

}
