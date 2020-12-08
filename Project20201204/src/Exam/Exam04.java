package Exam;

import java.util.Arrays;
import java.util.List;

//201208
//시험문제 4

public class Exam04 {
	public static void main(String[] args) {
		List<Student> student = Arrays.asList(
			new Student("Hong", 100, 89), 
			new Student("Hwang", 50, 45),
			new Student("Park", 1, 10),
			new Student("Choi", 25, 89)
			); 
		
		//시험점수 총합이 100점이 안 되는 학생들의 이름,점수 출력
		student.stream()
		.filter((s) -> (s.getMathScore() + s.getEngScore() < 100))
		.forEach(
				t -> System.out.println("이름: " + t.getName() + " 수학점수: " + t.getMathScore() + " 영어점수: " + t.getEngScore()));
	}
	
	
	

}
