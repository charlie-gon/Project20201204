package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//120207

public class CollectorExample {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("Hong", 80), new Student("Park", 90), new Student("Choi", 87));

//		list.stream().filter(s -> s.getScore() / 10 == 8)
//		.forEach(System.out :: println); //Student 클래스에 toString 오버라이딩 작업 필요

		// Collect 사용
		// 오름차순 정렬
		List<Student> student80s = list.stream().filter(s -> s.getScore() / 10 == 8).sorted() // stream 정렬 메소드. 사용하기 위해
																								// Student 클래스에
																								// Comparable 인터페이스 작성 및
																								// compareTo 메소드 재정의 필요
				.collect(Collectors.toList());

		for (Student student : student80s) {
			System.out.println(student.getName() + " " + student.getScore());
		}

		// tomap 메소드
//		list.stream().filter(s -> s.getScore() / 10 == 8)
//					.sorted()
//					.collect(
//						Collectors.toMap(
//								new Function<Student, String>() {
//
//									@Override
//									public String apply(Student t) {
//										return t.getName();
//									}
//								}, new Function<Student, Integer>() {
//
//									@Override
//									public Integer apply(Student t) {
//										return t.getScore();
//									}
//				}) //end of toMap
//			); //end of collect

		Map<String, Integer> map = list.stream()
				.filter(s -> s.getScore() / 10 == 8)
				.sorted()
				.collect(
						Collectors.toMap(
								(t) -> t.getName(), 
								(t) -> t.getScore()
								)
				);
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("Key: " + key + " " + "Value: " + map.get(key));
		}

	}

}
