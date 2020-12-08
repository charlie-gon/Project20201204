
//201204

package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		
		
		List<String> strList = Arrays.asList("Java8 lambda","stream mapping");
		strList.stream().flatMap(new Function<String, Stream<String>>(){

			@Override
			public Stream<String> apply(String t) {
				//t가 가지고 있는 문자를 split 이라는 메소드로 구분
				//문자열 배열을 문자열 stream으로 만들기
				return Arrays.stream(t.split(" "));
			}
			
		}).filter(s -> s.startsWith("s")).forEach(s -> System.out.println(s));
		
		strList.stream()
		.map(new Function<String, String>(){

			@Override
			public String apply(String t) {
				return t.toUpperCase(); 
			}
			
		}).forEach(s -> System.out.println(s));
		
		List<Student> students = Arrays.asList(
				new Student("송가희", "F", 80),
				new Student("하야시", "M", 75),
				new Student("수지", "F", 85),
				new Student("김두한", "M", 90)
				);
//		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {
//
//			@Override
//			public int applyAsInt(Student score) {
//				return score.getScore();
//			}
//			
//		}).average().getAsDouble();
//		System.out.println(avg);
		
		//
		double avg = students.stream().mapToInt(score -> score.getScore())
				.average().getAsDouble();
		System.out.println(avg);
		
		
		
	}//end of my life

}//end of class
