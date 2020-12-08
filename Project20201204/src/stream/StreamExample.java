
//201204
//교재 798페이지 표 참고

package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		
		//stream은 컬렉션이나 배열로부터 생성됨
		 
		List<String>list = null;
		list = Arrays.asList("Hong","Hwang","Park","Choi", "Kim");
		
		Stream<String>stream = list.stream(); //앞서 생성된, 문자열을 담는 list
		
		//boolean 타입 리턴(매개변수기 predicate 이므로)
		//filter메소드로 조건부여
//		stream.filter(new Predicate<String>(){
//
//			@Override
//			public boolean test(String t) {
//				return t.length() > 3;
//			}
//			
//		}).forEach(new Consumer<String>() { //forEach 메소드로 값 삽입
//
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//			
//		});
		
		
		stream.filter((t) -> t.length() > 3).forEach((t) -> System.out.println(t));
		
		//Stream 간단 요약
		//IntStream: Stream<Integer>, LongStream: Stream<Long>, DoubleStream: Stream<Double>
		
		//String 배열
		String[] strAry = {"Hong","Hwang","Park"};
		Stream<String> strStream = Arrays.stream(strAry);
		
		int[] intAry = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();
		System.out.println("합: " + sum);
		
		double[] dblAry = {1.1,2.2,3.3,4.4,5.5};
		DoubleStream dblStream = Arrays.stream(dblAry);
		dblStream.forEach(new DoubleConsumer(){
			double result = 0;

			@Override
			public void accept(double value) {
				result += value; //forEach로 하나씩 출력된 값을 더하기
				System.out.println(result);
			}
			
		});
		
		IntStream is = IntStream.range(1, 10);
		is.forEach(n -> System.out.println(n));
		
		is = IntStream.rangeClosed(1, 10); //1에서 10까지 값을 모두 리턴 및 합계
		System.out.println(is.sum());
		
		
		
		Path path = Paths.get("list.txt"); //C:\git\Project20201204\Project20201204 경로에 저장된 list.txt 파일 가져오기
		try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		path = Paths.get("c:/");
		try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
