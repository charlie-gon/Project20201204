
//201204
//Student class

package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
	
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong","MALE",70),
				new Student("Hwang","FEMALE",80),
				new Student("Park","MALE",90),
				new Student("Choi","FEMALE",85)
				);
		
		//여학생 정보(이름, 점수)
		for(Student student : list) {
			if(student.getSex().equals("FEMALE")) {
				System.out.println("여학생 정보: " + student.getName() + " " + student.getScore());
			}
		}
		
		//전체학생(점수 80점 초과하는 학생)
		for(Student student : list) {
			if(student.getScore() > 80) {
				System.out.println("80점 초과하는 학생: " + student.getName() + " " + student.getScore());
			}
		}
		
		//남학생의 총점
		int sum = 0;
		for(Student student : list) {
			if(student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생의 총점: " + sum);
		
		//여학생의 평균
		int count = 0;
		double femaleSum = 0;
		for(Student student : list) {
			if(student.getSex().equals("FEMALE")) {
				count ++;
				femaleSum += student.getScore();
			}
		}
		System.out.println("여학생 평균: " + femaleSum / count);
		
		
		
	}

}
